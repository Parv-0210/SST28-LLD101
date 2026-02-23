public class DisciplinaryRule implements EligibilityRule {
    @Override
    public boolean isSatisfied(StudentProfile student) {
        return student.disciplinaryFlag == LegacyFlags.NONE;
    }

    @Override
    public String getFailureReason() {
        return "disciplinary flag present";
    }
}
