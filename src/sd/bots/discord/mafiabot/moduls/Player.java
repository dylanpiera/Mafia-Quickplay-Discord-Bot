package sd.bots.discord.mafiabot.moduls;

import net.dv8tion.jda.core.entities.Member;

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
}