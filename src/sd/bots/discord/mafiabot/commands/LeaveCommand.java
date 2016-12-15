package sd.bots.discord.mafiabot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sd.bots.discord.mafiabot.Command;
import sd.bots.discord.mafiabot.modules.Player;

import static sd.bots.discord.mafiabot.Main.playerlist;

/**
 * Created by dylan on 15-12-2016.
 */
public class LeaveCommand implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(Player.isPlayerIn(playerlist,event.getAuthor().getName())) {
            return true;
        }
        event.getChannel().sendMessage(event.getMember().getUser().getAsMention() + " you aren't in the game!").queue();
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Player player = null;
        for(Player fplayer : playerlist) {
            if(fplayer.getName().equals(event.getAuthor().getName())) player = fplayer;
        }
        playerlist.remove(player);
        event.getChannel().sendMessage(event.getMember().getUser().getAsMention() + " left the game!").queue();
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
