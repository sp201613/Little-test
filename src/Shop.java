import java.util.HashSet;

public class Shop {
    private static Shop shop = new Shop();
    private HashSet<Equipment> inep = new HashSet<>();
    private HashSet<Bottle> inbt = new HashSet<>();
    private HashSet<Food> infd = new HashSet<>();

    public static Shop getShop() { return shop; }

    public void adSellEp(Adventurer ad, Equipment x) {
        inep.add(x);
        ad.addmoney(x.getPrice());
        ad.getOwnCommodity().remove(x);
    }

    public void adSellBt(Adventurer ad, Bottle x) {
        inbt.add(x);
        ad.addmoney(x.getPrice());
        ad.getOwnCommodity().remove(x);
    }

    public void adSellFd(Adventurer ad, Food x) {
        infd.add(x);
        ad.addmoney(x.getPrice());
        ad.getOwnCommodity().remove(x);
    }

    public long adBuyRgep(Adventurer ad, int id, String name, String type) {
        long total = 0;
        int star = 0;
        for (Equipment i: inep) {
            total += i.getPrice();
            star += i.getStar();
        }
        long sellprice = 0;
        if (inep.size() != 0) {
            star /= inep.size();
            sellprice = total / inep.size();
        }
        if (ad.getMoney() < sellprice) { return sellprice; }
        Equipment ep = new RegularEquipment(id, name, star, sellprice, type);
        ad.addEquipment(ep);
        return sellprice;
    }

    public long adBuyCtep(Adventurer ad, int id, String name, String type, int critical) {
        long total = 0;
        int star = 0;
        for (Equipment i: inep) {
            total += i.getPrice();
            star += i.getStar();
        }
        long sellprice = 0;
        if (inep.size() != 0) {
            star /= inep.size();
            sellprice = total / inep.size();
        }
        if (ad.getMoney() < sellprice) { return sellprice; }
        Equipment ep = new CritEquipment(id, name, star, sellprice, type, critical);
        ad.addEquipment(ep);
        return sellprice;
    }

    public long adBuyEpep(Adventurer ad, int id, String name, String type, double ratio) {
        long total = 0;
        int star = 0;
        for (Equipment i: inep) {
            total += i.getPrice();
            star += i.getStar();
        }
        long sellprice = 0;
        if (inep.size() != 0) {
            star /= inep.size();
            sellprice = total / inep.size();
        }
        if (ad.getMoney() < sellprice) { return sellprice; }
        Equipment ep = new EpicEquipment(id, name, star, sellprice, type, ratio);
        ad.addEquipment(ep);
        return sellprice;
    }

    public long adBuyRgbt(Adventurer ad, int id, String name, String type) {
        long total = 0;
        int capacity = 0;
        for (Bottle i: inbt) {
            total += i.getPrice();
            capacity += i.getCapacity();
        }
        long sellprice = 0;
        if (inbt.size() != 0) {
            capacity /= inbt.size();
            sellprice = total / inbt.size();
        }
        if (ad.getMoney() < sellprice) { return sellprice; }
        Bottle bt = new RegularBottle(id, name, capacity, sellprice, type);
        ad.addBottle(bt);
        return sellprice;
    }

    public long adBuyRcbt(Adventurer ad, int id, String name, String type, double ratio) {
        long total = 0;
        int capacity = 0;
        for (Bottle i: inbt) {
            total += i.getPrice();
            capacity += i.getCapacity();
        }
        long sellprice = 0;
        if (inbt.size() != 0) {
            capacity /= inbt.size();
            sellprice = total / inbt.size();
        }
        if (ad.getMoney() < sellprice) { return sellprice; }
        Bottle bt = new RecoverBottle(id, name, capacity, sellprice, type, ratio);
        ad.addBottle(bt);
        return sellprice;
    }

    public long adBuyRfbt(Adventurer ad, int id, String name, String type, double ratio) {
        long total = 0;
        int capacity = 0;
        for (Bottle i: inbt) {
            total += i.getPrice();
            capacity += i.getCapacity();
        }
        long sellprice = 0;
        if (inbt.size() != 0) {
            capacity /= inbt.size();
            sellprice = total / inbt.size();
        }
        if (ad.getMoney() < sellprice) { return sellprice; }
        Bottle bt = new ReinforcedBottle(id, name, capacity, sellprice, type, ratio);
        ad.addBottle(bt);
        return sellprice;
    }

    public long adBuyFd(Adventurer ad, int id, String name) {
        long total = 0;
        int energy = 0;
        for (Food i: infd) {
            total += i.getPrice();
            energy += i.getEnergy();
        }
        long sellprice = 0;
        if (infd.size() != 0) {
            energy /= infd.size();
            sellprice = total / infd.size();
        }
        if (ad.getMoney() < sellprice) { return sellprice; }
        Food fd = new Food(id, name, energy, sellprice);
        ad.addFood(fd);
        return sellprice;
    }
}
