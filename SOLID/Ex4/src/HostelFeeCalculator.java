import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final RoomTypeFactory roomFactory;
    private final AddOnPricingStrategy addOnPricing;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
        this.roomFactory = new RoomTypeFactory();
        this.addOnPricing = new StandardAddOnPricing();
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthlyFee(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthlyFee(BookingRequest req) {
        RoomPricingStrategy roomStrategy = roomFactory.createStrategy(req.roomType);
        double baseMonthly = roomStrategy.getMonthlyFee();

        double addOnTotal = 0.0;
        for (AddOn addOn : req.addOns) {
            addOnTotal += addOnPricing.getFee(addOn);
        }

        return new Money(baseMonthly + addOnTotal);
    }
}
