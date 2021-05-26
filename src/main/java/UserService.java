import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

        private Hotel hotel = new Hotel();
        private Room room;

        //1. Pobierz listę wszystkich pokoi
        public List<Room> getRooms() {
            return hotel.getRooms();
        }

        //2. Pobierz listę wszystkich dostępnych pokoi
    public List<Room> getAllAvailableRooms() {
            return getRooms().stream()
                    .filter(room -> room.isAvailable())
                    .collect(Collectors.toList());
    }


        //3. Rezerwuj pokój (podaj nr pokoju i jeśli jest dostępny to go zarezerwuj).
        public void reserveRoomIfFree(int roomNumber) {
            for (Room room : getRooms()) {
                if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                    System.out.println("Zarezerwowano pokój numer " + room.getRoomNumber());
                    room.setAvailable(false);
                    return;
                }
            }
            System.out.println("Nie dało się zarezerwować podanego numeru pokoju");
        }

/*        hotel.reserveRoomIfFree(10);
        hotel.reserveRoomIfFree(10);
        hotel.roomCheckout(10);
        hotel.reserveRoomIfFree(10);*/

        //4. Zwolnij pokój (podaj nr pokoju i jesli jest zajety, to go zwolnij)
        public void freeYourRoom(int roomNumber) {
            for (Room room : getRooms()) {
                if (room.getRoomNumber() == roomNumber && !room.isAvailable()) {
                    room.setAvailable(true);
                    System.out.println("Zwolniono pokój numer: " + room.getRoomNumber());
                    return;
                }
            }
            System.out.println("Pokoju numer " + roomNumber + " nie dało się zwolnić, bo nie był zajęty");
        }




//hotel.freeYourRoom(10);
    }


