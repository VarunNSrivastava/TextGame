public class Entity {
    private String name;
    private Room currentRoom;

    public Entity(Room room) {
        this.currentRoom =room;
    }

    public Entity(String name) {
        this.name = name;
    }

    public void move(Room room) {
        currentRoom.removeEntity(this);
        room.addEntity(this);
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room r) {
        currentRoom = r;
    }

    public String getName() {
        return name;
    }

    public void moveRandomly(Room r) {
        int N = currentRoom.getNeighborNames().size();
        int randNum = (int) (Math.random() * N);
        int counter = 0;
        for (String str : currentRoom.getNeighborNames() ) {
            if (counter == N) {
                move(currentRoom.getNeighbor(str));
            }
            counter++;
        }
    }
}
