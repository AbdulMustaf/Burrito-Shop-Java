import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BurritoShopTest {

    private BurritoShop shop;

    @BeforeEach
    public void setUp() {
        shop = new BurritoShop();
    }

    @Test
    public void testTakeOrder() {
        BurritoLab4 order = new BurritoLab4("large", "chicken", "white", "black", "lettuce, salsa", true);
        shop.takeOrder(order);
        assertTrue(shop.hasOrders(), "Order should be added to the queue.");
    }

    @Test
    public void testMakeOrder() {
        BurritoLab4 order = new BurritoLab4("small", "steak", "brown", "pinto", "cheese, guacamole", false);
        shop.takeOrder(order);
        BurritoLab4 madeOrder = shop.makeOrder();
        assertNotNull(madeOrder, "Order should be made from the queue.");
        assertEquals(order, madeOrder, "Made order should match the taken order.");
    }

    @Test
    public void testRingOutOrder() {
        BurritoLab4 order = new BurritoLab4("large", "carnitas", "white", "none", "sour cream", true);
        shop.takeOrder(order);
        BurritoLab4 ringOutOrder = shop.ringOutOrder();
        assertNotNull(ringOutOrder, "Order should be rung out.");
        assertEquals(order, ringOutOrder, "Rung out order should match the made order.");
    }

    @Test
    public void testWashNextDish() {
        BurritoLab4 order = new BurritoLab4("small", "none", "none", "none", "none", false);
        shop.takeOrder(order);
        shop.makeOrder();
        shop.washNextDish();
        assertFalse(shop.hasDirtyDishes(), "Dish should be washed.");
    }

    @Test
    public void testWashAllDishes() {
        BurritoLab4 order1 = new BurritoLab4("large", "chicken", "white", "black", "lettuce", true);
        BurritoLab4 order2 = new BurritoLab4("small", "steak", "brown", "pinto", "cheese", false);
        shop.takeOrder(order1);
        shop.takeOrder(order2);
        shop.makeOrder();
        shop.makeOrder();
        shop.washAllDishes();
        assertFalse(shop.hasDirtyDishes(), "All dishes should be washed.");
    }

    @Test
    public void testCannotCloseWithPendingWork() {
        BurritoLab4 order = new BurritoLab4("large", "sofritas", "brown", "none", "lettuce, salsa", true);
        shop.takeOrder(order);
        assertTrue(shop.hasOrders(), "Shop should not close with pending orders.");
    }

    @Test
    public void testCloseForTheDay() {
        assertFalse(shop.hasOrders(), "No orders should be pending.");
        assertFalse(shop.hasTransactions(), "No transactions should be pending.");
        assertFalse(shop.hasDirtyDishes(), "No dirty dishes should be left.");
    }

    @Test
    public void testTotalSales() {
        BurritoLab4 order1 = new BurritoLab4("large", "chicken", "white", "black", "lettuce", true);
        BurritoLab4 order2 = new BurritoLab4("small", "steak", "brown", "pinto", "cheese", false);
        shop.takeOrder(order1);
        shop.takeOrder(order2);
        shop.ringOutOrder();
        shop.ringOutOrder();
        assertEquals(order1.calculatePrice() + order2.calculatePrice(), shop.getTotalSales(), 0.01, "Total sales should match the sum of prices.");
    }
}
