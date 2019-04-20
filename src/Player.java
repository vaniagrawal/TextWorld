import java.util.ArrayList;

public class Player {

    private String name, description;
    private ArrayList<Item> items;
    private Level.Room currentRoom;

    public Player(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public Item removeItem(String name){
        for(Item item: items){
            if(item.getName().equals(name)){
                items.remove(item);
                return item;
            }
        }
        return null;

    }
    public ArrayList<Item> getItems(){
        return items;
    }

    public Level.Room getCurrentRoom(){
        return currentRoom;
    }
    public void setCurrentRoom(Level.Room newRoom){
        currentRoom = newRoom;

    }
    public boolean moveToRoom (String name){
        Level.Room neighbor = currentRoom.getNeighbor(name);
        if (neighbor != null) {
            return true;
        }
        return false;
    }

    public boolean takeItem(String itemName) {
        Item i = this.currentRoom.removeItem(itemName);
        this.addItem(i);
        return (i.equals(null));
    }

    public boolean dropItem(String itemName) {
        this.removeItem(itemName);
        this.currentRoom.addItem(itemName);
        return true;
    }


}
