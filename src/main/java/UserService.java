import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserService {

    private Hotel hotel = new Hotel();

    public List<Room> getRooms() {
        return hotel.getRooms();
    }

    //1. Pobierz listę wszystkich pokoi wraz z ich statusem (wolny-zajęty)
    public void getRoomsAndStatus() {
        hotel.getRoomsAndStatus();
    }


    //2. Pobierz listę wszystkich dostępnych pokoi
    public List<Integer> getAllAvailableRooms() {
        return hotel.getAllAvailableRooms();
    }

    //3. Rezerwuj pokój (podaj nr pokoju i jeśli jest dostępny to go zarezerwuj).
    public void reserveRoomIfFree() {
        hotel.reserveRoomIfFree();
    }


    //4. Zwolnij pokój (podaj nr pokoju i jesli jest zajety, to go zwolnij)
    public void freeYourRoom() {
       hotel.freeYourRoom();
    }



    /*//1. Pobierz listę wszystkich pokoi wraz z ich statusem (wolny-zajęty)
    public List<Room> getRooms() {
        return hotel.getRooms();
    }

    public void getRoomsAndStatus() {
        *//*List<Room> rooms = getRooms();
        for (Room room : rooms) {
            System.out.println("Numer pokoju: " + room.getRoomNumber() + " Dostępny: " + room.isAvailable());
        }*//*
       getRooms().stream()
                .forEach(room -> System.out.println("Numer pokoju: " + room.getRoomNumber() + " Dostępny? = " + room.isAvailable()));
    }

    //2. Pobierz listę wszystkich dostępnych pokoi
    public List<Integer> getAllAvailableRooms() {
        return getRooms().stream()
                .filter(room -> room.isAvailable())
                .map(room -> room.getRoomNumber())
                .collect(Collectors.toList());
    }


    //3. Rezerwuj pokój (podaj nr pokoju i jeśli jest dostępny to go zarezerwuj).
    public void reserveRoomIfFree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer pokoju, który chcesz zarezerwować");
        int roomNumber = Integer.parseInt(scanner.next());
        System.out.println(getRooms().get(1));
        for (Room room : getRooms()) {
            if (room.isAvailable() && room.getRoomNumber() == roomNumber) {
                room.setAvailable(false);
                System.out.println("Zarezerwowano pokój numer " + room.getRoomNumber());
                System.out.println(getRooms().get(1));
                return;
            }
        }
        System.out.println("Nie dało się zarezerwować podanego numeru pokoju, bo był już zajęty");
    }

*//*        hotel.reserveRoomIfFree(10);
        hotel.reserveRoomIfFree(10);
        hotel.roomCheckout(10);
        hotel.reserveRoomIfFree(10);*//*

    //4. Zwolnij pokój (podaj nr pokoju i jesli jest zajety, to go zwolnij)
    public void freeYourRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer pokoju, który chcesz zwolnić");
        int roomNumber = Integer.parseInt(scanner.next());
        for (Room room : getRooms()) {
            if (room.getRoomNumber() == roomNumber && !room.isAvailable()) {
                room.setAvailable(true);
                System.out.println("Zwolniono pokój numer: " + room.getRoomNumber());
                return;
            }
        }
        System.out.println("Pokoju numer " + roomNumber + " nie dało się zwolnić, bo nie był zajęty");
    }*/

    @Override
    public String toString() {
        return "UserService{" +
                "hotel=" + hotel +
                '}';
    }
//hotel.freeYourRoom(10);
}


