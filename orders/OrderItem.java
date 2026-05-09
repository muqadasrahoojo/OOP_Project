package orders;

import products.Product;

public class OrderItem {

    private Product product;

    private int quantity;

    private double subtotal;

    // Constructor
    public OrderItem(Product product,
                     int quantity) {

        this.product = product;

        this.quantity = quantity;

        calculateSubtotal();
    }

    // Calculate Subtotal
    public void calculateSubtotal() {

        subtotal =
                product.getPrice() * quantity;
    }

    // Getter
    public double getSubtotal() {

        return subtotal;
    }

    // Display
    public void display() {

        System.out.println(
                product.getProductName()
                + " x"
                + quantity
                + " = Rs."
                + subtotal);
    }
}