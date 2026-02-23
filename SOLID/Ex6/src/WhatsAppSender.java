public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) {
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

        // WhatsApp requires international format: +<country><number>
        if (!n.phone.startsWith("+")) {
            throw new NotificationException("phone must start with + and country code");
        }

        String body = n.body != null ? n.body : "";

        System.out.println("WA -> to=" + n.phone + " body=" + body);
        audit.add("wa sent");
    }
}
