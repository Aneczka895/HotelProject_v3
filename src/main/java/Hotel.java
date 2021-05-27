import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
private Scanner scanner = new Scanner(System.in);
private Room room;


    public Hotel() {
//this constructor runs every time a Hotel instance is created
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

    //1. Pobierz listę wszystkich pokoi wraz z ich statusem (wolny-zajęty)
    public void getRoomsAndStatus() {
       rooms.stream()
                .forEach(room -> System.out.println("Numer pokoju: " + room.getRoomNumber() + " Dostępny? = " + room.isAvailable()));
    }


    //2. Pobierz listę wszystkich dostępnych pokoi
    public List<Integer> getAllAvailableRooms() {
        return rooms.stream()
                .filter(room -> room.isAvailable())
                .map(room -> room.getRoomNumber())
                .collect(Collectors.toList());
    }

    //3. Rezerwuj pokój (podaj nr pokoju i jeśli jest dostępny to go zarezerwuj).
    public void reserveRoomIfFree() {
        System.out.println("Podaj numer pokoju, który chcesz zarezerwować");
        int roomNumber = Integer.parseInt(scanner.next());
        System.out.println(rooms.get(1));
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomNumber() == roomNumber) {
                room.setAvailable(false);
                System.out.println("Zarezerwowano pokój numer " + room.getRoomNumber());
                System.out.println(rooms.get(1));
                return;
            }
        }
        System.out.println("Nie dało się zarezerwować podanego numeru pokoju, bo był już zajęty");
    }


    //4. Zwolnij pokój (podaj nr pokoju i jesli jest zajety, to go zwolnij)
    public void freeYourRoom() {
        System.out.println("Podaj numer pokoju, który chcesz zwolnić");
        int roomNumber = Integer.parseInt(scanner.next());
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isAvailable()) {
                room.setAvailable(true);
                System.out.println("Zwolniono pokój numer: " + room.getRoomNumber());
                return;
            }
        }
        System.out.println("Pokoju numer " + roomNumber + " nie dało się zwolnić, bo nie był zajęty");
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "rooms=" + rooms +
                '}';
    }
}

