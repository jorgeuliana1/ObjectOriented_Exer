public class CompactDisc extends Item {
    private int tracks;

    public CompactDisc(String name, double price, int tracks) {
        super(name, price);
        this.tracks = tracks;
    }

    public int getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return this.name + " (R$"this.price + ") - " + this.tracks + " faixas";
    }
    
}