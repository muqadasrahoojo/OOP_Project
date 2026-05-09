package users;
import orders.Order;

public class Customer extends User {

    public Customer(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void addOrder(Order order) {
    System.out.println("Order added successfully");
}

    @Override
    public void showMenu() {
        System.out.println("Customer Menu");
    }
}