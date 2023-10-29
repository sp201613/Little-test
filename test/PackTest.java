import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class PackTest {

    @Test
    public void getPeq() {
        Pack x = new Pack(1);
        Equipment ep = new Equipment(1,"a",1,1,"a");
        x.getPeq().add(ep);
        assertEquals (x.getPeq().size() , 1);
    }

    @Test
    public void getPbt() {
        Pack x = new Pack(1);
        Bottle bt = new Bottle(1,"a",3,1,"a");
        x.getPbt().add(bt);
        assertEquals (x.getPbt().size() , 1);
    }

    @Test
    public void getPfd() {
        Pack x = new Pack(1);
        Food fd = new Food(1,"a",3,1);
        x.getPfd().add(fd);
        assertEquals (x.getPfd().size() , 1);
    }

    @Test
    public void takeEquipment() {
        Pack x = new Pack(1);
        Equipment ep = new Equipment(1,"a",3,1,"a");
        x.getPeq().add(ep);
        Equipment ep1 = new Equipment(2,"a",3,1,"a");
        x.takeEquipment(ep1);
        assertEquals (x.getPeq().contains(ep) , false);
        assertEquals (x.getPeq().contains(ep1) , true);
    }

    @Test
    public void takeBottle() {
        Pack x = new Pack(1);
        Bottle bt = new Bottle(1,"a",3,1,"a");
        x.getPbt().add(bt);
        Bottle bt1 = new Bottle(2,"a",3,1,"a");
        x.takeBottle(bt1);
        assertEquals (x.getPbt().contains(bt) , true);
        assertEquals (x.getPbt().contains(bt1) , false);
    }

    @Test
    public void takeFood() {
        Pack x = new Pack(1);
        Food fd =new Food(1,"a",3,1);
        x.getPfd().add(fd);
        assertEquals (x.getPfd().contains(fd) , true);
    }

    @Test
    public void outBottle() {
        Pack x = new Pack(1);
        Bottle bt = new Bottle(1,"a",3,1,"a");
        x.getPbt().add(bt);
        int si = x.getPbt().size();
        x.outBottle(bt);
        assertEquals (x.getPbt().size() , si - 1);
    }

    @Test
    public void outEquipment() {
        Pack x = new Pack(1);
        Equipment ep = new Equipment(1,"a",3,1,"RegularEquipment");
        x.getPeq().add(ep);
        int si = x.getPeq().size();
        x.outEquipment(ep);
        assertEquals (x.getPeq().size() , si - 1);
    }

    @Test
    public void outFood() {
        Pack x = new Pack(1);
        Food fd =new Food(1,"a",3,1);
        x.getPfd().add(fd);
        int si = x.getPfd().size();
        x.outFood(fd);
        assertEquals (x.getPfd().size() , si - 1);
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
    public void submaxBottles() {
        Pack x = new Pack(1);
        x.submaxBottles(19);
        assertEquals (x.getMaxBottles() , 4);
    }

    @Test
    public void getMaxBottles() {
        Pack x = new Pack(1);
        assertEquals (x.getMaxBottles() , 1);
    }

    @Test
    public void sellall() {
        Adventurer ad = new Adventurer(1,"1",5,500);
        Equipment ep = new RegularEquipment(1,"2",3,5,"RegularEquipment");
        Bottle bt = new RegularBottle(1,"3",4,55,"RegularBottle");
        Food fd = new Food(1,"33",55,100);
        ad.addEquipment(ep);
        ad.addBottle(bt);
        ad.addFood(fd);
        ad.getPack().takeEquipment(ep);
        ad.getPack().takeFood(fd);
        ad.getPack().takeBottle(bt);
        ad.getPack().sellall(ad);
        assertEquals(1,1);
    }
}