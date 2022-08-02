public class Item {
    private String name;
    private double price;
    private int index;

    // ----- Constructor -----
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // ----- Methods -----
    public void displayItem() {
        System.out.println("Item Name: " + this.name);
        System.out.println("Item Price: " + this.price);
        System.out.println("\n");
    }

    // ----- Getters -----
    public String getItemName() {
        return name;
    }

    public double getItemPrice() {
        return price;
    }

    public int getItemIndex() {
        return index;
    }

    // ----- Setters -----
    public void setItemName(String name) {
        this.name = name;
    }

    public void setItemPrice(double price) {
        this.price = price;
    }

    public void setItemIndex(int index) {
        this.index = index;
    }
}