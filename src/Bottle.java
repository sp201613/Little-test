public class Bottle implements Commodity {
    private int id;
    private String name;
    private int capacity;
    private long price;
    private String type;

    public Bottle(int id, String name, int capacity,
                  long price, String type) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public int getCapacity() { return capacity; }

    public long getPrice() { return price; }

    public String getType() { return type; }

    public int useBottle(int h) {
        int x = capacity;
        capacity = 0;
        return x;
    }

    public void changeCapacity() { capacity = 0; }

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
        return  "Bottle";
    }

    @Override
    public int aqIdf() {
        return id;
    }
}

