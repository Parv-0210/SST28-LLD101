public interface EligibilityRule {
    boolean isSatisfied(StudentProfile student);

    String getFailureReason();
}
