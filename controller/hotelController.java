package controller;
import Model.Reservation;
import Model.Customer.*;
import Model.Payment.CardPayment;
import Model.Payment.OnlinePayment;

import java.util.Date;

public class hotelController {
    private Reservation reservations[];
    private Customer customers[];
    private static int counter = 1;

    // Constructor
    public hotelController(Reservation[] reservations, Customer[] customers) {
        this.reservations = reservations;
        this.customers = customers;
    }

    // Getter and setter
    public Reservation[] getReservations() {
        return reservations;
    }
    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }
    public Customer[] getCustomers() {
        return customers;
    }
    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }


    // Functions
    public String processPayment(String paymentMethod, int roomNo){
        double totalAmount = 0;
        double byCard = 0;
        double byBalance = 0;
        Date dateNow = new Date();

        for (Reservation reservation : reservations) {
            if (roomNo == reservation.getRooms().getRoomNumber()) {
                totalAmount = reservation.getStayDay() * reservation.getRooms().getPrice();

                if (reservation.getCustomer() instanceof Member) {
                    Member member = (Member) reservation.getCustomer();
                    member.calculateBalance(totalAmount);

                    if (member.checkBalance(totalAmount)) {
                        member.reduceBalance(totalAmount);
                        byBalance = totalAmount;
                    }else{
                        double finalAmount = totalAmount - member.getBalance();
                        byBalance = member.getBalance();
                        member.setBalance(0);

                        
                        if (paymentMethod.equalsIgnoreCase("Credit Card")) {
                            CardPayment payment = new CardPayment(counter,finalAmount, dateNow, "Credit", "XXXXXXX");

                            reservation.setPaymentMethod(payment);

                            byCard = payment.processPayment();
                        }else{
                            byCard = finalAmount;
                            OnlinePayment paymentOnline = new OnlinePayment(counter, finalAmount, dateNow, "Bank_provider");
                            reservation.setPaymentMethod(paymentOnline);
                        }
                        return "Total payment: " + totalAmount + "\nTotal by Balance: " + byBalance + "\nOther method: " + byCard;

                    }

                }else{
                    if (paymentMethod.equalsIgnoreCase("Credit Card")) {
                        CardPayment payment = new CardPayment(counter,totalAmount, dateNow, "Credit", "XXXXXXX");

                        reservation.setPaymentMethod(payment);

                        totalAmount = payment.processPayment();
                    }else{
                        OnlinePayment paymentOnline = new OnlinePayment(counter, totalAmount, dateNow, "Bank_provider");
                        reservation.setPaymentMethod(paymentOnline);
                    }
                    return "Total payment: " + totalAmount;
                }
            }
        }
        return "Maaf nomor kamar belum dipesan!";
    }



    public double calculateTotalRevenue(){
        double total = 0;
        for (Reservation reservation : reservations) {
            total += reservation.getPaymentMethod().getAmount();
        }

        return total;
    }
}
