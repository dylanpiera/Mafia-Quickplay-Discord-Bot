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

    public Player(Member JDAmember) {
        this.JDAmember = JDAmember;
        this.name = JDAmember.getUser().getName();
    }

    public Member getJDAmember() {
        return JDAmember;
    }

    public String getName() {
        return name;
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
}
