package sd.bots.discord.mafiabot.modules;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;

import java.util.ArrayList;

/**
 * Used to store all information required for the game of Mafia +
 * the JDA Member class for each player.
 */
public class Player {

    private Member JDAmember;
    private String name;
    private String alignment;
    private String role;

    public static final String VILLAGE = "Village";
    public static final String MAFIA = "Mafia";
    public static final String THIRD_PARTY = "Third_Party";
    public static final String VANILLA = "Vanilla";

    public Player(Member JDAmember, String alignment, String role) {
        this.JDAmember = JDAmember;
        this.name = JDAmember.getUser().getName();
        this.alignment = alignment;
        this.role = role;
    }

    public Member getJDAmember() {
        return JDAmember;
    }

    public String getName() {
        return name;
    }

    public String getRole() {return this.role;}

    public String getAlignment(){
        return this.alignment;
    }

    public static boolean isPlayerIn(ArrayList<Player> players, User user) {
        for (Player player: players) {
            if(player.name.equals(user.getName())) return true;
        }
        return false;
    }
    public static boolean isPlayerIn(ArrayList<Player> players, String name) {
        for (Player player: players) {
            if(player.name.equals(name)) return true;
        }
        return false;
    }

    public void assignAlignment(String alignment){
        this.alignment = alignment;
    }

    public void assignRole(String role){
        // this.role = role;
    }
}
