import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {

    Item mocha = new Item("mocha", 3.49);
    Item latte = new Item("latte", 4.99);
    Item dripCoffee = new Item("drop coffee", 1.99);
    Item capuccino = new Item("capuccino", 5.99);

    // mocha.displayItem();

    // Order myOrder = new Order("Brian");
    // myOrder.addItem(mocha);
    // myOrder.addItem(latte);
    // myOrder.display();
    // System.out.println(myOrder.getStatusMessage());

    Order guest1 = new Order();
    Order guest2 = new Order();
    Order guest3 = new Order("Frank");
    Order guest4 = new Order("Judy");
    Order guest5 = new Order("Matt");

    guest1.addItem(latte);
    guest1.addItem(capuccino);
    guest1.setOrderReady(true);


    guest2.addItem(dripCoffee);
    guest2.addItem(latte);
    guest2.addItem(capuccino);
    guest2.setOrderReady(false);

    guest3.addItem(mocha);
    guest3.addItem(capuccino);
    guest3.setOrderReady(false);

    guest4.addItem(latte);
    guest4.addItem(capuccino);
    guest4.addItem(mocha);
    guest4.addItem(dripCoffee);
    guest4.setOrderReady(true);

    guest5.addItem(latte);
    guest5.addItem(dripCoffee);
    guest5.setOrderReady(true);

    guest1.display();
    System.out.println(guest1.getStatusMessage());
    System.out.println();

    guest2.display();
    System.out.println(guest2.getStatusMessage());
    System.out.println();

    guest3.display();
    System.out.println(guest3.getStatusMessage());
    System.out.println();

    guest4.display();
    System.out.println(guest4.getStatusMessage());
    System.out.println();

    guest5.display();
    System.out.println(guest5.getStatusMessage());
    System.out.println();
    

    //     // Menu items
    //     Item item1 = new Item();
    //     item1.name = "mocha";
    //     item1.price = 3.49;

    //     Item item2 = new Item();
    //     item2.name = "latte";
    //     item2.price = 4.99;

    //     Item item3 = new Item();
    //     item3.name = "drip coffee";
    //     item3.price = 1.99;

    //     Item item4 = new Item();
    //     item4.name = "capuccino";
    //     item4.price = 5.99;
    
    //     // Order variables -- order1, order2 etc.
    //     Order order1 = new Order();
    //     order1.name = "Cindhuri";
    //     order1.ready = true;

    //     Order order2 = new Order();
    //     order2.name = "Jimmy";
    //     order2.items.add(item1);
    //     order2.total += item1.price;
    //     order2.ready = true;

    //     Order order3 = new Order();
    //     order3.name = "Noah";
    //     order3.items.add(item4);
    //     order3.total += item4.price;

    //     Order order4 = new Order();
    //     order4.name = "Sam";
    //     order4.items.add(item2);
    //     order4.total += item2.price;
    //     order4.items.add(item2);
    //     order4.total += item2.price;
    //     order4.items.add(item2);
    //     order4.total += item2.price;


    //     System.out.printf("Name: %s\n", order1.name);
    //     System.out.printf("Total: %s\n", order1.total);
    //     System.out.printf("Ready: %s\n\n", order1.ready);

    //     System.out.printf("Name: %s\n", order2.name);
    //     System.out.printf("Total: %s\n", order2.total);
    //     System.out.printf("Ready: %s\n\n", order2.ready);

    //     System.out.printf("Name: %s\n", order3.name);
    //     System.out.printf("Total: %s\n", order3.total);
    //     System.out.printf("Ready: %s\n\n", order3.ready);

    //     System.out.printf("Name: %s\n", order4.name);
    //     System.out.printf("Total: %s\n", order4.total);
    //     System.out.printf("Ready: %s\n\n", order4.ready);

    
    //     // Application Simulations
    //     // Use this example code to test various orders' updates
    //     // System.out.printf("Name: %s\n", order1.name);
    //     // System.out.printf("Total: %s\n", order1.total);
    //     // System.out.printf("Ready: %s\n", order1.ready);
    }

    
}
