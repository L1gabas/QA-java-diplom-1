import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest {
    private String name;
    private float price;
    public BunParamTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun {index} -> Name: {0}, Price: {1}")
            public static Object[][] dataForTest() {
        return new Object[][]{
                {"null", 100},
                {"Black322", 300},
                {"White bun", 200},
                {"GreyWolf", 200},
        };
    }

    Bun bun = new Bun("white bun", 200);

    @Test
    public void bunReturnName() {
        assertEquals("white bun", bun.getName());
    }

    @Test
    public void priceReturnPrice() {
        assertEquals(200, bun.getPrice(), 0);
    }
}
