package first;

public class Player {

    private String name;
    private int health;
    private String skill;
    private Location location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = name;
        } else {
            System.out.println("Player already has a name: " + this.name);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getSkill() {   
        return skill;
    }

    public void setSkill(String skill) {
        if (this.skill == null) {
            this.skill = skill;
        } else {
            System.out.println("Player already has a skill: " + this.skill);
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    Location getLocation() {
        return this.location;
    }
}
