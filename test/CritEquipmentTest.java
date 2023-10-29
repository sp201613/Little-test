import org.junit.Test;

import static org.junit.Assert.*;

public class CritEquipmentTest {
    @Test
    public void hurt() {
        CritEquipment x = new CritEquipment(1,"a",1,1,"CritEquipment",2);
        assertEquals(x.hurt(100,1),3);
    }
}