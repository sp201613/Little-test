public class Equipment implements Commodity {
    private int id;
    private String name;
    private int star;
    private long price;
    private String type;

    public Equipment(int id, String name, int star, long price, String type) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.price = price;
        this.type = type;
    }

    public void levelup() {
        star++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() { return price; }

    public String getType() { return type; }

    public int getStar() {
        return star;
    }

    public int hurt(int hitPoint, int  level) {
        return star * level;
    }

    @Override
    public void belong(Adventurer ad) {
        ad.getOwnCommodity().add(this);
    }

    @Override
    public long aqPrice() {
        return price;
    }

    @Override
    public String clName() {
        return "Equipment";
    }

    @Override
    public int aqIdf() {
        return id;
    }
}
