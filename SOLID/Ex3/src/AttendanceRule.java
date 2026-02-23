public class AttendanceRule implements EligibilityRule {
    private static final int MIN_ATTENDANCE = 75;

    @Override
    public boolean isSatisfied(StudentProfile student) {
        return student.attendancePct >= MIN_ATTENDANCE;
    }

    @Override
    public String getFailureReason() {
        return "attendance below 75";
    }
}
