package sd.bots.discord.mafiabot.commands;

import sd.bots.discord.mafiabot.Command;
import sd.bots.discord.mafiabot.moduls.Player;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import static sd.bots.discord.mafiabot.Main.playerlist;

/**
 * Created by dylan on 10-9-2016.
 */
public class JoinCommand implements Command {



    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        for(Player player : playerlist ) {
            if(player.getName().equals(event.getMember().getUser().getName())) {
                event.getChannel().sendMessage(event.getMember().getUser().getAsMention() + " you're already in the game!").queue();
                return false;
            }
        }
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        playerlist.add(new Player(event.getMember()));
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
