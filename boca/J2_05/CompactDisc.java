public class CompactDisc extends Item {
    private int tracks;

    public CompactDisc(int barcode, String name, double price, int tracks) {
        super(barcode, name, price);
        this.tracks = tracks;
    }

    public int getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return super.getName() + " (R$" + super.getPriceString() + ") - " + this.tracks + " faixas";
    }
    
}