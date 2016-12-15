package sd.bots.discord.mafiabot.util;

/**
 * Created by dylan on 10-9-2016.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Log {
    public static String time() {
        //getting current date and time using Date class
        DateFormat df = new SimpleDateFormat("[HH:mm:ss]");

       /**
        * getting current date time using calendar class
        * An Alternative of above
        * */
        Calendar calobj = Calendar.getInstance();
        return(df.format(calobj.getTime()));
    }

    public static void logger(String type, String message) {

        System.out.println(Log.time() + " [Info] " + type + ": " + message );
    }

}