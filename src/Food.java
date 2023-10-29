public class Food implements Commodity {
    private int id;
    private String name;
    private int energy;
    private long price;

    public Food(int id, String name, int energy, long price) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.price = price;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getEnergy() { return energy; }

    public long getPrice() { return price; }

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
        return "Food";
    }

    @Override
    public int aqIdf() {
        return id;
    }
}
