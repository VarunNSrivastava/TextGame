import java.util.HashMap;
import java.util.Scanner;

public class Simulator {

    private static Level level = new Level();
    private static Player player;


    public Simulator() { }


    public void init() {
        level.addRoom("closet");
        level.addRoom("hall");
        level.addRoom("bedroom");
        level.addRoom("bathroom");
        level.addRoom("toilet");
        level.addRoom("shower");

        level.addTwoWayPath("closet","hall"); //undirected edge
        level.addPath("hall","bedroom"); //directed edge
        level.addPath("toilet","hall");
        level.addPath("bedroom","bathroom");
        level.addPath("bathroom","shower");
        level.addPath("bathroom","toilet");

        initPlayer();
        initItems();
        initChickens();
        initPopstars();
        initWumpi();
    }

    private void initWumpi() { addWumpus("toilet","Nathaniel"); }

    private void initPopstars() {
        addPopstar("shower","Mark Sandal");
        addPopstar("shower","Mark Sandal's younger brother");
        addPopstar("shower","Mark Sandal's great aunt, Mariah");
        addPopstar("shower","Mark Sandal's twin brother, Greg, (not to be confused with his clone, Daniel)");
        addPopstar("shower","Mark Sandal's clone, Daniel");
    }


    private void initItems() {
        addItem("bathroom","soap");
        addItem("bedroom","lamp");
        addItem("hall","book");
    }

    private void initChickens() {
        addChicken("closet","Thomas");
        addChicken("shower","Marge");
        addChicken("shower","Gregory");

    }

    private void addPopstar(String room, String name) { level.getRoom(room).addEntity(new Popstar(name)); }

    public void addWumpus(String room, String name) {level.getRoom(room).addEntity(new Wumpus(name));}

    private void addChicken(String room, String name) {
        level.getRoom(room).addEntity(new Chicken(name));
    }

    private void addItem(String room, String item) {
        level.getRoom(room).addItem(item);
    }

    private void initPlayer() {
        player = new Player(level.getRoom("hall"));
    }


    public void run() {

        String response = "";
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("You are currently in the " + player.getCurrentRoom().getName());


            System.out.println("Would you like to 'move', 'look around', or 'grab'");
            response = in.nextLine();
            player.execute(response);
            moveEntities(player.getCurrentRoom());
        } while (!response.equals("quit"));
    }

    private void moveEntities(Room currentRoom) {
        for (Room r : level.getRooms() ) {
            for (Entity e : r.getEntities()) {
                e.moveRandomly(currentRoom);
            }
        }
    }
}
