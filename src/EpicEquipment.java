public class EpicEquipment extends Equipment {
    private double ratio;

    public EpicEquipment(int id, String name, int star, long price, String type, double ratio) {
        super(id, name, star, price, type);
        this.ratio = ratio;
    }

    @Override
    public int hurt(int hitPoint, int level) {
        int x = (int)((double)hitPoint * ratio);
        return  x;
    }

    @Override
    public String clName() {
        return "EpicEquipment";
    }
}
