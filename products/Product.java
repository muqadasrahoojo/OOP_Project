package products;

public class Product {

    private String productId;

    private String productName;

    private String category;

    private double price;

    private int stock;

    // Constructor
    public Product(String productId,
                   String productName,
                   String category,
                   double price,
                   int stock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Reduce Stock
    public void reduceStock(int quantity)
            throws OutOfStockException {

        if (stock < quantity) {

            throw new OutOfStockException(
                    "Not enough stock for "
                    + productName);
        }

        stock -= quantity;
    }

    // Display Product
    public void displayProduct() {

        System.out.println("\n------------------------");

        System.out.println("Product ID : "
                + productId);

        System.out.println("Name       : "
                + productName);

        System.out.println("Category   : "
                + category);

        System.out.println("Price      : Rs."
                + price);

        System.out.println("Stock      : "
                + stock);

        System.out.println("------------------------");
    }
}

// Exception inside same file
class OutOfStockException extends Exception {

    public OutOfStockException(String message) {

        super(message);
    }
}