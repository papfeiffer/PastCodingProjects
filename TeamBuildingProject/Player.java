/**
 * Created by paigepfeiffer on 4/5/17.
 */
public class Player {

    public static final String OFF_ROLE_NAME = "Off";
    public static final String DEF_ROLE_NAME = "Def";
    public static final String SUP_ROLE_NAME = "Sup";
    public static final String ORG_ROLE_NAME = "Org";

    private String name;
    private int strength;
    private int agility;
    private int skill;
    private int total;
    private String role;


    public Player(String n, int str, int agi, int ski) {
        this.name = n;
        this.strength = str;
        this.agility = agi;
        this.skill = ski;
        this.total = str + agi + ski;
        this.role = determineRole(this);
    }

    public String getName() { return name; }

    public int getStrength() { return strength; }

    public int getAgility() { return agility; }

    public int getSkill() { return skill; }

    public int getTotal() { return total; }

    public String getRole() {return role; }

    public void setRole(String role) {this.role = role;}

    /**
     * Returns a string detailing a player's best role based on their strength, agility, and skill
     * @param player
     * @return
     */
    private static String determineRole(Player player) {

        int strength = player.getStrength();
        int agility = player.getAgility();
        int skill = player.getSkill();


        if (skill > strength && skill > agility) {

            return ORG_ROLE_NAME;

        } else if (strength > skill && agility > skill) {

            return OFF_ROLE_NAME;

        } else if (strength > agility && skill > agility) {

            return DEF_ROLE_NAME;

        } else {

            return SUP_ROLE_NAME;

        }

    }

}
