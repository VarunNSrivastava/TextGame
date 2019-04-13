import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private HashMap<String, Room> rooms;

    public Level() {
        rooms = new HashMap<String, Room>();
    }

    public void addRoom(String room) {
        rooms.put(room, new Room(room));
    }

    public void addPath(String firstRoom, String secondRoom) { //directed edge
        getRoom(firstRoom).addNeighbor(getRoom(secondRoom));
    }

    public void addTwoWayPath(String firstRoom, String secondRoom) { //undirected edge
        addPath(firstRoom,secondRoom);
        addPath(secondRoom,firstRoom);
    }

    public Room getRoom(String room) {
        return rooms.get(room);
    }

    public ArrayList<Room> getRooms () {
        ArrayList<Room> out = new ArrayList<>();
        for (String str : rooms.keySet()) {
            out.add(rooms.get(str));
        }
        return out;
    }
}
