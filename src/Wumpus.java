
public class Wumpus extends Creature {


    private Player player;
    private Level.Room room;


    public Wumpus(Level.Room wumpusRoom, String name) {


        super(wumpusRoom, name);


        this.room = wumpusRoom;


    }


    public void act(Player p) {


        this.player = p;


        act();


    }


    @Override


    public void act() {


        Level.Room next = avoidPlayer();


        if (next != null) {


            this.moveToNextRoom(next);


        }


    }


    private Level.Room avoidPlayer() {


        Level.Room playerRoom = player.getCurrentRoom();


        Level.Room next = room.getRandomNeighbor();
        ;


        if (playerRoom.neighborsCreatures(room)) {


            if (next.equals(playerRoom)) {


                room.neighbors.remove(playerRoom);


                next = room.getRandomNeighbor();


            }


        }


        return next;


    }

}