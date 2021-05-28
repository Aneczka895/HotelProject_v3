import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserService {

    private Hotel hotel = new Hotel();
    private List<Room> rooms = hotel.getRooms();
    private List<Guest> temporaryGuestsList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


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


   /* //Hotel cz. I: 3. Rezerwuj pokój (podaj nr pokoju i jeśli jest dostępny to go zarezerwuj).
    public void reserveRoomIfFree() {
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
    }*/

    //3. Rezerwuj pokój (podaj nr pokoju & gości - jeśli jest dostępny i przynajmniej jedna osoba jest pełnoletnia to
    // go zarezerwuj).
    public void reserveRoomIfFreeAndOneAdultPresent() {
        System.out.println("Dla każdego gościa, którego chcesz zameldować, podaj imię i datę urodzenia. " +
                "Gdy skończysz " +
                "podawać dane gości, wpisz -1\n");
        checkIfAtLeastOneAdult(createGuestList());

    }

    public List<Guest> createGuestList() {
        do {
            System.out.println("Podaj imię i nazwisko gościa");
            String guestName = scanner.nextLine();
            if (guestName.equals("-1")) {
                return temporaryGuestsList;
            }
            System.out.println("Podaj urodziny gościa w formacie YYYY-MM-DD");
            String guestBirthday = scanner.nextLine();
            Guest guest = new Guest(guestName, guestBirthday);
            temporaryGuestsList.add(guest);
        } while (true);
    }

    public void checkIfAtLeastOneAdult(List<Guest> guests) {
        int countAdults = 0;
        LocalDate todayDate = LocalDate.now();
        for (Guest guest : guests) {
            LocalDate dateOfBirth = guest.getBirthday();
            Period age = Period.between(dateOfBirth, todayDate);
            if (age.getYears() >= 18) {
                countAdults++;
            }
        }
        if (countAdults > 0) {
            System.out.println("Przynajmniej jedna osoba jest pełnoletnia. Sprawdzam, czy pokój jest dostępny.");
            reserveRoomIfFree();
        } else {
            System.out.println("Wśród gości powinna być minimum jedna osoba dorosła. Nie można zarezerwować pokoju");
        }

    }

    public void reserveRoomIfFree() {
        System.out.println("Podaj numer pokoju, który chcesz zarezerwować");
        int roomNumber = Integer.parseInt(scanner.next());
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomNumber() == roomNumber) {
                room.setAvailable(false);
                room.setGuestsInRoom(temporaryGuestsList);
                System.out.println("Zarezerwowano pokój numer " + room.getRoomNumber());
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
        return "UserService{" +
                "hotel=" + hotel +
                '}';
    }
}


