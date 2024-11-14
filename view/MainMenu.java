package view;
import controller.*;

public class MainMenu {
    private hotelController ctrl;

    public MainMenu(hotelController ctrl) {
        this.ctrl = ctrl;
    }

    public void printProcessPayment(){
        System.out.println(ctrl.processPayment("credit", 111));
    }

    public void printTotalRevenue(){
        System.out.println(ctrl.calculateTotalRevenue());
    }
}
