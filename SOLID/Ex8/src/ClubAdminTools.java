public interface ClubAdminTools {
    void addIncome(double amt, String note);
    void addExpense(double amt, String note);
}
interface MinutesAdmin {
    void addMinutes(String text);
}
interface EventAdmin {
    void createEvent(String name, double budget);
    int getEventsCount();
}
