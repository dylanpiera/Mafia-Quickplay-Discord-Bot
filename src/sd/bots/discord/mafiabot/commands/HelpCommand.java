package sd.bots.discord.mafiabot.commands;

import sd.bots.discord.mafiabot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class HelpCommand implements Command {

    private HashMap<String, Command> commands;

    public HelpCommand(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        //@Todo: Make the help command.

    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
