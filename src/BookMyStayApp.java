import java.util.*;

class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class RoomInventory {

    private Map<String, Integer> roomAvailability = new HashMap<>();

    public void addRoom(String type, int count) {
        roomAvailability.put(type, count);
    }

    public boolean hasRoom(String type) {
        return roomAvailability.getOrDefault(type, 0) > 0;
    }

    public void reduceRoom(String type) {
        roomAvailability.put(type, roomAvailability.get(type) - 1);
    }
}

class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        if (!inventory.hasRoom(roomType)) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.reduceRoom(roomType);

        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {

        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());

        int nextNumber = assignedRoomsByType.get(roomType).size() + 1;

        return roomType + "-" + nextNumber;
    }
}

public class BookMyStayApp{

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.offer(new Reservation("Abhi", "Single"));
        bookingQueue.offer(new Reservation("Subha", "Single"));
        bookingQueue.offer(new Reservation("Vanmathi", "Suite"));

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single", 5);
        inventory.addRoom("Suite", 2);

        RoomAllocationService allocationService = new RoomAllocationService();

        while (!bookingQueue.isEmpty()) {
            Reservation r = bookingQueue.poll();
            allocationService.allocateRoom(r, inventory);
        }
    }
}