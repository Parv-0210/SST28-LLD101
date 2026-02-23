import java.util.*;

public class StudentValidator {
    private static final List<String> ALLOWED_PROGRAMS = List.of("CSE", "AI", "SWE");

    public ValidationResult validate(ParsedInput input) {
        List<String> errors = new ArrayList<>();

        if (input.name.isBlank()) {
            errors.add("name is required");
        }
        if (input.email.isBlank() || !input.email.contains("@")) {
            errors.add("email is invalid");
        }
        if (input.phone.isBlank() || !input.phone.chars().allMatch(Character::isDigit)) {
            errors.add("phone is invalid");
        }
        if (!ALLOWED_PROGRAMS.contains(input.program)) {
            errors.add("program is invalid");
        }

        boolean isValid = errors.isEmpty();
        return new ValidationResult(isValid, errors);
    }
}

class ValidationResult {
    public final boolean isValid;
    public final List<String> errors;

    public ValidationResult(boolean isValid, List<String> errors) {
        this.isValid = isValid;
        this.errors = errors;
    }
}
