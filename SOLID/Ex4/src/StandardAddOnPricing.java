public class StandardAddOnPricing implements AddOnPricingStrategy {
    @Override
    public double getFee(AddOn addOn) {
        return switch (addOn) {
            case MESS -> 1000.0;
            case LAUNDRY -> 500.0;
            case GYM -> 300.0;
        };
    }
}
