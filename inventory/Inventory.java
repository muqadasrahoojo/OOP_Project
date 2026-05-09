package inventory;

import products.Product;

// Interface inside same file
interface Searchable {

    void searchByName(String name);

    void searchById(String id);
}

public class Inventory implements Searchable {

    private Product[] products = new Product[50];

    private int count = 0;

    private int lowStockThreshold = 5;

    // Add Product
    public void addProduct(Product p) {

        if (count < products.length) {

            products[count++] = p;

            System.out.println("[INVENTORY] Added: "
                    + p.getProductName());
        }
    }

    // Show All Products
    public void showAllProducts() {

        System.out.println("\n========== PRODUCT CATALOG ==========");

        for (int i = 0; i < count; i++) {

            products[i].displayProduct();
        }

        System.out.println("=====================================");
    }

    // Low Stock Alert
    public void showLowStockProducts() {

        System.out.println("\n===== LOW STOCK ALERT =====");

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (products[i].getStock() <= lowStockThreshold) {

                products[i].displayProduct();

                found = true;
            }
        }

        if (!found) {

            System.out.println("All products have sufficient stock.");
        }
    }

    // Get Product By ID
    public Product getProductById(String id) {

        for (int i = 0; i < count; i++) {

            if (products[i].getProductId()
                    .equalsIgnoreCase(id)) {

                return products[i];
            }
        }

        return null;
    }

    // Search By Name
    @Override
    public void searchByName(String name) {

        System.out.println("\n--- Search Results ---");

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (products[i].getProductName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                products[i].displayProduct();

                found = true;
            }
        }

        if (!found) {

            System.out.println("No product found.");
        }
    }

    // Search By ID
    @Override
    public void searchById(String id) {

        Product p = getProductById(id);

        if (p != null) {

            p.displayProduct();
        }

        else {

            System.out.println("No product found.");
        }
    }
}