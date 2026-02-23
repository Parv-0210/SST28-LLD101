public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public void send(Notification n) throws NotificationException {
        if (n == null) {
            throw new NotificationException("notification cannot be null");
        }

        if (n.email == null || n.email.isBlank()) {
            throw new NotificationException("email address is required");
        }

        if (!n.email.contains("@")) {
            throw new NotificationException("invalid email address");
        }

        // Use both subject and body - not truncation
        String subject = n.subject != null ? n.subject : "";
        String body = n.body != null ? n.body : "";

        System.out.println("EMAIL -> to=" + n.email + " subject=" + subject + " body=" + body);
        audit.add("email sent");
    }
}
