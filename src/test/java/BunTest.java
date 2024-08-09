import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun = new Bun("white bun", 200);

    @Test
    public void bunReturnName() {
        assertEquals("white bun", bun.getName());
    }

    @Test
    public void priceReturnPrice() {
        assertEquals(200, bun.getPrice(), 10);
    }
}
