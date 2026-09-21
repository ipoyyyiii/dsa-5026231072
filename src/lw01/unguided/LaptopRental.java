public class LaptopRental extends Rental {
    public LaptopRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        return getUnits() * (getDays() * 40000 + 10000);
    }

    @Override
    public String label() {
        return "Laptop";
    }
}
