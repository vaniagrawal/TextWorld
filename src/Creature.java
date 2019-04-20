
public abstract class Creature {


    protected Level.Room currentRoom;


    String creatureName;



    public Creature (Level.Room room, String name){


        this.currentRoom = room;


        this.creatureName = name;

    }


    public void setCurrentRoom(Level.Room newRoom) {


        this.currentRoom = newRoom;


    }

    public void moveRandom(){


        Level.Room next = currentRoom.getRandomNeighbor();


        moveToNextRoom(next);


    }

    public String getCreatureName() {


        return creatureName;


    }


    public void setNames(String names) {


        this.creatureName = names;


    }

    protected Level.Room getCurrentRoom (){


        return currentRoom;


    }


    protected boolean moveToNextRoom(Level.Room r){


        setCurrentRoom(r);


        currentRoom.removeCreature(this);


        currentRoom.addCreature(this);


        return(currentRoom != null);


    }


    public abstract void act();


}






