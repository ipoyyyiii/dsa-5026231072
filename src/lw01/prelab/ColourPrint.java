public class ColourPrint extends PrintJob {
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int base = Math.min(getPages(), 10) * 1500 + Math.max(0, getPages() - 10) * 1000;
        return base + 2000;
    }

    @Override
    public String label() {
        return "Colour";
    }
}
