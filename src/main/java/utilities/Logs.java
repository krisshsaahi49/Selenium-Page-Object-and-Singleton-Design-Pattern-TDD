package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

	private static Logger logger = LogManager.getLogger(Logs.class);
	
	public static void debug(String msg) {
		logger.debug(msg);
	}
	
	public static void error(String msg) {
		logger.error(msg);
	}
	
	public static void info(String msg) {
		logger.info(msg);
	}
}
