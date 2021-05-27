import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserService {

    private Hotel hotel = new Hotel();
    private List<Room> rooms = hotel.getRooms();


    //1. Pobierz listę wszystkich pokoi wraz z ich statusem (wolny-zajęty)
    public List<Room> getRooms() {
        return rooms;
    }

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer pokoju, który chcesz zarezerwować");
        int roomNumber = Integer.parseInt(scanner.next());
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomNumber() == roomNumber) {
                room.setAvailable(false);
                System.out.println("Zarezerwowano pokój numer " + room.getRoomNumber());
                return;
            }
        }
        System.out.println("Nie dało się zarezerwować podanego numeru pokoju, bo był już zajęty");
    }

    //4. Zwolnij pokój (podaj nr pokoju i jesli jest zajety, to go zwolnij)
    public void freeYourRoom() {
        Scanner scanner = new Scanner(System.in);
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
        return "UserService{" +
                "hotel=" + hotel +
                '}';
    }
}


