package sd.bots.discord.mafiabot.commands;

import sd.bots.discord.mafiabot.Command;
import sd.bots.discord.mafiabot.modules.Player;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sd.bots.discord.mafiabot.util.Allignment;

import static sd.bots.discord.mafiabot.Main.playerlist;

public class JoinCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(Player.isPlayerIn(playerlist,event.getAuthor().getName())) {
            event.getChannel().sendMessage(event.getMember().getUser().getAsMention() + " you're already in the game!").queue();
            return false;
        }
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        playerlist.add(new Player(event.getMember(), Allignment.VILLAGE, null));
        // TO-DO: Add fix .VILLAGE to actual alignment and .VANILLA for actual roles
        event.getChannel().sendMessage(event.getMember().getUser().getAsMention() + " joined the game!").queue();
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
}
