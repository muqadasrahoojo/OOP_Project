package payments;

public abstract class Payment {

    protected String paymentId;

    protected double amount;

    protected String paymentStatus;

    protected String paymentDate;

    // Constructor
    public Payment(String paymentId,
                   double amount,
                   String paymentDate) {

        this.paymentId = paymentId;

        this.amount = amount;

        this.paymentStatus = "Pending";

        this.paymentDate = paymentDate;
    }

    // Abstract Method
    public abstract void processPayment()
            throws InvalidPaymentException;

    // Receipt
    public void displayReceipt() {

        System.out.println("\n===== RECEIPT =====");

        System.out.println("Payment ID : "
                + paymentId);

        System.out.println("Amount     : Rs."
                + amount);

        System.out.println("Status     : "
                + paymentStatus);

        System.out.println("Date       : "
                + paymentDate);

        System.out.println("===================");
    }
}

// Exception inside same file
class InvalidPaymentException
        extends Exception {

    public InvalidPaymentException(
            String message) {

        super(message);
    }
}