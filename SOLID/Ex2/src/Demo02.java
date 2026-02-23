import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        TaxPolicy taxPolicy = new StandardTaxPolicy();
        DiscountPolicy discountPolicy = new StandardDiscountPolicy();
        CafeteriaSystem sys = new CafeteriaSystem(taxPolicy, discountPolicy);

        sys.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        sys.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        sys.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        Invoice invoice = sys.createInvoice("student", order);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);

        FileStore store = new FileStore();
        InvoiceRepository repository = new InvoiceRepository(store);
        
        StringBuilder invoiceContent = new StringBuilder();
        invoiceContent.append("Invoice# ").append(invoice.invoiceId).append("\n");
        for (InvoiceLine line : invoice.lines) {
            invoiceContent.append(String.format("- %s x%d = %.2f\n", line.itemName, line.qty, line.lineTotal));
        }
        invoiceContent.append(String.format("Subtotal: %.2f\n", invoice.subtotal));
        invoiceContent.append(String.format("Tax(%.0f%%): %.2f\n", getTaxPercent(invoice), invoice.tax));
        invoiceContent.append(String.format("Discount: -%.2f\n", invoice.discount));
        invoiceContent.append(String.format("TOTAL: %.2f\n", invoice.total));

        repository.save(invoice.invoiceId, invoiceContent.toString());
        System.out.println("Saved invoice: " + invoice.invoiceId + " (lines=" + repository.getLineCount(invoice.invoiceId) + ")");
    }

    private static double getTaxPercent(Invoice invoice) {
        if (invoice.subtotal == 0) {
            return 0;
        }
        return (invoice.tax / invoice.subtotal) * 100.0;
    }
}
