import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    // ----- Constructor -----
    public Order() {
        name = "Guest";
        ArrayList<Item> items = new ArrayList<Item>();
    }

    public Order(String name) {
        this.name = name;
        ArrayList<Item> items = new ArrayList<Item>();
    }

    // ----- Methods -----
    public void addItem(Item item) {
        this.items.add(item); 
    }

    public void display() {
        System.out.println("Customer Name: " + this.name);
        for(Item item: this.items){
            System.out.println(item.getItemName() + " - $" + item.getItemPrice());
        }
        System.out.print("Total: $%.2f\n", getOrderTotal());
    }

    // ----- Getters -----
    public String getStatusMessage() {
        if (this.ready == true) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double orderTotal = 0;
        for(Item item: this.items) {
            orderTotal+=item.getItemPrice();
        }
        return orderTotal;
    }

    public String getOrderName() {
        return this.name;
    }

    public boolean isOrderReady() {
        return this.ready;
    } 

    // ----- Setters -----
    public void setOrderName(String name) {
        this.name = name;
    }

    public void setOrderReady(boolean ready) {
        this.ready = ready;
    }

    public void setOrderItems(ArrayList<Item> items) {
        this.items = items;
    }
}