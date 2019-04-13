import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String name;
    private HashMap<String, Room> neighbors;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Entity> entities = new ArrayList<>();


    public Room(String name) {
        neighbors = new HashMap<String, Room>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Room n) {
        neighbors.put(n.getName(),n);
    }

    public Room getNeighbor(String name) {
        return (neighbors.get(name));
    }

    public ArrayList<String> getNeighborNames() {
        ArrayList<String> out = new ArrayList<String>();
        for (String s : neighbors.keySet()) {
            out.add(s);
        }
        return out;
    }

    public void addItem(String item) {
        items.add(new Item(item));
    }


    public void removeItem(String item) {items.remove(new Item(item)); }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addEntity(Entity ent) {
        entities.add(ent);
    }

    public void removeEntity(Entity entity) {
    }
}
