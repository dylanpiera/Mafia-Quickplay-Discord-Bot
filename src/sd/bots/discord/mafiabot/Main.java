package sd.bots.discord.mafiabot;

import sd.bots.discord.mafiabot.commands.*;
import sd.bots.discord.mafiabot.moduls.Player;
import sd.bots.discord.mafiabot.util.CommandParser;
import sd.bots.discord.mafiabot.util.Sneaky;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    /**
     * Initialise all variables needed for JDA to work
     */
    private static JDA jda;
    public static final CommandParser parser = new CommandParser();
    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    /**
     * Initialise variables for MafiaBot
     */

    public static ArrayList<Player> playerlist = new ArrayList<>(), alivelist = new ArrayList<>(), deadlist = new ArrayList<>();

    public static void main(String[] args) {
        try {
            //Sneaky.token is the bot token. Change this to your own token.
            jda = new JDABuilder(AccountType.BOT).setToken(Sneaky.token).addListener(new BotListener()).buildBlocking();
            jda.setAutoReconnect(true);
        } catch(Exception e) {
            e.printStackTrace();
        }

        commands.put("ping", new PingCommand());
        commands.put("join", new JoinCommand());
        //always put help last
        commands.put("help", new HelpCommand(commands));
    }

    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if(commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);

            }
        }

    }

}
