import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    // ----- Constructor ------
    public CoffeeKiosk() {
        // ArrayList<Item> menu = new ArrayList<Item>();
        // ArrayList<Order> orders = new ArrayList<Order>();
    }

    // ----- Methods ------
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
        newItem.setItemIndex(menu.size()-1);
    }

    public void displayMenu() {
        for (int i=0; i < menu.size(); i++) {
            System.out.printf("%d. %s -- $%.2f\n", menu.get(i).getItemIndex(), menu.get(i).getItemName(), menu.get(i).getItemPrice());
            //System.out.println(menu.get(i).getItemName());
        }
    }

    public void newOrder() {
    
    // Shows the user a message prompt and then sets their input to a variable, name
    System.out.println("Please enter customer name for new order:");
    String name = System.console().readLine();

    // Your code:
    // Create a new order with the given input string
    Order myOrder = new Order(name);
    // Show the user the menu, so they can choose items to add.
    displayMenu();
    
    // Prompts the user to enter an item number
    System.out.println("Please enter a menu item index or q to quit:");
    String itemNumber = System.console().readLine();
    
    // Write a while loop to collect all user's order items
    while(!itemNumber.equals("q")) {
        
        // Get the item object from the menu, and add the item to the order
        myOrder.addItem(menu.get(Integer.parseInt(itemNumber)));
        // Ask them to enter a new item index or q again, and take their input
        System.out.println("Please enter a menu item index or q to quit:");
        itemNumber = System.console().readLine();
    }
    // After you have collected their order, print the order details 
    // as the example below. You may use the order's display method.
    myOrder.display();
    }


}