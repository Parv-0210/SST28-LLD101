public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public void send(Notification n) throws NotificationException {
        if (n == null) {
            throw new NotificationException("notification cannot be null");
        }

        if (n.phone == null || n.phone.isBlank()) {
            throw new NotificationException("phone number is required");
        }

        if (!n.phone.chars().allMatch(Character::isDigit)) {
            throw new NotificationException("phone number must contain only digits");
        }

        // SMS uses phone and body; subject is not applicable to SMS
        String body = n.body != null ? n.body : "";

        System.out.println("SMS -> to=" + n.phone + " body=" + body);
        audit.add("sms sent");
    }
}
