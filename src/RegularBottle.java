public class RegularBottle extends Bottle {

    public RegularBottle(int id, String name,
                            int capacity, long price, String type) {
        super(id, name, capacity, price, type);
    }

    @Override
    public String clName() {
        return "RegularBottle";
    }
}
