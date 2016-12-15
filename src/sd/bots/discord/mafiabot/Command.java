package sd.bots.discord.mafiabot;


import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {

    /**
     * @Returns: true to execute command, false to disable command.
     * */
    public boolean called(String[] args, MessageReceivedEvent event);
    /**
     * Activates when called returns true. Command Body.
     * */
    public void action(String[] args, MessageReceivedEvent event);
    /**
     * Set in place for the help command.
     * @TODO: Decide on how to do it.
     * */
    public String help();
    /**
     * Activates after action()
     * */
    public void executed(boolean success, MessageReceivedEvent event);
}
