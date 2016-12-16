package sd.bots.discord.mafiabot.commands;

import sd.bots.discord.mafiabot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sd.bots.discord.mafiabot.modules.Player;

import java.util.*;

import static sd.bots.discord.mafiabot.Main.playerlist;

/**
 * Created by Pikachu on 12/15/2016.
 */

public class AssignCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event, List<String> roleList) {
        // TO-DO: Actually assign roles and alignment to players
        // DEBUG: event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Pong!").queue();
        Collections.shuffle(roleList);
        // Shuffle the role list
        Stack<String> roleStack = new Stack<String>();
        roleStack.addAll(roleList);
        // The above two lines converts the randomized list into a stack
        for(Player fplayer : playerlist){
            String role = roleStack.pop();
            fplayer.assignRole(role);
        }
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
