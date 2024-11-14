package Model;
import Model.Enum.*;

public class Room {
    private int roomNumber;
    private int floor;
    private double price;
    private int capacity;
    private RoomStatus status;

    // Constructor
    public Room(int roomNumber, int floor, double price, int capacity, RoomStatus status) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.price = price;
        this.capacity = capacity;
        this.status = status;
    }


    public boolean isBooked(){
        return this.status == RoomStatus.BOOKED;
    }

    // Getter and Setter
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public RoomStatus getStatus() {
        return status;
    }
    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
