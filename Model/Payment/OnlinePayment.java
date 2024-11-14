package Model.Payment;

import java.util.Date;

public class OnlinePayment extends Payment {
    private String serviceProvider;


    // Constructor
    public OnlinePayment(int transactionNumber, double amount, Date dateOfTransaction, String serviceProvider) {
        super(transactionNumber, amount, dateOfTransaction);
        this.serviceProvider = serviceProvider;
    }

    public double processPayment(){
        return super.getAmount();
    }

    // Getter and Setter
    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}
