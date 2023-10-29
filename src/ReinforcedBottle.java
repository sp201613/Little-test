public class ReinforcedBottle extends Bottle {
    private double ratio;

    public ReinforcedBottle(int id, String name,
                            int capacity, long price, String type, double ratio) {
        super(id, name, capacity, price, type);
        this.ratio = ratio;
    }

    @Override
    public int useBottle(int h) {
        int x = super.getCapacity();
        double y = (1.0 + ratio) * x;
        super.changeCapacity();
        return (int)y;
    }

    @Override
    public String clName() {
        return "ReinforcedBottle";
    }
}
