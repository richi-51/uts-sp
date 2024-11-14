package Model.Customer;
import Model.Enum.*;

public class Member extends Customer{
    private double balance = 1000000;
    private CustomerType type;

    // Constructor
    public Member(int iDCustomer, String name, String email, String company, double balance, CustomerType type) {
        super(iDCustomer, name, email, company);
        this.balance = balance;
        this.type = type;
    }


    public void calculateBalance(double totalTrans) {
        if (this.type == CustomerType.VIP) {
            this.balance += totalTrans * 0.25;
        }else{
            this.balance += totalTrans * 0.1;
        }
    }

    public boolean checkBalance(double amountTrans){
        return balance >= amountTrans;
    }

    public void reduceBalance(double amountTrans){
        this.balance -= amountTrans;
    }


    public boolean isVIP(){
        return this.type == CustomerType.VIP;
    }


    // Getter and setter
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public CustomerType getType() {
        return type;
    }
    public void setType(CustomerType type) {
        this.type = type;
    }

}
