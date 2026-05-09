package payments;

public class CashPayment extends Payment {

    public CashPayment(String id,
                       double amount,
                       String date) {

        super(id, amount, date);
    }

    @Override
    public void processPayment()
            throws InvalidPaymentException {

        if (amount <= 0) {

            throw new InvalidPaymentException(
                    "Invalid cash amount.");
        }

        paymentStatus = "Paid";

        System.out.println(
                "[PAYMENT] Cash payment successful.");
    }
}