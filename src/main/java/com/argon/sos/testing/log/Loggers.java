package com.argon.sos.testing.log;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class Loggers {
    private final static Map<String, Logger> loggers = new HashMap<>();

    public static Logger getLogger(@SuppressWarnings("rawtypes") Class clazz) {
        return getLogger(clazz.getName());
    }

    public static Logger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            loggers.put(name, new Logger(name));
        }

        return loggers.get(name);
    }

    public static void setLevels(Level level) {
       setLevels("", level);
    }

    public static void setLevels(String nameStartsWith, Level level) {
        loggers.forEach((name, logger) -> {
            if (name.startsWith(nameStartsWith)) {
                logger.setLevel(level);
            }
        });
    }
}
