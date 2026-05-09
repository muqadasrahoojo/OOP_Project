package products;

public class Trouser extends Product {

    private String waistSize;

    // Constructor
    public Trouser(String id,
                   String name,
                   double price,
                   int stock,
                   String waistSize) {

        super(id, name, "Trouser",
                price, stock);

        this.waistSize = waistSize;
    }

    // Method Overriding
    @Override
    public void displayProduct() {

        super.displayProduct();

        System.out.println("Waist Size : "
                + waistSize);
    }
}