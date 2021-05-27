import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();



    public Hotel() {

        Room room1 = new Room(1, 3, true, false);
        Room room2 = new Room(2, 1, false, true);
        Room room3 = new Room(3, 4, true, false);
        Room room4 = new Room(4, 6, true, true);
        Room room5 = new Room(5, 5, true, true);
        Room room6 = new Room(6, 6, true, true);
        Room room7 = new Room(7, 6, true, true);
        Room room8 = new Room(8, 6, true, true);
        Room room9 = new Room(9, 6, true, true);
        Room room10 = new Room(10, 6, true, true);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);
        rooms.add(room9);
        rooms.add(room10);
    }

    public List<Room> getRooms() {
        return rooms;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "rooms=" + rooms +
                '}';
    }
}

