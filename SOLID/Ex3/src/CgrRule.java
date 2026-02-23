public class CgrRule implements EligibilityRule {
    private static final double MIN_CGR = 8.0;

    @Override
    public boolean isSatisfied(StudentProfile student) {
        return student.cgr >= MIN_CGR;
    }

    @Override
    public String getFailureReason() {
        return "CGR below 8.0";
    }
}
