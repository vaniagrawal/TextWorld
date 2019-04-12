import java.util.ArrayList;

public class Room {
    public String name;
    private ArrayList<Room> neighbors;
    private String description;
    private ArrayList<Item> items;

    public Room(String name){
        neighbors = new ArrayList<Room>();
        this.name = name;
    }
    public void addNeighbor(Room n){
        //add this node as a neighbor n
        neighbors.add(n);
    }
    public String getName(){
        return name;
    }
    public String getNeighborNames(){
        String neighborNames = "";
        for(Room neighbor: neighbors){
            neighborNames += neighbor.getName();
        }
        return neighborNames;
    }
    public Room getNeighbor(String name){
        for(Room n : neighbors){
            if(n.getName().equals(name)){
                return n;
            }
        }
        return null;
    }
    public ArrayList<Item> getItems(){
        return items;
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
    public Room getRandomNeighbor(){
        int randIndex = (int)(Math.random()*(neighbors.size()));
        return neighbors.get(randIndex);
    }

}

