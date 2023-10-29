import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void changeCapacity() {
        Bottle bt = new Bottle(1,"1",1,1,"a");
        bt.changeCapacity();
        assertEquals(bt.getCapacity() , 0);
    }

    @Test
    public void aqIdf() {
        Bottle bt = new Bottle(1,"1",1,1,"a");
        bt.getType();
        bt.getPrice();
        bt.clName();
        bt.aqIdf();
        assertEquals(1,1);
    }

}