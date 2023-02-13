package com.argon.sos.testing.log;


import lombok.Getter;
import lombok.Setter;
import snake2d.LOG;

import java.util.logging.Level;

/**
 * trace {@link Level#FINER}
 * debug {@link Level#FINE}
 * info {@link Level#INFO}
 * warn {@link Level#WARNING}
 * error {@link Level#SEVERE}
 */
public class Logger {

    public static final String PREFIX_MOD = "[MOD.PLANTTREE]";
    private final static Level DEFAULT_LEVEL = Level.INFO;

    private final static String LOG_MSG_FORMAT = "%s %s %s%s";

    private final String name;

    @Getter
    @Setter
    private Level level;

    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public Logger(String name) {
        this.name = name;
        this.level = DEFAULT_LEVEL;
    }

    public void info(String formatMsg, Object... args) {
        log("INFO: ", Level.INFO, formatMsg, args);
    }

    public void debug(String formatMsg, Object... args) {
        log("[DEBUG] ", Level.FINE, formatMsg, args);
    }

    public void trace(String formatMsg, Object... args) {
        log("[TRACE] ", Level.FINER, formatMsg, args);
    }

    public void warn(String formatMsg, Object... args) {
        logErr("[WARN] ", Level.WARNING, formatMsg, args);
    }

    public void error(String formatMsg, Object... args) {
        logErr("[ERROR] ", Level.SEVERE, formatMsg, args);
    }


    private void log(String msgPrefix, Level level, String formatMsg, Object... args) {
        if (this.level.intValue() <= level.intValue()) {
            LOG.ln(String.format(LOG_MSG_FORMAT,
                PREFIX_MOD,
                name,
                msgPrefix,
                String.format(formatMsg, args)));
        }
    }

    private void logErr(String msgPrefix, Level level, String formatMsg, Object... args) {
        if (this.level.intValue() <= level.intValue()) {
            LOG.err((String.format(LOG_MSG_FORMAT,
                PREFIX_MOD,
                name,
                msgPrefix,
                String.format(formatMsg, args))));
        }
    }
}
