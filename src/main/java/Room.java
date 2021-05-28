import java.util.ArrayList;
import java.util.List;

public class Room {

    private int roomNumber;
    private int howManyPeople;
    private boolean hasBathroom;
    private boolean isAvailable;
    private List<Guest> guestsInRoom = new ArrayList<>();
    private boolean clean = true;

    public Room(int roomNumber, int howManyPeople, boolean hasBathroom, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.howManyPeople = howManyPeople;
        this.hasBathroom = hasBathroom;
        this.isAvailable = isAvailable;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public void setGuestsInRoom(List<Guest> guestsInRoom) {
        this.guestsInRoom = guestsInRoom;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", howManyPeople=" + howManyPeople +
                ", hasBathroom=" + hasBathroom +
                ", isAvailable=" + isAvailable +
                ", guestsInRoom=" + guestsInRoom +
                ", clean=" + clean +
                '}';
    }
}
