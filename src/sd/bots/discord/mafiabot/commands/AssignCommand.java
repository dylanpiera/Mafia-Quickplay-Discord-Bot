package sd.bots.discord.mafiabot.commands;

import sd.bots.discord.mafiabot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sd.bots.discord.mafiabot.modules.Player;

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
    public void action(String[] args, MessageReceivedEvent event) {
        // TO-DO: Actually assign roles and alignment to players
        // DEBUG: event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Pong!").queue();
        for(Player fplayer: playerlist){

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
