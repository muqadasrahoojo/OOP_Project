package orders;

import users.Customer;

// Interface inside same file
interface Trackable {

    void trackStatus();
}

public class Order implements Trackable {

    private static int counter = 1000;

    private String orderId;

    private Customer customer;

    private OrderItem[] items = new OrderItem[10];

    private int itemCount = 0;

    private double totalAmount;

    private String orderStatus;

    private String orderDate;

    private String deliveryAddress;

    // Constructor
    public Order(Customer customer, String date) {

        this.orderId = "ORD" + (++counter);

        this.customer = customer;

        this.orderStatus = "Pending";

        this.orderDate = date;

        this.deliveryAddress = "Karachi";
    }

    // Get Order ID
    public String getOrderId() {

        return orderId;
    }

    // Add Item
    public void addItem(OrderItem item) {

        if (itemCount < items.length) {

            items[itemCount++] = item;
        }
    }

    // Calculate Total
    public double calculateTotal() {

        totalAmount = 0;

        for (int i = 0; i < itemCount; i++) {

            totalAmount += items[i].getSubtotal();
        }

        return totalAmount;
    }

    // Update Status
    public void updateStatus(String status) {

        orderStatus = status;

        System.out.println("[ORDER] "
                + orderId
                + " updated to "
                + status);
    }

    // Cancel Order
    public void cancelOrder() {

        orderStatus = "Cancelled";

        System.out.println("[ORDER] "
                + orderId
                + " cancelled.");
    }

    // Interface Method
    @Override
    public void trackStatus() {

        System.out.println("[TRACKING] Order "
                + orderId
                + " is "
                + orderStatus);
    }

    // Display Order
    public void displayOrder() {

        System.out.println("\n--------------------------");

        System.out.println("Order ID : " + orderId);

        System.out.println("Customer : "
                + customer.getName());

        System.out.println("Date     : "
                + orderDate);

        System.out.println("Address  : "
                + deliveryAddress);

        System.out.println("Status   : "
                + orderStatus);

        System.out.println("Items:");

        for (int i = 0; i < itemCount; i++) {

            items[i].display();
        }

        System.out.println("Total : Rs."
                + calculateTotal());

        System.out.println("--------------------------");
    }
}