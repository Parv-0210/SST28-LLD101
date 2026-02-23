public class OnboardingService {
    private final StudentRepository repository;
    private final InputParser parser;
    private final StudentValidator validator;
    private final RegistrationOutputHandler outputHandler;

    public OnboardingService(StudentRepository repository) {
        this.repository = repository;
        this.parser = new InputParser();
        this.validator = new StudentValidator();
        this.outputHandler = new RegistrationOutputHandler();
    }

    public void registerFromRawInput(String raw) {
        outputHandler.printInput(raw);

        ParsedInput parsed = parser.parse(raw);
        ValidationResult validation = validator.validate(parsed);

        if (!validation.isValid) {
            outputHandler.printValidationErrors(validation.errors);
            return;
        }

        String id = IdUtil.nextStudentId(repository.getTotalCount());
        StudentRecord record = new StudentRecord(id, parsed.name, parsed.email, parsed.phone, parsed.program);

        repository.save(record);

        outputHandler.printSuccessAndConfirmation(id, repository.getTotalCount(), record);
    }
}
