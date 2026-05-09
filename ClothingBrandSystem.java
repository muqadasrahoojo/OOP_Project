import users.*;
import products.*;
import inventory.*;
import orders.*;
import payments.*;
import reports.*;

import java.util.Scanner;


class InvalidLoginException extends Exception {
    public InvalidLoginException(String msg) {
        super(msg);
    }
}

class ClothingBrandSystem {

    static Scanner sc = new Scanner(System.in);

    static Admin admin =
            new Admin("U001", "Sara", "sara@mail.com", "admin");

    static Manager manager =
            new Manager("U002", "Ali", "ali@mail.com", "mgr");

    static Customer customer =
            new Customer("U003", "Hamza", "hamza@mail.com", "cust");

    static Inventory inventory = new Inventory();

    static Order[] allOrders = new Order[20];
    static int orderCount = 0;

    public static void main(String[] args) {

        loadProducts();

        while (true) {

            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1. Admin");
            System.out.println("2. Manager");
            System.out.println("3. Customer");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1)
                adminMenu();

            else if (choice == 2)
                managerMenu();

            else if (choice == 3)
                customerMenu();

            else
                break;
        }
    }


    static void adminMenu() {

        try {

            System.out.print("Password: ");

            if (!sc.nextLine().equals(admin.getPassword())) {
                throw new InvalidLoginException("Wrong admin password!");
            }

            admin.login();

            System.out.println("Welcome Admin");

            inventory.showAllProducts();

            admin.logout();

        } catch (InvalidLoginException e) {

            System.out.println(e.getMessage());
        }
    }

    // ================= MANAGER =================
    static void managerMenu() {

        try {

            System.out.print("Password: ");

            if (!sc.nextLine().equals(manager.getPassword())) {
                throw new InvalidLoginException("Wrong manager password!");
            }

            manager.login();

            System.out.println("1. View Stock");

            inventory.showAllProducts();

            manager.logout();

        } catch (InvalidLoginException e) {

            System.out.println(e.getMessage());
        }
    }

    
    static void customerMenu() {

        try {

            System.out.print("Password: ");

            if (!sc.nextLine().equals(customer.getPassword())) {
                throw new InvalidLoginException("Wrong customer password!");
            }

            customer.login();

            System.out.println("Placing simple demo order...");

            Product p = inventory.getProductById("P001");

            if (p != null) {

                Order order = new Order(customer, "2026-05-08");

                try {

                    p.reduceStock(1);

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

                OrderItem item = new OrderItem(p, 1);

                order.addItem(item);

                order.calculateTotal();

                customer.addOrder(order);

                allOrders[orderCount++] = order;

                Payment pay =
                        new CashPayment(
                                "PAY1",
                                order.calculateTotal(),
                                "2026-05-08"
                        );

                try {

                    pay.processPayment();

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

                pay.displayReceipt();

                order.updateStatus("Confirmed");

                order.displayOrder();
            }

            customer.logout();

        } catch (InvalidLoginException e) {

            System.out.println(e.getMessage());
        }
    }

    static void loadProducts() {

        inventory.addProduct(
                new Shirt("P001", "White Shirt", 1200, 10, "Cotton"));

        inventory.addProduct(
                new Hoodie("P002", "Black Hoodie", 2500, 5, "Oversized"));

        inventory.addProduct(
                new Trouser("P003", "Jeans", 2000, 8, "32"));
    }
}