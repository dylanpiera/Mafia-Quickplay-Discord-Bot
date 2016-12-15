package sd.bots.discord.mafiabot.commands;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sd.bots.discord.mafiabot.Command;
import sd.bots.discord.mafiabot.modules.Player;

import static sd.bots.discord.mafiabot.Main.playerlist;

/**
 * Created by dylan on 15-12-2016.
 */
public class ListCommand implements Command {

    private boolean debug;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(playerlist.size() <= 0) {
            event.getChannel().sendMessage(event.getMember().getUser().getAsMention() + " There is nobody in the game!").queue();
            return false;
        }
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        try {
            if (args[0].equals("--debug")) {
                if(event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                    debug = true;
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            debug = false;
        }

        if(!debug) {
            String response = "List of Players in game:\n\n";

            for (Player player : playerlist) {
                response += "- " + player.getName() + "\n";
            }

            event.getChannel().sendMessage(response).queue();
        }
        if(debug) {
            String response = "List of Players in game and their roles!\n\n";

            for (Player player : playerlist) {
                response += "- " + player.getName() + "\t - " + player.getRole() + "\n";
            }

            event.getChannel().sendMessage(response).queue();
            debug = false;
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
