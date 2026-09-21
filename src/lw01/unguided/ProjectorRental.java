public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        int perUnit = Math.min(getDays(), 3) * 60000 + Math.max(0, getDays() - 3) * 45000 + 20000;
        return getUnits() * perUnit;
    }

    @Override
    public String label() {
        return "Projector";
    }
}
