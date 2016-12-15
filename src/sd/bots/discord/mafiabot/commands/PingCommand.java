package sd.bots.discord.mafiabot.commands;

import sd.bots.discord.mafiabot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
/**
 * Default "Test if bot works" command.
 */
public class PingCommand implements Command {


    private final String HELP = "Usage: !ping";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Pong!").queue();

    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
}
