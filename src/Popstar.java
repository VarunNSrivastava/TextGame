public class Popstar extends Entity {
    private String name;


    public Popstar(String name) {
        super(name);
    }

    @Override
    public void moveRandomly(Room r) {
        if (isPlayerTwoRoomsAway(r)) {
            super.moveRandomly(r);
        }
    }

    private boolean isPlayerTwoRoomsAway(Room r) {
        for (String playerNeighbor : r.getNeighborNames()) {
            for (String myNeighbor : getCurrentRoom().getNeighborNames()) {
                if (playerNeighbor.equals(myNeighbor)) return  true;
                if (r.equals(myNeighbor)) return  true;
                if (r.equals(getCurrentRoom())) return true;
                return true;
            }
        }
        return false;
    }
}
