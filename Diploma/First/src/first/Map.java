
package first;

import java.io.Serializable;
import java.util.*;

public class Map implements Serializable{
       
    private List<Location> locations;
    private Location start;
    
    
    
    public Map()
    {
        locations = new ArrayList<>();
        Location start = new Location("Start");
        Location mountain = new Location("Mountain");
        Location canyon = new Location("Canyon");
        Location ravine = new Location("Ravine");
        Location slope = new Location("Slope");
        Location kiosk = new Location("Kiosk");
        
        start.setLink(Location.Direction.EAST, mountain);
        mountain.setLink(Location.Direction.WEST, start);
        mountain.setLink(Location.Direction.NORTH, canyon);
        mountain.setLink(Location.Direction.EAST, slope);
        mountain.setLink(Location.Direction.SOUTH, ravine);
        slope.setLink(Location.Direction.SOUTH, kiosk);
        kiosk.setLink(Location.Direction.NORTH, slope);
        kiosk.setLink(Location.Direction.WEST, start);
        
        locations.add(start);
        locations.add(slope);
        locations.add(mountain);
        locations.add(canyon);
        locations.add(ravine);
        
        
    }

    boolean moveCharacter(Player player, Location.Direction direction) {
        Location currentLocation = player.getLocation();
        Location destination = currentLocation.compass(direction);
        if(destination != null){
            currentLocation.exit(player);
            return true;
        } else{
            currentLocation.enter(player);
            return false;
        }
    }
}

