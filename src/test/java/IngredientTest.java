import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient bbq = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    @Test
    public void sauceReturnSauceType() {
        assertEquals(IngredientType.SAUCE, bbq.getType());
    }
    @Test
    public void nameReturnSauceName() {
        assertEquals("hot sauce", bbq.getName());
    }
    @Test
    public void sauceReturnSaucePrice() {
        assertEquals(100, bbq.getPrice(), 0);
    }
}