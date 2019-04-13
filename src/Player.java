import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Player extends Entity {
    private ArrayList<Item> items;

    public Player(Room currentRoom) {
        super(currentRoom);
        items = new ArrayList<Item>();
    }

    public void Player() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItem(String item) {items.add(new Item(item)); }

    public Item removeItem(Item item) {
        items.remove(item);
        return item;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Room getRoom() {
        return getCurrentRoom();
    }

    public void setRoom(Room room) { setCurrentRoom(room); }

    public void execute(String command) {
        if (command.contains("move")) move(command);
        else if (command.contains("look around")) lookAround();
        else if (command.contains("grab")) grab(command);
        else System.out.println("Sorry, I didn't get that.");
    }

    private void grab(String command) {
        String[] arr = command.split(" ");
        if (arr.length != 2) System.out.println("Please specify what you would like to grab");
        if (!pickup(arr[1])) System.out.println("Sorry, that item is not in this room");
        else System.out.println(arr[1] + " is now in your inventory");
    }

    private Boolean pickup(String str) {
        for (Item i : getCurrentRoom().getItems()) {
            if (i.getName().equals(str)) {
                getCurrentRoom().removeItem(str);
                addItem(i);
                return true;
            }
        }
        return false;
    }

    private void lookAround() {
        System.out.println("These are the neighboring rooms: ");
        System.out.println(getCurrentRoom().getNeighborNames().toString());
        System.out.println("These are the items in the room: ");
        System.out.print("[");
        for( Item i : getCurrentRoom().getItems()){
            System.out.print(i.getName() + ", ");
        }
        System.out.println("]");
        System.out.println("These are the other entities in the room: ");
        System.out.print("[");
        for( Entity i : getCurrentRoom().getEntities()){
            System.out.print(i.getName() + ", ");
        }
        System.out.println("]");    }

    private Boolean move(String command) {
        String[] arr = command.split(" ");
        if (arr.length != 2) {
            System.out.println("Please specify where you would like to move");
            return false;
        }
        String nextRoom = arr[1];
        Room nextR = getCurrentRoom().getNeighbor(nextRoom);

        if (nextRoom == null) {
            System.out.println("You can't go to " + nextRoom + ". Try again");
        } else {
            setCurrentRoom(nextR);
        }
        return true;
    }
}


