package TodoElProyecto;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.*;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.FileHandler;
import java.io.IOException;

public class CustomLogger {

    private static final Logger LOGGER = Logger.getLogger(CustomLogger.class.getName());

    static {
        try {
            // Crear un archivo de registro de errores que mantenga un registro de los errores de varias ejecuciones.
            Handler errorFileHandler = new FileHandler("errores.log", true);
            errorFileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(errorFileHandler);
            
            // Crear un archivo de registro de acciones de usuario con un nombre de archivo que incluya la fecha y hora.
            Handler userActionsFileHandler = new FileHandler("acciones-" + System.currentTimeMillis() + ".log");
            userActionsFileHandler.setFormatter(new CustomFormatter());
            LOGGER.addHandler(userActionsFileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "No se pudo crear el archivo de registro: " + e.getMessage(), e);
        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    private static class CustomFormatter extends Formatter {
        @Override
        public String format(java.util.logging.LogRecord record) {
            return record.getMessage() + "\n";
        }
    }

    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(record.getLevel()).append("] ");
        return builder.toString();
    }
}