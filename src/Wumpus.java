public class Wumpus extends Entity {
    private String name;


    public Wumpus(String name) {
        super(name);
    }

    @Override
    public void moveRandomly(Room r) {
        isPlayerTwoRoomsAway(r);
    }

    private boolean isPlayerTwoRoomsAway(Room r) {
        for (String playerNeighbor : r.getNeighborNames()) {
            for (String myNeighbor : getCurrentRoom().getNeighborNames()) {
                if (playerNeighbor.equals(myNeighbor)) super.move(getCurrentRoom().getNeighbor(myNeighbor));
                if (r.equals(myNeighbor)) super.move(getCurrentRoom().getNeighbor(myNeighbor));
                if (r.equals(getCurrentRoom())) return true;
                return true;
            }
        }
        return false;
    }
}
