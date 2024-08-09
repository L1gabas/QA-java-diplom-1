import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bunBlue;

    @Mock
    private Ingredient thousandIslandsSauce, fireAssSauce, fillingTomato, fillingSalad;

    @Before
    public void setUp() {
        burger = new Burger();
        bunBlue = new Bun("Blue bun", 250);
        thousandIslandsSauce = new Ingredient(IngredientType.SAUCE, "ThousandIslands", 120);
        fireAssSauce = new Ingredient(IngredientType.SAUCE, "FireAss", 500);
        fillingTomato = new Ingredient(IngredientType.FILLING, "Tomato", 70);
    }

    @Test
    public void burgerReturnBurgerType() {
        burger.setBuns(bunBlue);
        assertEquals(bunBlue, burger.bun);
    }
    @Test
    public void addIngredientTOBurger() {
        burger.addIngredient(thousandIslandsSauce);
        assertEquals(true, burger.ingredients.contains(thousandIslandsSauce));
    }
    @Test
    public void removeIngredientFromBurger() {
        burger.addIngredient(thousandIslandsSauce);
        burger.addIngredient(fireAssSauce);
        burger.addIngredient(fillingTomato);

        burger.removeIngredient(0);

        assertEquals(false, burger.ingredients.contains(thousandIslandsSauce));
    }

    @Test
    public void moveIngredientBurger() {
        burger.addIngredient(thousandIslandsSauce);
        burger.addIngredient(fillingTomato);

        burger.moveIngredient(0, 1);

        assertEquals(thousandIslandsSauce, burger.ingredients.get(1));
    }

    @Test
    public void burgerPrice() {
        burger.setBuns(bunBlue);
        burger.addIngredient(thousandIslandsSauce);
        burger.addIngredient(fireAssSauce);
        burger.addIngredient(fillingTomato);

        assertEquals(1190, burger.getPrice(), 200);
    }

    @Test
    public void burgerRecipe(){
        burger.setBuns(bunBlue);
        burger.addIngredient(fireAssSauce);
        burger.addIngredient(fillingTomato);
        String expected =
                "(==== Blue bun ====)\r\n" +
                "= FireAss =\r\n" +
                "= Tomato =\r\n" +
                "(==== Blue bun ====)\r\n" +
                "\r\n" +
                "Price: 1070";
        String burgerRecipe = burger.getReceipt();
        assertEquals(burgerRecipe.trim(),burger.getReceipt().trim());

    }
}
