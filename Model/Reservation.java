package Model;
import Model.Customer.Customer;
import Model.Payment.*;
import Model.Enum.*;

public class Reservation {
    private int IDReservation;
    private int stayDay;
    private ReservationStatus status;

    private Customer customer;
    private Room rooms;
    private Payment paymentMethod;


    // Constructor
    public Reservation(int iDReservation, int stayDay, ReservationStatus status, Customer customer) {
        IDReservation = iDReservation;
        this.stayDay = stayDay;
        this.status = status;
        this.customer = customer;

        // Inisialisasi Ruangan
        // for (int i = 0; i < rooms.length; i++) {
        //     for (int j = 0; j < rooms[i].length; j++) {
        //         if (i == 0) {
        //             this.rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 1000000, 4, RoomStatus.EMPTY);
        //         }else if (i == 2){
        //             this.rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 1250000, 6, RoomStatus.EMPTY);
        //         }else if (i ==3){
        //             this.rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 2350000, 10, RoomStatus.EMPTY);
        //         }else{
        //             this.rooms[i][j] = new Room(Integer.parseInt((i+1) + "0" + (j+1)), (i+1), 2350000, 10, RoomStatus.EMPTY);
        //         }
        //     }
        // }
    }


    public String bookRoom(String typeRoom, Room rooms[][]){
        if (typeRoom.equalsIgnoreCase("Basic")) {
            for (int i = 0; i < rooms[0].length; i++) {
                if (!rooms[0][i].isBooked()) {
                    rooms[0][i].setStatus(RoomStatus.BOOKED);
                    this.rooms = rooms[0][i];
                    return "Kamar berhasil dipesan";
                }
            }
        }
        else if (typeRoom.equalsIgnoreCase("Suite")) {
            for (int i = 0; i < rooms[1].length; i++) {
                if (!rooms[1][i].isBooked()) {
                    rooms[1][i].setStatus(RoomStatus.BOOKED);
                    this.rooms = rooms[1][i];
                    return "Kamar berhasil dipesan";
                }
            }
        }
        else if (typeRoom.equalsIgnoreCase("Deluxe")) {
            for (int i = 0; i < rooms[2].length; i++) {
                if (!rooms[2][i].isBooked()) {
                    rooms[2][i].setStatus(RoomStatus.BOOKED);
                    this.rooms = rooms[2][i];
                    return "Kamar berhasil dipesan";
                }
            }
        }
        else if (typeRoom.equalsIgnoreCase("Capsule")) {
            for (int i = 0; i < rooms[3].length; i++) {
                if (!rooms[3][i].isBooked()) {
                    rooms[3][i].setStatus(RoomStatus.BOOKED);
                    this.rooms = rooms[3][i];
                    return "Kamar berhasil dipesan";
                }
            }
        }else{
            return "Maaf tipe ruangan tidak ditemukan";
        }

        return "Maaf tipe kamar tersebut sedang penuh";
    }

    public String cancelBooking(Room rooms[][]){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j].getRoomNumber() == this.rooms.getRoomNumber()) {
                    rooms[i][j].setStatus(RoomStatus.EMPTY);
                    return "Pembatalan pesanan kamar berhasil dilakukan";
                }
                
            }
        }
        return "Pembatalan pesanan kamar gagal dilakukan";
    }


    public String checkAvailability(Room rooms [][]){
        String result = "Nomor kamar tersedia:\n";

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (!rooms[i][j].isBooked()) {
                    result += "-) " + rooms[i][j].getRoomNumber() + "\n";
                }
            }
        }
        return result;
    }




    // Getter and Setter
    public int getIDReservation() {
        return IDReservation;
    }
    public void setIDReservation(int iDReservation) {
        IDReservation = iDReservation;
    }
    public int getStayDay() {
        return stayDay;
    }
    public void setStayDay(int stayDay) {
        this.stayDay = stayDay;
    }
    public ReservationStatus getStatus() {
        return status;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Room getRooms() {
        return rooms;
    }
    public void setRooms(Room rooms) {
        this.rooms = rooms;
    }
    public Payment getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
