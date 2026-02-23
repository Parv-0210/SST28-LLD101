public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    /*
     * Contract: send(n) delivers the notification through the specific channel.
     * Precondition: notification must not be null; required fields for channel must be present.
     * Postcondition: notification is sent; postcondition enforced through subclass contracts.
     * 
     * All senders must:
     * - Document which fields they use (e.g., email uses email field)
     * - Not silently truncate or modify data
     * - Handle invalid input consistently (throw NotificationException with clear message)
     * - All senders accept and use subject where applicable
     * - All senders use body field without modification
     */
    public abstract void send(Notification n) throws NotificationException;
}
