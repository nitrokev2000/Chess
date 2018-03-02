/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.Serializable;
import java.util.*;


/**
 *
 * @author Student
 */
public class Location implements Serializable {
    
    private String name;

    private enum LocationConsequences{NOTHING, WIN, LOSE}
    public enum Direction{NORTH, EAST, SOUTH, WEST}
    private java.util.Map<Direction, Location> compass;
    public Direction direction;
    public transient List<Player> players;
    private LocationConsequences consequences;
    
    
    public Location(String name){
        consequences = LocationConsequences.NOTHING;
        this.name = name;
    }
    
    public Location(String name, LocationConsequences consequences){
        this.name = name;
        this.consequences = consequences;
        compass = new HashMap<>();
        players = new ArrayList<>();
    }
    
    public void setLink(Direction direction, Location location){
        compass.put(direction, location);
    }
    
    public void exit(Player player) {
        this.players.remove(player);
    }
    
    public void enter(Player player) {
        player.setLocation(this);
        this.players.add(player);
    }
    
    public Location compass(Direction direction) {
        return compass.get(direction);
    }
}
