package Logging;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MiLogger {
    public static Logger milogger = Logger.getLogger(MiLogger.class.getName());
    String file_name = "/opt/tomcat/latest/logs/SumaLogging" +  getCurrentTimeStamp() + ".log";

    public MiLogger() throws IOException {
        FileHandler fh = new FileHandler(file_name, true);
        milogger.addHandler(fh);
        MyFormatter formatter2 = new MyFormatter();
        fh.setFormatter(formatter2);
    }

    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
