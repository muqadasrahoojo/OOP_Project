package reports;

import inventory.Inventory;
import orders.Order;

public class Report {

    private Inventory inventory;

    // Constructor
    public Report(Inventory inventory) {

        this.inventory = inventory;
    }

    // Inventory Report
    public void generateInventoryReport() {

        System.out.println(
                "\n===== INVENTORY REPORT =====");

        inventory.showAllProducts();

        inventory.showLowStockProducts();
    }

    // Sales Report
    public void generateSalesReport(
            Order[] orders,
            int count) {

        System.out.println(
                "\n===== SALES REPORT =====");

        double total = 0;

        for (int i = 0; i < count; i++) {

            orders[i].displayOrder();

            total += orders[i]
                    .calculateTotal();
        }

        System.out.println(
                "Total Revenue : Rs."
                + total);
    }
}