package products;

public class Hoodie extends Product {

    private String fit;

    // Constructor
    public Hoodie(String id,
                  String name,
                  double price,
                  int stock,
                  String fit) {

        super(id, name, "Hoodie",
                price, stock);

        this.fit = fit;
    }

    // Method Overriding
    @Override
    public void displayProduct() {

        super.displayProduct();

        System.out.println("Fit : "
                + fit);
    }
}