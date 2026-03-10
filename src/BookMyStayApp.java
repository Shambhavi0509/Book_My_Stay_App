public class BookMyStayApp {

    // ABSTRACT ROOM CLASS
    static abstract class Room {

        protected int numberOfBeds;
        protected int squareFeet;
        protected double pricePerNight;

        public Room(int beds, int size, double price) {
            this.numberOfBeds = beds;
            this.squareFeet = size;
            this.pricePerNight = price;
        }

        public void displayRoomDetails() {
            System.out.println("Beds: " + numberOfBeds);
            System.out.println("Size: " + squareFeet + " sqft");
            System.out.println("Price per night: " + pricePerNight);
        }
    }

    // SINGLE ROOM
    static class SingleRoom extends Room {

        public SingleRoom() {
            super(1, 250, 1500.0);
        }
    }

    // DOUBLE ROOM
    static class DoubleRoom extends Room {

        public DoubleRoom() {
            super(2, 400, 2500.0);
        }
    }

    // SUITE ROOM
    static class SuiteRoom extends Room {

        public SuiteRoom() {
            super(3, 750, 5000.0);
        }
    }

    public static void main(String[] args) {

        // Availability variables (still static in UC2)
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        System.out.println("Hotel Room Initialization\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailability + "\n");

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailability + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailability);
    }
}