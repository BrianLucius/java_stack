public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayItem() {
        System.out.println("Item Name: " + this.name);
        System.out.println("Item Price: " + this.price);
        System.out.println("\n");
    }

    public String getItemName() {
        return name;
    }

    public double getItemPrice() {
        return price;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public void setItemPrice(double price) {
        this.price = price;
    }
}