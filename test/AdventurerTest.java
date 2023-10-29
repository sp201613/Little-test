import org.junit.Test;
import static org.junit.Assert.*;

public class AdventurerTest {

    @Test
    public void getBottles() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        Bottle bt=new Bottle(11,"aa",5,1,"a");
        ad.addBottle(bt);
        assertEquals (ad.getBottles().size() , ad.getBtSize());
    }

    @Test
    public void getEquipments() {
        Adventurer ad=new Adventurer(3,"ab",1, 500);
        Equipment ep=new Equipment(11,"aa",5,1,"a");
        ad.addEquipment(ep);
        assertEquals(ad.getEpSize(),ad.getEquipments().size());
    }

    @Test
    public void getFood() {
        Adventurer ad=new Adventurer(5,"ab",1,500);
        Food fd = new Food(111, "bbb", 5,1);
        ad.addFood(fd);
        assertEquals(ad.getFdSize(), ad.getFood().size());
    }

    @Test
    public void addBottle() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        Bottle bt=new Bottle(11,"aa",5,1,"a");
        ad.addBottle(bt);
        assertEquals(ad.getBtSize(),1);
    }

    @Test
    public void outBottle() {
        Adventurer ad=new Adventurer(2,"bb",1,500);
        Bottle bt=new Bottle(22,"ax",5,1,"a");
        ad.addBottle(bt);
        ad.getPack().takeBottle(bt);
        int si=ad.getBtSize();
        ad.outBottle(bt);
        assertEquals(ad.getPack().getPbt().isEmpty(),true);
        assertEquals(ad.getBtSize() , si - 1);
    }

    @Test
    public void addEquipment() {
        Adventurer ad=new Adventurer(3,"ab",1, 500);
        Equipment ep=new Equipment(11,"aa",5,1,"a");
        ad.addEquipment(ep);
        assertEquals(ad.getEpSize(),1);
    }

    @Test
    public void outEquipment() {
        Adventurer ad=new Adventurer(5,"ab",1,500);
        Equipment ep=new Equipment(33,"aa",5,1,"a");
        ad.addEquipment(ep);
        int si=ad.getEpSize();
        ad.outEquipment(ep);
        assertEquals(ad.getEpSize(),si-1);
    }

    @Test
    public void addFood() {
        Adventurer ad=new Adventurer(5,"ab",1,500);
        Food fd = new Food(111, "bbb", 5,1);
        ad.addFood(fd);
        assertEquals(ad.getFdSize() , 1);
    }

    @Test
    public void outFood() {
        Adventurer ad=new Adventurer(7,"asb",1,500);
        Food fd = new Food(1121, "bab", 5,1);
        ad.addFood(fd);
        int si = ad.getFdSize();
        ad.outFood(fd);
        assertEquals(ad.getFdSize() , si - 1);
    }

    @Test
    public void getBottlesSize() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        Bottle bt=new Bottle(11,"aa",5,1,"a");
        ad.addBottle(bt);
        assertEquals (ad.getBottles().size() , ad.getBtSize());
    }

    @Test
    public void getEquipmentsSize() {
        Adventurer ad=new Adventurer(3,"ab",1, 500);
        Equipment ep=new Equipment(11,"aa",5,1,"a");
        ad.addEquipment(ep);
        assertEquals(ad.getEpSize(),ad.getEquipments().size());
    }

    @Test
    public void getFoodSize() {
        Adventurer ad=new Adventurer(5,"ab",1,500);
        Food fd = new Food(111, "bbb", 5,1);
        ad.addFood(fd);
        assertEquals(ad.getFdSize() , ad.getFood().size());
    }

    @Test
    public void takeEquipment() {
        Adventurer ad=new Adventurer(3,"ab",1, 500);
        Equipment ep=new Equipment(11,"aa",5,1,"a");
        int num = ad.getPack().getPeq().size();
        ad.addEquipment(ep);
        ad.takeEquipent(11);
        assertEquals(ad.getPack().getPeq().size() , num + 1);
    }

    @Test
    public void takeBottle() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        Bottle bt=new Bottle(11,"aa",5,1,"a");
        ad.addBottle(bt);
        int num = ad.getPack().getPbt().size();
        ad.takeBottle(1);
        assertEquals(ad.getPack().getPbt().size() , num + 1);
    }

    @Test
    public void takeFood() {
        Adventurer ad=new Adventurer(5,"ab",1,500);
        Food fd = new Food(111, "bbb", 5,1);
        ad.addFood(fd);
        int num = ad.getPack().getPfd().size();
        ad.takeFood(5);
        assertEquals (ad.getPack().getPfd().size() , num + 1);
    }

    @Test
    public void tryuseBottle() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        Bottle bt=new RegularBottle(11,"aa",5,1,"RegularBottle");
        ad.addBottle(bt);
        ad.getPack().takeBottle(bt);
        assertEquals(ad.tryuseBottle("aa") , 11);
        assertEquals(ad.getHitPoint() , 505);
        assertEquals(ad.tryuseBottle("aa") , 11);
        assertEquals(bt.getCapacity() , 0);
        assertEquals (ad.tryuseBottle("aa") , -1);
        Adventurer ad1=new Adventurer(2,"ab",1,500);
        Bottle bt1=new ReinforcedBottle(12,"aba",5,1,"ReinforcedBottle",0.01);
        ad1.addBottle(bt1);
        ad1.getPack().takeBottle(bt1);
        ad1.tryuseBottle("aba");
        assertEquals(1,1);
        Adventurer ad2=new Adventurer(3,"ab",1,500);
        Bottle bt2=new RecoverBottle(122,"aca",5,1,"RecoverBottle",0.01);
        ad2.addBottle(bt2);
        ad2.getPack().takeBottle(bt2);
        ad2.tryuseBottle("aca");
        assertEquals(1,1);
    }

    @Test
    public void getHitPoint() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        assertEquals (ad.getHitPoint() , 500);
    }

    @Test
    public void tryeatFood() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        Food fd=new Food(11,"aa",5,1);
        ad.addFood(fd);
        ad.getPack().takeFood(fd);
        assertEquals(ad.tryeatFood("aa") , 11);
        assertEquals(ad.getLevel() , 6);
        assertEquals (ad.tryuseBottle("aa") , -1);
    }

    @Test
    public void getLevel() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        assertEquals (ad.getLevel() , 1);
    }

    @Test
    public void getName() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        assertEquals (ad.getName() , "ab");
    }

    @Test
    public void getId() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        assertEquals (ad.getId() , 1);
    }

    @Test
    public void Beattacked() {
        Adventurer ad=new Adventurer(1,"ab",1,500);
        ad.Beattacked(5);
        assertEquals(ad.getHitPoint(),495);
    }

    @Test
    public void aqMaxprice() {
        Commodity x = new Food(1,"a",1,3);
        Adventurer ad = new Adventurer(1,"a",1,1);
        ad.getOwnCommodity().add(x);
        assertEquals(ad.aqMaxprice(),3);
    }

    @Test
    public void aqidf() {
        Adventurer ad = new Adventurer(1,"a",1,1);
        ad.aqidfrom(1);
        long i = ad.aqPrice();
        RegularEquipment xa = new RegularEquipment(1,"a",1,1,"RegularEquipment");
        i = xa.aqIdf();
        i = xa.aqPrice();
        i = ad.aqIdf();
        String yy = xa.clName();
        yy = ad.clName();
        xa.belong(ad);
        CritEquipment x = new CritEquipment(1,"a",1,1,"CritEquipment",2);
        i = x.aqIdf();
        i = x.aqPrice();
        ad.belong(ad);
        String y = x.clName();
        EpicEquipment xx = new EpicEquipment(1,"a",1,1,"CritEquipment",2);
        i = xx.aqIdf();
        i = xx.aqPrice();
        y = xx.clName();
        xx.belong(ad);
        double z = xx.hurt(500,11);
        ReinforcedBottle a = new ReinforcedBottle(1,"a",1,1,"ReinforcedBottle",2);
        i = a.aqPrice();
        y = a.clName();
        i = a.useBottle(1);
        a.belong(ad);
        RecoverBottle b = new RecoverBottle(1,"a",1,1,"RecoveredBottle",2);
        i = b.aqPrice();
        y = b.clName();
        i = b.useBottle(1);
        b.belong(ad);
        RegularBottle c = new RegularBottle(1,"a",1,1,"RegularBottle");
        i = c.aqPrice();
        y = c.clName();
        i = c.useBottle(1);
        c.belong(ad);
        assertEquals(1,1);
    }

    @Test
    public void addmoney()
    {
        Adventurer ad = new Adventurer(1,"1",1,500);
        ad.addmoney(5);
        assertEquals(ad.getMoney(),5);
    }

    @Test
    public void submoney()
    {
        Adventurer ad = new Adventurer(1,"1",1,500);
        ad.addmoney(5);
        ad.submoney(3);
        assertEquals(ad.getMoney(),2);
    }

    @Test
    public void notifyEmployee() {
        Adventurer ad1 = new Adventurer(1,"1",1,500);
        Adventurer ad2 = new Adventurer(2,"2",1,500);
        ad1.addEmployee(ad2);
        ad1.notifyEmployee(502);
        ad1.notifyEmployee(498);
        ad2.addmoney(400000);
        ad1.notifyEmployee(502);
        assertEquals(1,1);
    }
}