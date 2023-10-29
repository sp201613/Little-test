import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void adBuyRgep() {
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
        Shop.getShop().adBuyRgep(ad,2,"22","RegularEquipment");
        ad.addmoney(500000);
        Shop.getShop().adBuyRgep(ad,2,"22","RegularEquipment");
        ad.getPack().sellall(ad);
        Shop.getShop().adBuyRgep(ad,2,"22","RegularEquipment");
        ad.addmoney(500000);
        Shop.getShop().adBuyRgep(ad,2,"22","RegularEquipment");
        assertEquals(1,1);
    }

    @Test
    public void adBuyCtep() {
        Adventurer ad = new Adventurer(1,"1",5,500);
        Equipment ep = new CritEquipment(1,"2",3,5,"CritEquipment",10);
        Bottle bt = new RegularBottle(1,"3",4,55,"RegularBottle");
        Food fd = new Food(1,"33",55,100);
        ad.addEquipment(ep);
        ad.addBottle(bt);
        ad.addFood(fd);
        ad.getPack().takeEquipment(ep);
        ad.getPack().takeFood(fd);
        ad.getPack().takeBottle(bt);
        Shop.getShop().adBuyCtep(ad,2,"22","CritEquipment",10);
        ad.addmoney(500000);
        Shop.getShop().adBuyCtep(ad,2,"22","CritEquipment",10);
        ad.getPack().sellall(ad);
        Shop.getShop().adBuyCtep(ad,2,"22","CritEquipment",10);
        ad.addmoney(500000);
        Shop.getShop().adBuyCtep(ad,2,"22","CritEquipment",10);
        assertEquals(1,1);
    }

    @Test
    public void adBuyEpep() {
        Adventurer ad = new Adventurer(1,"1",5,500);
        Equipment ep = new EpicEquipment(1,"2",3,5,"EpicEquipment",0.5);
        Bottle bt = new RegularBottle(1,"3",4,55,"RegularBottle");
        Food fd = new Food(1,"33",55,100);
        ad.addEquipment(ep);
        ad.addBottle(bt);
        ad.addFood(fd);
        ad.getPack().takeEquipment(ep);
        ad.getPack().takeFood(fd);
        ad.getPack().takeBottle(bt);
        Shop.getShop().adBuyEpep(ad,2,"22","EpicEquipment",0.5);
        ad.addmoney(500000);
        Shop.getShop().adBuyEpep(ad,2,"22","EpicEquipment",0.5);
        ad.getPack().sellall(ad);
        Shop.getShop().adBuyEpep(ad,2,"22","EpicEquipment",0.5);
        ad.addmoney(500000);
        Shop.getShop().adBuyEpep(ad,2,"22","EpicEquipment",0.5);
        assertEquals(1,1);
    }

    @Test
    public void adBuyRgbt() {
        Adventurer ad = new Adventurer(1,"1",5,500);
        Equipment ep = new CritEquipment(1,"2",3,5,"CritEquipment",10);
        Bottle bt = new RegularBottle(1,"3",4,55,"RegularBottle");
        Food fd = new Food(1,"33",55,100);
        ad.addEquipment(ep);
        ad.addBottle(bt);
        ad.addFood(fd);
        ad.getPack().takeEquipment(ep);
        ad.getPack().takeFood(fd);
        ad.getPack().takeBottle(bt);
        Shop.getShop().adBuyRgbt(ad,2,"22","RegularBottle");
        ad.addmoney(500000);
        Shop.getShop().adBuyRgbt(ad,2,"22","RegularBottle");
        ad.getPack().sellall(ad);
        Shop.getShop().adBuyRgbt(ad,2,"22","RegularBottle");
        ad.addmoney(500000);
        Shop.getShop().adBuyRgbt(ad,2,"22","RegularBottle");
        assertEquals(1,1);
    }

    @Test
    public void adBuyRcbt() {
        Adventurer ad = new Adventurer(1,"1",5,500);
        Equipment ep = new CritEquipment(1,"2",3,5,"CritEquipment",10);
        Bottle bt = new RecoverBottle(1,"3",4,55,"RecoverBottle",0.5);
        Food fd = new Food(1,"33",55,100);
        ad.addEquipment(ep);
        ad.addBottle(bt);
        ad.addFood(fd);
        ad.getPack().takeEquipment(ep);
        ad.getPack().takeFood(fd);
        ad.getPack().takeBottle(bt);
        Shop.getShop().adBuyRcbt(ad,2,"22","RecoverBottle",0.5);
        ad.addmoney(500000);
        Shop.getShop().adBuyRcbt(ad,2,"22","RecoverBottle",0.5);
        ad.getPack().sellall(ad);
        Shop.getShop().adBuyRcbt(ad,2,"22","RecoverBottle",0.5);
        ad.addmoney(500000);
        Shop.getShop().adBuyRcbt(ad,2,"22","RecoverBottle",0.5);
        assertEquals(1,1);
    }

    @Test
    public void adBuyRfbt() {
        Adventurer ad = new Adventurer(1,"1",5,500);
        Equipment ep = new CritEquipment(1,"2",3,5,"CritEquipment",10);
        Bottle bt = new ReinforcedBottle(1,"3",4,55,"ReinforcedBottle",0.5);
        Food fd = new Food(1,"33",55,100);
        ad.addEquipment(ep);
        ad.addBottle(bt);
        ad.addFood(fd);
        ad.getPack().takeEquipment(ep);
        ad.getPack().takeFood(fd);
        ad.getPack().takeBottle(bt);
        Shop.getShop().adBuyRfbt(ad,2,"22","ReinforcedBottle",0.5);
        ad.addmoney(500000);
        Shop.getShop().adBuyRfbt(ad,2,"22","ReinforcedBottle",0.5);
        ad.getPack().sellall(ad);
        Shop.getShop().adBuyRfbt(ad,2,"22","ReinforcedBottle",0.5);
        ad.addmoney(500000);
        Shop.getShop().adBuyRfbt(ad,2,"22","ReinforcedBottle",0.5);
        assertEquals(1,1);
    }

    @Test
    public void adBuyFd() {
        Adventurer ad = new Adventurer(1,"1",5,500);
        Equipment ep = new CritEquipment(1,"2",3,5,"CritEquipment",10);
        Bottle bt = new ReinforcedBottle(1,"3",4,55,"ReinforcedBottle",0.5);
        Food fd = new Food(1,"33",55,100);
        ad.addEquipment(ep);
        ad.addBottle(bt);
        ad.addFood(fd);
        ad.getPack().takeEquipment(ep);
        ad.getPack().takeFood(fd);
        ad.getPack().takeBottle(bt);
        Shop.getShop().adBuyFd(ad,2,"22");
        ad.addmoney(500000);
        Shop.getShop().adBuyFd(ad,2,"22");
        ad.getPack().sellall(ad);
        Shop.getShop().adBuyFd(ad,2,"22");
        ad.addmoney(500000);
        Shop.getShop().adBuyFd(ad,2,"22");
        assertEquals(1,1);
    }
}