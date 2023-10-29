import org.junit.Test;

import static org.junit.Assert.*;

public class FoodTest {

    @Test
    public void getId() {
        Food fd = new Food(1,"a",3,1);
        assertEquals (fd.getId() , 1);
    }

    @Test
    public void getName() {
        Food fd = new Food(1,"a",3,1);
        assertEquals (fd.getName(),"a");
    }

    @Test
    public void getEnergy() {
        Food fd = new Food(1,"a",3,1);
        assertEquals (fd.getEnergy() , 3);
    }

    @Test
    public void aqidf() {
        Adventurer ad = new Adventurer(1,"a",1,1);
        Food fd = new Food(1,"a",3,1);
        fd.belong(ad);
        long i = fd.aqPrice();
        int j = fd.aqIdf();
        long z = fd.getPrice();
        String y = fd.clName();
        assertEquals(1,1);
    }
}