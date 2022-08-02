import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {

    CoffeeKiosk kiosk = new CoffeeKiosk();

    kiosk.addMenuItem("mocha", 3.49);
    kiosk.addMenuItem("latte", 4.99);
    kiosk.addMenuItem("drip Coffee", 1.99);
    kiosk.addMenuItem("capuccino", 5.99);

    // kiosk.displayMenu();

    kiosk.newOrder();
    

    // Item mocha = new Item("mocha", 3.49);
    // Item latte = new Item("latte", 4.99);
    // Item dripCoffee = new Item("drop coffee", 1.99);
    // Item capuccino = new Item("capuccino", 5.99);

    
    }

    
}
