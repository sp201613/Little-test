import org.junit.Test;
import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void levelup() {
        Equipment ep=new Equipment(1,"aa",3,1,"a");
        ep.levelup();
        assertEquals(ep.getStar() , 4);
    }

    @Test
    public void getId() {
        Equipment ep=new Equipment(1,"aa",3,1,"a");
        assertEquals (ep.getId() , 1);
    }

    @Test
    public void getName() {
        Equipment ep=new Equipment(1,"aa",3,1,"a");
        assertEquals (ep.getName().equals("aa") , true);
    }

    @Test
    public void getStar() {
        Equipment ep=new Equipment(1,"aa",3,1,"a");
        assertEquals (ep.getStar() , 3);
        ep.aqIdf();
        ep.clName();
        ep.aqPrice();
        ep.hurt(1,1);
    }

    @Test
    public void get() {
        Equipment ep=new Equipment(1,"aa",3,1,"a");
        ep.getType();
        ep.getPrice();
        assertEquals(1,1);
    }
}