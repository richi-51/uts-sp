import Model.Reservation;
import Model.Room;
import Model.Customer.Customer;
import Model.Enum.ReservationStatus;
import Model.Enum.RoomStatus;
import controller.hotelController;
import view.*;

public class Main {
    public static void main(String[] args) {
        Customer customers[] = new Customer[2];
        Reservation reservations[] = new Reservation[2];
        Room rooms[][] = new Room[4][3];
        createDummy(customers, reservations, rooms);
        
        hotelController ctrl = new hotelController(reservations, customers);
        MainMenu showMenu = new MainMenu(ctrl);

        ctrl.processPayment("credit", 101);
        ctrl.processPayment("credit", 102);

        showMenu.printProcessPayment();
        showMenu.printTotalRevenue();
    }


    public static void createDummy(Customer customers[], Reservation reservations[], Room rooms[][]){
        customers[0] = new Customer(1, "Adrian", "adrian@example.com", "NewJeans");
        customers[1] =  new Customer(1, "Kezia", "kezia@coba.com", "wibuWibu");

        // Inisialisasi Ruangan
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (i == 0) {
                    rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 1000000, 4, RoomStatus.EMPTY);
                }else if (i == 2){
                    rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 1250000, 6, RoomStatus.EMPTY);
                }else if (i ==3){
                    rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 2350000, 10, RoomStatus.EMPTY);
                }else{
                    rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 2350000, 10, RoomStatus.EMPTY);
                }
            }
        }

        reservations[0]= new Reservation(1, 2, ReservationStatus.PAID , customers[0]);
        reservations[0].bookRoom("Basic", rooms);
        reservations[1] = new Reservation(2, 4, ReservationStatus.PAID, customers[1]);
        reservations[1].bookRoom("Basic", rooms);
    }
}
