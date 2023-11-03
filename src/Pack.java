import java.util.HashSet;

public class Pack {
    private HashSet<Equipment> peq = new HashSet<>();//背包里携带的武器
    private HashSet<Bottle> pbt = new HashSet<>();//背包里携带的药水瓶
    private HashSet<Food> pfd = new HashSet<>();//背包里携带的食物
    private int maxBottles;

    public HashSet<Equipment> getPeq() { return peq; }

    public HashSet<Bottle> getPbt() { return pbt; }

    public HashSet<Food> getPfd() { return pfd; }

    public Pack(int maxBottles) {
        this.maxBottles = maxBottles;
    }

    public void takeEquipment(Equipment x) {
        int flag = 0;
        for (Equipment item : peq) {
            if (x.getName().equals(item.getName())) {
                flag = 1;
                peq.remove(item);
                break;
            }
        }
        peq.add(x);
    }

    public void takeBottle(Bottle x) {
        int number = 0;
        for (Bottle item : pbt) {
            if (x.getName().equals(item.getName())) { ++number; }
        }
        if (number < maxBottles) { pbt.add(x); }
    }

    public void takeFood(Food x) {
        if (!pfd.contains(x)) {
            pfd.add(x);
            //System.out.println("ok " + x.getName());
        }
    }

    public void outBottle(Bottle x) { pbt.remove(x); }

    public void outEquipment(Equipment x) { peq.remove(x); }

    public void outFood(Food x) { pfd.remove(x); }

    public int tryuseBottle(String x) {
        int minn = 2147483647;
        int flag = 0;
        for (Bottle item : pbt) {
            if (x.equals(item.getName())) {
                minn = minn > item.getId() ? item.getId() : minn;
                flag = 1;
            }
        }
        return flag == 1 ? minn : -1;
    }

    public int tryeatFood(String x) {
        int minn = 2147483647;
        int flag = 0;
        Food fd = new Food(1,"1",1,1);
        for (Food item : pfd) {
            if (x.equals(item.getName())) {
                minn = minn > item.getId() ? item.getId() : minn;
                fd = item;
                flag = 1;
            }
        }
        if (flag == 1) { pfd.remove(fd); }
        return flag == 1 ? minn : -1;
    }

    public void submaxBottles(int x) {
        maxBottles = x / 5 + 1;
    }

    public int getMaxBottles() { return maxBottles; }

    public long sellall(Adventurer ad) {
        Shop shop = Shop.getShop();
        final long prem = ad.getMoney();
        HashSet<Equipment> ppeq = new HashSet<>();
        HashSet<Bottle> ppbt = new HashSet<>();
        HashSet<Food> ppfd = new HashSet<>();
        for (Equipment i : peq) {
            shop.adSellEp(ad, i);
            ppeq.add(i);
        }
        for (Equipment i : ppeq) {
            ad.outEquipment(i);
        }
        for (Bottle i : pbt) {
            shop.adSellBt(ad, i);
            ppbt.add(i);
        }
        for (Bottle i : ppbt) {
            ad.outBottle(i);
        }
        for (Food i : pfd) {
            shop.adSellFd(ad, i);
            ppfd.add(i);
        }
        for (Food i : ppfd) {
            ad.outFood(i);
        }
        ppeq.clear();
        ppbt.clear();
        ppfd.clear();
        return ad.getMoney() - prem;
    }
}