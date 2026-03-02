public interface ClubAdminTools {
    void addIncome(double amt, String note);
    void addExpense(double amt, String note);
}
public interface MinutesAdmin {
    void addMinutes(String text);
}
public interface EventAdmin {
    void createEvent(String name, double budget);
    int getEventsCount();
}
