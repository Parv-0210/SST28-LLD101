public class InvoicePrinter {
    public void print(Invoice invoice) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(invoice.invoiceId).append("\n");

        for (InvoiceLine line : invoice.lines) {
            sb.append(String.format("- %s x%d = %.2f\n", line.itemName, line.qty, line.lineTotal));
        }

        sb.append(String.format("Subtotal: %.2f\n", invoice.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", getTaxPercent(invoice), invoice.tax));
        sb.append(String.format("Discount: -%.2f\n", invoice.discount));
        sb.append(String.format("TOTAL: %.2f\n", invoice.total));

        System.out.print(sb.toString());
    }

    private double getTaxPercent(Invoice invoice) {
        if (invoice.subtotal == 0) {
            return 0;
        }
        return (invoice.tax / invoice.subtotal) * 100.0;
    }
}
