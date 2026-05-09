package payments;

public class CardPayment extends Payment {

    private String cardNumber;

    private String expiryDate;

    // Constructor
    public CardPayment(String id,
                       double amount,
                       String date,
                       String cardNumber,
                       String expiryDate) {

        super(id, amount, date);

        this.cardNumber = cardNumber;

        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment()
            throws InvalidPaymentException {

        if (cardNumber.length() != 16) {

            throw new InvalidPaymentException(
                    "Invalid card number.");
        }

        paymentStatus = "Paid";

        System.out.println(
                "[PAYMENT] Card payment successful.");
    }
}