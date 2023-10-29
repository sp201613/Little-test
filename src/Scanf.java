import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Scanf {
    private HashMap<Integer, Adventurer> adventurers;
    private FightMod logg;

    public Scanf(HashMap<Integer, Adventurer> adventurers, FightMod logg) {
        this.adventurers = adventurers;
        this.logg = logg;
    }

    public Adventurer queryAd(String name) {
        for (Adventurer value : adventurers.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            int type = scanner.nextInt();
            int advId = 0;
            if (type < 7) {
                advId = scanner.nextInt();
                type6(type,scanner,advId);
            } else if (type < 14) {
                advId = scanner.nextInt();
                type13(type,scanner,advId);
            } else if (type == 14) {
                int m = scanner.nextInt();
                int k = scanner.nextInt();
                ArrayList<Integer> hits = new ArrayList<>();
                ArrayList<Adventurer> employers = new ArrayList<>();
                for (int j = 1;j <= m;++j) {
                    Adventurer ad = queryAd(scanner.next());
                    logg.addAdventurer(ad);
                    employers.add(ad);
                    hits.add(ad.getHitPoint());
                }
                int numMes = logg.getMes().size();
                for (int j = 1;j <= k;++j) {
                    logg.addMessage(scanner.next());
                }
                System.out.println("Enter Fight Mode");
                logg.checkMessage(numMes);
                logg.adClear();
                for (int j = 1;j <= m;++j) {
                    Adventurer ad = employers.get(j);
                    int preHit = hits.get(j);
                    ad.notifyEmployee(preHit);
                }
            } else if (type == 15) {
                logg.mesdateQuery(scanner.next());
            } else if (type == 16) {
                logg.mesatQuery(adventurers.get(scanner.nextInt()).getName());
            } else if (type == 17) {
                logg.mesbatQuery(adventurers.get(scanner.nextInt()).getName());
            } else if (type == 18) {
                int advId1 = scanner.nextInt();
                int advId2 = scanner.nextInt();
                adventurers.get(advId2).belong(adventurers.get(advId1));
            } else if (type == 19) {
                Adventurer ad = adventurers.get(scanner.nextInt());
                System.out.println(ad.getOwnCommodity().size() + " " + ad.aqPrice());
            } else if (type == 20) {
                Adventurer ad = adventurers.get(scanner.nextInt());
                System.out.println(ad.aqMaxprice());
            } else if (type == 21) {
                Adventurer ad = adventurers.get(scanner.nextInt());
                int comId = scanner.nextInt();
                ad.aqidfrom(comId);
            } else { type22(type, scanner); }
        }
        scanner.close();
    }

    public void type6(int type,Scanner scanner,int advId) {
        if (type == 1) {
            Adventurer ad = new Adventurer(advId, scanner.next(),1, 500);
            adventurers.put(advId, ad);
        } else if (type == 2) {
            int bid = scanner.nextInt();
            String name = scanner.next();
            int capacity = scanner.nextInt();
            long price = scanner.nextLong();
            String tp = scanner.next();
            if (tp.equals("RegularBottle")) {
                Bottle bt = new RegularBottle(bid, name, capacity, price, tp);
                adventurers.get(advId).addBottle(bt);
                bt.belong(adventurers.get(advId));
            } else if (tp.equals("ReinforcedBottle")) {
                double ratio = scanner.nextDouble();
                Bottle bt = new ReinforcedBottle(bid, name, capacity, price, tp, ratio);
                adventurers.get(advId).addBottle(bt);
                bt.belong(adventurers.get(advId));
            } else {
                double ratio = scanner.nextDouble();
                Bottle bt = new RecoverBottle(bid, name, capacity, price, tp, ratio);
                adventurers.get(advId).addBottle(bt);
                bt.belong(adventurers.get(advId));
            }
        } else if (type == 3) {
            Bottle bt = adventurers.get(advId).getBottles().get(scanner.nextInt());
            System.out.println(adventurers.get(advId).getBtSize() - 1 + " " + bt.getName());
            Shop.getShop().adSellBt(adventurers.get(advId), bt);
        } else if (type == 4) {
            int equId = scanner.nextInt();
            String name = scanner.next();
            int star = scanner.nextInt();
            long price = scanner.nextLong();
            String tp = scanner.next();;
            if (tp.equals("RegularEquipment")) {
                Equipment ep = new RegularEquipment(equId, name, star, price, tp);
                adventurers.get(advId).addEquipment(ep);
                ep.belong(adventurers.get(advId));
            } else if (tp.equals("CritEquipment")) {
                Equipment ep = new CritEquipment(equId, name, star, price, tp, scanner.nextInt());
                adventurers.get(advId).addEquipment(ep);
                ep.belong(adventurers.get(advId));
            } else {
                double ratio = scanner.nextDouble();
                Equipment ep = new EpicEquipment(equId, name, star, price, tp, ratio);
                adventurers.get(advId).addEquipment(ep);
                ep.belong(adventurers.get(advId));
            }
        } else if (type == 5) {
            Equipment ep = adventurers.get(advId).getEquipments().get(scanner.nextInt());
            System.out.println(adventurers.get(advId).getEpSize() - 1 + " " + ep.getName());
            Shop.getShop().adSellEp(adventurers.get(advId), ep);
        } else if (type == 6) {
            Equipment ep = adventurers.get(advId).getEquipments().get(scanner.nextInt());
            ep.levelup();
            System.out.format("%s %d\n", ep.getName(), ep.getStar());
        }
    }

    public void type13(int type,Scanner scanner,int advId) {
        if (type == 7) {
            Food fd = new Food(scanner.nextInt(), scanner.next(),
                    scanner.nextInt(), scanner.nextLong());
            adventurers.get(advId).addFood(fd);
            fd.belong(adventurers.get(advId));
        } else if (type == 8) {
            Food fd = adventurers.get(advId).getFood().get(scanner.nextInt());
            System.out.format("%d %s\n",adventurers.get(advId).getFdSize() - 1,fd.getName());
            adventurers.get(advId).outFood(fd);
        } else if (type == 9) {
            adventurers.get(advId).takeEquipent(scanner.nextInt());
        } else if (type == 10) {
            adventurers.get(advId).takeBottle(scanner.nextInt());
        } else if (type == 11) {
            adventurers.get(advId).takeFood(scanner.nextInt());
        } else if (type == 12) {
            String bottleName = scanner.next();
            int bid = adventurers.get(advId).tryuseBottle(bottleName);
            if (bid == -1) {
                System.out.println("fail to use " + bottleName);
            } else {
                System.out.println(bid + " " + adventurers.get(advId).getHitPoint());
            }
        } else if (type == 13) {
            String foodName = scanner.next();
            int fid = adventurers.get(advId).tryeatFood(foodName);
            if (fid == -1) {
                System.out.println("fail to eat " + foodName);
            } else {
                System.out.println(fid + " " + adventurers.get(advId).getLevel());
            }
        }
    }

    public void type22(int type,Scanner scanner) {
        if (type == 22) {
            int advId = scanner.nextInt();
            Adventurer ad = adventurers.get(advId);
            System.out.println(ad.getName() + " emptied the backpack " + ad.getPack().sellall(ad));
        } else {
            int advId = scanner.nextInt();
            int id = scanner.nextInt();
            String name = scanner.next();
            String tt = scanner.next();
            Adventurer ad = adventurers.get(advId);
            long price = 0;
            if (tt.equals("Food")) {
                price = Shop.getShop().adBuyFd(ad, id, name);
            } else if (tt.equals("RegularEquipment")) {
                price = Shop.getShop().adBuyRgep(ad, id, name, tt);
            } else if (tt.equals("CritEquipment")) {
                int critical = scanner.nextInt();
                price = Shop.getShop().adBuyCtep(ad, id, name, tt, critical);
            } else if (tt.equals("EpicEquipment")) {
                double ratio = scanner.nextDouble();
                price = Shop.getShop().adBuyEpep(ad, id, name, tt, ratio);
            } else if (tt.equals("RegularBottle")) {
                price = Shop.getShop().adBuyRgbt(ad, id, name, tt);
            } else if (tt.equals("RecoverBottle")) {
                double ratio = scanner.nextDouble();
                price = Shop.getShop().adBuyRcbt(ad, id, name, tt, ratio);
            } else {
                double ratio = scanner.nextDouble();
                price = Shop.getShop().adBuyRfbt(ad, id, name, tt, ratio);
            }
            if (ad.getMoney() < price) {
                System.out.println("failed to buy " + name + " for " + price);
            } else {
                System.out.println("successfully buy " + name + " for " + price);
                ad.submoney(price);
            }
        }
    }
}
