import java.util.*;

public class BookMyStayApp {

    /*
     ==========================================
     CLASS - RoomAllocationService
     ==========================================
     Handles reservation confirmation and room
     allocation while updating inventory.
     */

    static class RoomAllocationService {

        // Store all allocated room IDs
        private Set<String> allocatedRoomIds;

        // Store allocated rooms by room type
        private Map<String, Set<String>> assignedRoomsByType;

        public RoomAllocationService() {
            allocatedRoomIds = new HashSet<>();
            assignedRoomsByType = new HashMap<>();
        }

        public void allocateRoom(Reservation reservation, RoomInventory inventory) {

            String roomType = reservation.getRoomType();
            Map<String, Integer> availability = inventory.getRoomAvailability();

            if (!availability.containsKey(roomType) || availability.get(roomType) == 0) {
                System.out.println("No available rooms for " + roomType);
                return;
            }

            String roomId = generateRoomId(roomType);

            allocatedRoomIds.add(roomId);

            assignedRoomsByType
                    .computeIfAbsent(roomType, k -> new HashSet<>())
                    .add(roomId);

            availability.put(roomType, availability.get(roomType) - 1);

            System.out.println("Reservation Confirmed for: " + reservation.getGuestName());
            System.out.println("Room Type: " + roomType);
            System.out.println("Assigned Room ID: " + roomId);
            System.out.println("--------------------------------");
        }

        private String generateRoomId(String roomType) {

            String prefix = roomType.substring(0, 1).toUpperCase();

            int number = allocatedRoomIds.size() + 1;

            return prefix + number;
        }
    }

}