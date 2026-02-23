public class StandardTaxPolicy implements TaxPolicy {
    @Override
    public double calculateTax(String customerType, double subtotal) {
        double taxPercent = getTaxPercent(customerType);
        return subtotal * (taxPercent / 100.0);
    }

    private double getTaxPercent(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            return 5.0;
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return 2.0;
        }
        return 8.0;
    }
}
