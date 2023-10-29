import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class FightModTest {

    @Test
    public void getMes() {
    }

    @Test
    public void addAdventurer() {
        FightMod x = new FightMod();
        Adventurer ad = new Adventurer(1,"1",1,1);
        x.addAdventurer(ad);
        assertEquals(x.getAds().size(),1);
    }

    @Test
    public void addMessage() {
        FightMod x = new FightMod();
        x.addMessage("1");
        assertEquals(x.getMes().size(),1);
    }

    @Test
    public void adClear() {
        FightMod x = new FightMod();
        Adventurer ad = new Adventurer(1,"1",1,1);
        x.getAds().add(ad);
        x.adClear();
        assertEquals(x.getAds().size(), 0);
    }

    @Test
    public void adQuery() {
        FightMod x = new FightMod();
        Adventurer ad = new Adventurer(1,"1",1,1);
        x.getAds().add(ad);
        assertEquals(x.adQuery("1"),ad);
        assertEquals(x.adQuery("0"),null);
    }

    @Test
    public void checkMessage() {
        FightMod x = new FightMod();
        x.getMes().add("2022/09-advName1-botName");
        x.getMes().add("2022/09-advName2@#-equName");
        x.getMes().add("2022/09-advName2@advName1-equName");
        x.checkMessage(0);
        assertEquals(1,1);
    }

    @Test
    public void match1Solve() {
        FightMod x = new FightMod();
        Adventurer ad = new Adventurer(1,"advName1",1,1);
        x.getAds().add(ad);
        Bottle bt = new RegularBottle(2,"botName",3,1,"RegularBottle");
        ad.addBottle(bt);
        ad.takeBottle(2);
        x.getMes().add("2022/09-advName1-botName");
        String s1 = "(\\d{1,4})/((1[0-2])|(0?[1-9]))-([^@#-]*)-([^@#-]*)";
        Pattern pattern1 = Pattern.compile(s1);
        Matcher matcher = pattern1.matcher("2022/09-advName1-botName");
        Matcher matcher1 = pattern1.matcher("2022/09-advname2-botName");
        if(matcher.find()) assertEquals(x.match1Solve(matcher),true);
        if(matcher1.find()) assertEquals(x.match1Solve(matcher1),false);
    }

    @Test
    public void match2Solve() {
        FightMod x = new FightMod();
        Adventurer ad1 = new Adventurer(1,"advName1",1,100);
        Adventurer ad2 = new Adventurer(2,"advName2",1,100);
        x.getAds().add(ad1);
        x.getAds().add(ad2);
        Equipment ep = new RegularEquipment(3,"equName",1,1,"RegularEquipment");
        ad1.addEquipment(ep);
        ad1.takeEquipent(3);
        x.getMes().add("2022/09-advName1@advName2-equName");
        String s1 = "(\\d{1,4})/((1[0-2])|(0?[1-9]))-([^@#-]*)@([^@#-]*)-([^@#-]*)";
        Pattern pattern1 = Pattern.compile(s1);
        Matcher matcher = pattern1.matcher("2022/09-advName1@advName2-equName");
        Matcher matcher1 = pattern1.matcher("2022/09-advName2@advName1-equName");
        Matcher matcher2 = pattern1.matcher("2022/09-advName1@advName2-equ");
        if(matcher.find()) assertEquals(x.match2Solve(matcher),true);
        x.getMes().clear();
        x.getMes().add("2022/09-advName2@advName1-equName");
        if(matcher1.find()) assertEquals(x.match2Solve(matcher1),false);
        x.getMes().clear();
        x.getMes().add("2022/09-advName1@advName2-equ");
        if(matcher2.find()) assertEquals(x.match2Solve(matcher2),false);
    }

    @Test
    public void match3Solve() {
        FightMod x = new FightMod();
        Adventurer ad1 = new Adventurer(1,"advName1",1,100);
        Adventurer ad2 = new Adventurer(2,"advName2",1,100);
        x.getAds().add(ad1);
        x.getAds().add(ad2);
        Equipment ep = new RegularEquipment(3,"equName",1,1,"a");
        ad1.addEquipment(ep);
        ad1.takeEquipent(3);
        x.getMes().add("2022/09-advName1@#-equName");
        String s1 = "(\\d{1,4})/((1[0-2])|(0?[1-9]))-([^@#-]*)@#-([^@#-]*)";
        Pattern pattern1 = Pattern.compile(s1);
        Matcher matcher = pattern1.matcher("2022/09-advName1@#-equName");
        Matcher matcher1 = pattern1.matcher("2022/09-advName2@#-equName");
        Matcher matcher2 = pattern1.matcher("2022/09-advName1@#-equ");
        if(matcher.find()) assertEquals(x.match3Solve(matcher),true);
        x.getMes().clear();
        x.getMes().add("2022/09-advName2@#-equName");
        if(matcher1.find()) assertEquals(x.match3Solve(matcher1),false);
        x.getMes().clear();
        x.getMes().add("2022/09-advName1@#-equ");
        if(matcher2.find()) assertEquals(x.match3Solve(matcher2),false);
    }

    @Test
    public void mesdateQuery() {
        FightMod x = new FightMod();
        Adventurer ad1 = new Adventurer(1,"advName1",1,100);
        Adventurer ad2 = new Adventurer(2,"advName2",1,100);
        Bottle bt = new Bottle(2,"botName",3,1,"a");
        Equipment ep = new Equipment(3,"equName",1,1,"a");
        FightLog ff1 = new FightLog(0,0,"2023/10",ad1,"botName",ep);
        FightLog ff2 = new FightLog(1,0,"2023/10",ad1,null,ep);
        FightLog ff3 = new FightLog(1,1,"2023/10",ad1,null,ep);
        ff2.getBtr().add(ad2);
        ff3.getBtr().add(ad2);
        x.getFl().add(ff1);
        x.getFl().add(ff2);
        x.getFl().add(ff3);
        x.mesdateQuery("2023/10");
        assertEquals(1,1);
        x.mesdateQuery("2023/11");
        assertEquals(1,1);
    }

    @Test
    public void mesatQuery() {
        FightMod x = new FightMod();
        Adventurer ad1 = new Adventurer(1,"advName1",1,100);
        Adventurer ad2 = new Adventurer(2,"advName2",1,100);
        Bottle bt = new Bottle(2,"botName",3,1,"a");
        Equipment ep = new Equipment(3,"equName",1,1,"a");
        FightLog ff1 = new FightLog(0,0,"2023/10",ad1,"botName",ep);
        FightLog ff2 = new FightLog(1,0,"2023/10",ad1,null,ep);
        FightLog ff3 = new FightLog(1,1,"2023/10",ad1,null,ep);
        ff2.getBtr().add(ad2);
        ff3.getBtr().add(ad2);
        x.getFl().add(ff1);
        x.getFl().add(ff2);
        x.getFl().add(ff3);
        x.mesatQuery("advName1");
        assertEquals(1,1);
        x.mesatQuery("advName2");
        assertEquals(1,1);
    }

    @Test
    public void mesbatQuery() {
        FightMod x = new FightMod();
        Adventurer ad1 = new Adventurer(1,"advName1",1,100);
        Adventurer ad2 = new Adventurer(2,"advName2",1,100);
        Equipment ep = new Equipment(3,"equName",1,1,"a");
        FightLog ff1 = new FightLog(0,0,"2023/10",ad1,"botName",ep);
        FightLog ff2 = new FightLog(1,0,"2023/10",ad1,null,ep);
        FightLog ff3 = new FightLog(1,1,"2023/10",ad1,null,ep);
        ff2.getBtr().add(ad2);
        ff3.getBtr().add(ad2);
        x.getFl().add(ff1);
        x.getFl().add(ff2);
        x.getFl().add(ff3);
        x.mesbatQuery("advName2");
        assertEquals(1,1);
        x.mesbatQuery("advName1");
        assertEquals(1,1);
    }
}