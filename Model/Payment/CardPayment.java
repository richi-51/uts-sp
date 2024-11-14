package Model.Payment;
import java.util.Date;

public class CardPayment extends Payment{
    private String cardType, cardNumber;

    // Constructor
    public CardPayment(int transactionNumber, double amount, Date dateOfTransaction, String cardType,
            String cardNumber) {
        super(transactionNumber, amount, dateOfTransaction);
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    @Override
    public double processPayment(){
        if (this.cardType.equalsIgnoreCase("credit")) {
            double amount = super.getAmount();
            amount *= 1.02;
            super.setAmount(amount);
            return amount;
        }
        return super.getAmount();
    }

    // Getter and Setter
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
