package sd.bots.discord.mafiabot;

import sd.bots.discord.mafiabot.util.Log;
import net.dv8tion.jda.core.events.DisconnectEvent;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by dylan on 10-9-2016.
 */
public class BotListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContent().startsWith("!") && event.getMessage().getAuthor().isBot() != true) Main.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(), event));
    }

    public void onReady(ReadyEvent event) {
        Log.logger("[Log]", "Logged in as: " + event.getJDA().getSelfUser().getName());
    }

    public void onReconnect(ReconnectedEvent event) {
        Log.logger("[Log]", "Reconnected to discord.");
    }

    public void onDisconnect(DisconnectEvent event) {
        Log.logger("[Log]", "Disconnected to discord.");
    }

}
