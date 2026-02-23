import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
    }

    public void addToMenu(MenuItem item) {
        menu.put(item.id, item);
    }

    public Invoice createInvoice(String customerType, List<OrderLine> lines) {
        String invoiceId = "INV-" + (++invoiceSeq);

        List<InvoiceLine> invoiceLines = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine line : lines) {
            MenuItem item = menu.get(line.itemId);
            double lineTotal = item.price * line.qty;
            subtotal += lineTotal;
            invoiceLines.add(new InvoiceLine(item.name, line.qty, item.price, lineTotal));
        }

        double tax = taxPolicy.calculateTax(customerType, subtotal);
        double discount = discountPolicy.calculateDiscount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        return new Invoice(invoiceId, invoiceLines, subtotal, tax, discount, total);
    }
}
