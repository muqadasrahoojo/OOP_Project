package products;

public class Shirt extends Product {

    private String material;

    // Constructor
    public Shirt(String id,
                 String name,
                 double price,
                 int stock,
                 String material) {

        super(id, name, "Shirt",
                price, stock);

        this.material = material;
    }

    // Method Overriding
    @Override
    public void displayProduct() {

        super.displayProduct();

        System.out.println("Material : "
                + material);
    }
}