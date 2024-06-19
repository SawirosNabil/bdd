package com.teklab.framework.utilities.reportmanagers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jManager {

public static Logger log= LogManager.getLogger(Log4jManager.class);

/**
*Logs info text messages to the log file & Extent report
*
**@param message
*/


public static void info(String message) {log.info(message);
}

/**
*Logs debug text messages to the log file & Extent report
*
**@param message
*/






public static void debug(String message) {log.debug (message);
}

/**
*Logs error text messages to the log file & Extent report
*
**@param message
*/





public static void error(String message) {log.error (message);

}




public static void warn(String message) {log.warn(message);


}



public static void fatal(String message) {log.fatal(message);

}


public static void startTestCase(String sTestCaseName)
{log.info("**************************************************");
log.info("xxxxxxxxxxxxxxxxxxxxxxxxxx--Start Test Case: "+sTestCaseName +  "  --xxxxxxxxxxxxxxxxx");}
public static void startTestCase() {
	
	{log.info("**************************************************");
	log.info("$$$$$$$$$$$$$$$$$$$$$$     " + " ---Start test case--" + "    $$$$$$$$$$$$$$$$$$$");
	}
	}


	public static void endTestCase() {

log.info("xxxxxxxxxxxxxxx      "  +   " ---End of test case---" +"   xxxxxxxxxx");
log.info("x");
log.info("x");

	}


	













}


