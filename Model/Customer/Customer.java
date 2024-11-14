package Model.Customer;
public class Customer{
    private int IDCustomer;
    private String name, email, company;

    // Constructor
    public Customer(int iDCustomer, String name, String email, String company) {
        IDCustomer = iDCustomer;
        this.name = name;
        this.email = email;
        this.company = company;
    }

    
    // Getter and Setter
    public int getIDCustomer() {
        return IDCustomer;
    }
    public void setIDCustomer(int iDCustomer) {
        IDCustomer = iDCustomer;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    
}
