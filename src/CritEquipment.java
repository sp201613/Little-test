public class CritEquipment extends Equipment {
    private int critical;

    public CritEquipment(int id, String name, int star, long price, String type, int critical) {
        super(id, name, star, price, type);
        this.critical = critical;
    }

    @Override
    public int hurt(int hitPoint, int level) {
        return super.getStar() * level + critical;
    }

    @Override
    public String clName() {
        return "CritEquipment";
    }
}
