import java.util.HashMap;
import java.util.Map;

abstract class Room {

    protected int beds;
    protected int size;
    protected double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000);
    }
}


class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}


public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Hotel Room Inventory Status\n");

        System.out.println("Single Room:");
        System.out.println("Beds: " + single.getBeds());
        System.out.println("Size: " + single.getSize() + " sqft");
        System.out.println("Price per night: " + single.getPrice());
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single"));

        System.out.println();

        System.out.println("Double Room:");
        System.out.println("Beds: " + doubleRoom.getBeds());
        System.out.println("Size: " + doubleRoom.getSize() + " sqft");
        System.out.println("Price per night: " + doubleRoom.getPrice());
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double"));

        System.out.println();

        System.out.println("Suite Room:");
        System.out.println("Beds: " + suite.getBeds());
        System.out.println("Size: " + suite.getSize() + " sqft");
        System.out.println("Price per night: " + suite.getPrice());
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite"));
    }
}