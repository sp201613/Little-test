public class RecoverBottle extends Bottle {
    private double ratio;

    public RecoverBottle(int id, String name,
                            int capacity, long price, String type, double ratio) {
        super(id, name, capacity, price, type);
        this.ratio = ratio;
    }

    @Override
    public int useBottle(int h) {
        double x = ratio * h;
        super.changeCapacity();
        return (int)x;
    }

    @Override
    public String clName() {
        return "RecoverBottle";
    }
}
