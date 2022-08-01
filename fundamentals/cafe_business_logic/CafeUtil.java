import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int numDrinks = 0;

        for (int i = 0; i <= numWeeks; i++) {
            numDrinks+=i;
        }
        return numDrinks;
    }

    public double getOrderTotal(double[] prices) {
        double totalPrice = 0.0;

        for (double price : prices) {
            totalPrice = totalPrice + price;
        }
        return totalPrice;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i=0; i < menuItems.size(); i++) {
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();

        System.out.printf("Hello, %s!\n", userName);
        System.out.printf("There are %s people in front of you\n", customers.size());
        customers.add(userName); 
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);

        for (int i = 1; i <= maxQuantity; i++) {
            System.out.printf("%s - %.2f\n", i, price * i); //regular pricing
        }
    }

        public void printPriceChart(String product, double price, double discount, int maxQuantity) {
        System.out.println(product);

        for (int i = 1; i <= maxQuantity; i++) {
            System.out.printf("%s - %.2f\n", i, (price * i) - ((i-1)*discount));
        }
    }
}