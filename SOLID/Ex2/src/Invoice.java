import java.util.*;

public class Invoice {
    public final String invoiceId;
    public final List<InvoiceLine> lines;
    public final double subtotal;
    public final double tax;
    public final double discount;
    public final double total;

    public Invoice(String invoiceId, List<InvoiceLine> lines, double subtotal, 
                   double tax, double discount, double total) {
        this.invoiceId = invoiceId;
        this.lines = lines;
        this.subtotal = subtotal;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}

class InvoiceLine {
    public final String itemName;
    public final int qty;
    public final double price;
    public final double lineTotal;

    public InvoiceLine(String itemName, int qty, double price, double lineTotal) {
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
        this.lineTotal = lineTotal;
    }
}
