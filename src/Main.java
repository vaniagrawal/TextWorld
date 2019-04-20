import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Command> commands = new HashMap<>();
    private static Player p = new Player("Vani", "its me");
    private static Level g = new Level(p);
    public static void main(String[] args) {

        g.addRoom("hall", "long, narrow, endless, claustrophobic hallway");
        g.addRoom("closet" , "dark, dark closet");
        g.addRoom("dungeon" , "WARNING: dragon approaching");

        Item stick = new Item ("stick","long woody thing");
        Item bowAndArrow = new Item ("bow and arrow", "archery");
        g.getRoom("hall").addItem(stick);
        g.getRoom("dungeon").addItem(bowAndArrow);

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall","closet");

        p.setCurrentRoom(g.getRoom("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        g.createRandomChickens(5);
        g.createPopStar(2);
        g.createWumpus(1);

        initialCommands();


        do {

            System.out.println("You are currently in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do?");
            System.out.print(" - ");
            response = s.nextLine();
            Command command = findingTheCommand(response);
            command.executeMethod();
            g.updateAllCreatures();
        } while (!response.equals("quit"));


    }

    private static void initialCommands(){
        commands.put("take",new TakeCommand(g));
        commands.put("add a room", new addARoomCommand(g));
        commands.put("drop",new DropCommand(g));
        commands.put("look", new LookCommand(p));
        commands.put("quit", new QuitCommand(g));
        commands.put("go", new GoCommand(g));

    }

    private static Command findingTheCommand(String response){
        String command = getFirstWordIn(response);

        Command c = commands.get(command);
        if (c==null)return new nonexistantCommand();
        c.initializeMethod(response);

        return c;
    }

    private static String getFirstWordIn(String response) {
        if (response.indexOf(" ") == -1){
            return response;
        }
        return response.substring(0,response.indexOf(" "));
    }


}