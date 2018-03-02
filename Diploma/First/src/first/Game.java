package first;
import first.Location.Direction;
import java.io.*;
import java.util.*;

public class Game {
    private Player player;
    private Map map;
    private Scanner scanner = new Scanner(System.in);

    public void Start()
    {
        boolean playing = true;

        player = new Player();
        player.setName("Bill");
        
        map = new Map();
        
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("default.map");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Serialisation Failed" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Some IO error" + ex.getMessage());
        }        
        
        FileInputStream fileInputStream;
        
        try {
        fileInputStream = new FileInputStream("default.map"); 
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        map = (Map) objectInputStream.readObject();
        objectInputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Serialisation Failed" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Some IO error" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception error" + ex.getMessage());
        }    

        
        while(playing) {
            getUserInput();      
            updateWorld();            
            displayWorld();
        }
    }
    
    private void getUserInput()
    {
        System.out.println("Choose an option: 1) Move");
        int options = scanner.nextInt();
        Move();
    }
    
    private void Move(){
        System.out.println("Please choose a direction: 1) North 2) East 3) South 4) West");
        int options = scanner.nextInt();
        
        final Direction direction;
        switch (options) {
            case 1:
                direction = Direction.NORTH;
                break;
            case 2:
                direction = Direction.EAST;
                break;
            case 3:
                direction = Direction.SOUTH;
                break;
            case 4:
                direction = Direction.WEST;
                break;    
            default: 
                direction = Direction.NORTH;
                break;
        }
        map.moveCharacter(player, direction);
    }
    
    private void updateWorld(){
        
    }
    
    private void displayWorld() {
        
    }
}
