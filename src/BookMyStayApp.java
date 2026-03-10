


    abstract class Room {

        protected String roomType;
        protected int beds;
        protected double pricePerNight;

        public Room(String roomType, int beds, double pricePerNight) {
            this.roomType = roomType;
            this.beds = beds;
            this.pricePerNight = pricePerNight;
        }

        public void displayDetails() {
            System.out.println("Room Type: " + roomType);
            System.out.println("Beds: " + beds);
            System.out.println("Price per night: ₹" + pricePerNight);
        }
    }

    class SingleRoom extends Room {

        public SingleRoom() {
            super("Single Room", 1, 2000);
        }
    }

    class DoubleRoom extends Room {

        public DoubleRoom() {
            super("Double Room", 2, 3500);
        }
    }

    class SuiteRoom extends Room {

        public SuiteRoom() {
            super("Suite Room", 3, 6000);
        }
    }

    public class BookMyStayApp {

        public static void main(String[] args) {

            System.out.println("===== Hotel Booking System =====");


            Room single = new SingleRoom();
            Room doubleRoom = new DoubleRoom();
            Room suite = new SuiteRoom();


            int singleAvailable = 5;
            int doubleAvailable = 3;
            int suiteAvailable = 2;

            System.out.println("\n--- Room Details ---");

            single.displayDetails();
            System.out.println("Available Rooms: " + singleAvailable);

            System.out.println();

            doubleRoom.displayDetails();
            System.out.println("Available Rooms: " + doubleAvailable);

            System.out.println();

            suite.displayDetails();
            System.out.println("Available Rooms: " + suiteAvailable);

            System.out.println("\nApplication finished.");
        }
    }

