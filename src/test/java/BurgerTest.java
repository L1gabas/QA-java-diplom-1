import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bunBlue;

    @Mock
    private Ingredient thousandIslandsSauce;

    @Mock
    private Ingredient fireAssSauce;

    @Mock
    private Ingredient fillingTomato;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void burgerReturnBurgerType() {
        burger.setBuns(bunBlue);
        assertEquals(bunBlue, burger.bun);
    }
    @Test
    public void addIngredientTOBurger() {
        burger.addIngredient(thousandIslandsSauce);
        assertTrue(burger.ingredients.contains(thousandIslandsSauce));
    }
    @Test
    public void removeIngredientFromBurger() {
        burger.addIngredient(thousandIslandsSauce);
        burger.addIngredient(fireAssSauce);
        burger.addIngredient(fillingTomato);

        burger.removeIngredient(0);

        assertFalse(burger.ingredients.contains(thousandIslandsSauce));
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
        when(bunBlue.getPrice()).thenReturn(250f);
        when(thousandIslandsSauce.getPrice()).thenReturn(120f);
        when(fireAssSauce.getPrice()).thenReturn(500f);
        when(fillingTomato.getPrice()).thenReturn(70f);

        burger.setBuns(bunBlue);
        burger.addIngredient(thousandIslandsSauce);
        burger.addIngredient(fireAssSauce);
        burger.addIngredient(fillingTomato);

        assertEquals(1190, burger.getPrice(), 0);
    }

    @Test
    public void burgerRecipe(){
        when(bunBlue.getName()).thenReturn("Blue bun");
        when(bunBlue.getPrice()).thenReturn(250f);

        when(fireAssSauce.getName()).thenReturn("FireAss");
        when(fireAssSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(fireAssSauce.getPrice()).thenReturn(500f);

        when(fillingTomato.getName()).thenReturn("Tomato");
        when(fillingTomato.getType()).thenReturn(IngredientType.FILLING);
        when(fillingTomato.getPrice()).thenReturn(70f);

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
