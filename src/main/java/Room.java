public class Room {

    private int roomNumber;
    private int howManyPeople;
    private boolean hasBathroom;
    private boolean isAvailable;

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


    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", howManyPeople=" + howManyPeople +
                ", hasBathroom=" + hasBathroom +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
