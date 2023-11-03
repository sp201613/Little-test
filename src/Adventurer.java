import java.util.HashMap;
import java.util.HashSet;

public class Adventurer implements Commodity, Employer, Employee {
    private int id;
    private String name;
    private int level;
    private int hitPoint;
    private HashMap<Integer, Bottle> bottles = new HashMap<>();
    private HashMap<Integer, Equipment> equipments = new HashMap<>();
    private HashMap<Integer, Food> foods = new HashMap<>();
    private Pack pack = new Pack(1);
    private HashSet<Commodity> ownCommodity = new HashSet<>();
    private HashSet<Employee> employees = new HashSet<>();
    private long money;

    public HashSet<Employee> getEmployees() { return employees; }

    public HashMap<Integer, Bottle> getBottles() { return bottles; }

    public HashMap<Integer, Equipment> getEquipments() { return equipments; }

    public HashMap<Integer, Food> getFood() { return foods; }

    public HashSet<Commodity> getOwnCommodity() { return ownCommodity; }

    public Pack getPack() { return pack; }

    public Adventurer(int id, String name, int level, int hitpoint) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.hitPoint = hitpoint;
        this.money = 0;
    }

    public void addBottle(Bottle x) {
        bottles.put(x.getId(), x);
    }

    public void outBottle(Bottle x) {
        if (pack.getPbt().contains(x)) { pack.outBottle(x); }
        bottles.remove(x.getId());
        ownCommodity.remove(x);
    }

    public void addEquipment(Equipment x) { equipments.put(x.getId(), x); }

    public void outEquipment(Equipment x) {
        if (pack.getPeq().contains(x)) { pack.outEquipment(x); }
        equipments.remove(x.getId());
        ownCommodity.remove(x);
    }

    public void addFood(Food x) { foods.put(x.getId(),x); }

    public void outFood(Food x) {
        if (pack.getPfd().contains(x)) { pack.outFood(x); }
        foods.remove(x.getId());
        ownCommodity.remove(x);
    }

    public int getBtSize() {
        return bottles.size();
    }

    public int getEpSize() {
        return equipments.size();
    }

    public int getFdSize() { return foods.size(); }

    public void takeEquipent(Integer x) { pack.takeEquipment(equipments.get(x)); }

    public void takeBottle(Integer x) { pack.takeBottle(bottles.get(x)); }

    public void takeFood(Integer x) { pack.takeFood(foods.get(x)); }

    public int tryuseBottle(String x) {
        int pid = pack.tryuseBottle(x);
        if (pid == -1) { return -1; }
        else {
            Bottle bt = bottles.get(pid);
            if (bt.getIsEmpty() != 0) {
                if (bt instanceof RegularBottle) {
                    hitPoint += bt.useBottle(hitPoint);
                } else if (bt instanceof ReinforcedBottle) {
                    ReinforcedBottle rfbt = (ReinforcedBottle) bt;
                    hitPoint += rfbt.useBottle(hitPoint);
                } else {
                    RecoverBottle rcbt = (RecoverBottle) bt;
                    hitPoint += rcbt.useBottle(hitPoint);
                }
            } else {
                outBottle(bottles.get(pid));
            }
            return pid;
        }
    }

    public int getHitPoint() { return hitPoint; }

    public int tryeatFood(String x) {
        int pid = pack.tryeatFood(x);
        if (pid == -1) { return -1; }
        else {
            level += foods.get(pid).getEnergy();
            pack.submaxBottles(level);
            outFood(foods.get(pid));
            return pid;
        }
    }

    public int getLevel() { return level; }

    public String getName() { return name; }

    public int getId() { return id; }

    public void Beattacked(int x) { hitPoint -= x; }

    @Override
    public void belong(Adventurer ad) {
        ad.getEmployees().add(this);
        ad.getOwnCommodity().add(this);
    }

    @Override
    public long aqPrice() {
        long x = 0;
        for (Commodity i: ownCommodity) {
            x += i.aqPrice();
        }
        x += money;
        return x;
    }

    @Override
    public String clName() {
        return "Adventurer";
    }

    @Override
    public int aqIdf() {
        return id;
    }

    public long aqMaxprice() {
        long x = 0;
        for (Commodity i: ownCommodity) {
            long y = i.aqPrice();
            x = x < y ? y : x;
        }
        return x;
    }

    public void aqidfrom(int comId) {
        for (Commodity i: ownCommodity) {
            if (i.aqIdf() == comId) {
                System.out.println("Commodity whose id is " + comId + " belongs to " + i.clName());
            }
        }
    }

    public long getMoney() { return money; }

    public void addmoney(long x) {
        money += x;
    }

    public void submoney(long x) {
        money -= x;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void notifyEmployee(int x) {
        int less = x - hitPoint;
        if (less <= 0 || hitPoint  > x / 2) {
            return;
        }
        for (Employee i : employees) {
            money += i.help(less);
        }
    }

    @Override
    public long help(int x) {
        long need = (long)x * 10000;
        if (money < need) {
            long nd = money;
            money = 0;
            return nd;
        } else {
            money -= need;
            return need;
        }
    }
}
