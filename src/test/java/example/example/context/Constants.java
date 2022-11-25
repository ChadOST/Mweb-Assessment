package example.example.context;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Class is for Constants.
 *
 * @author Bharathish
 */
public class Constants {

	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	/** The Constant REPORT_DIRECTORY. */
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
    public static LocalDateTime now = LocalDateTime.now();   
	public final static String dateTime =dtf.format(now);
	public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult"+dateTime+".html";

	/** The Constant PROJECT_NAME. */
	public final static String PROJECT_NAME = "Mweb QA Assessment";

	/** The Constant EXTENT_CONFIG_PATH. */
	public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/test/resources/config/extent-config.xml";

	/** The Constant PROPERTY_FILE_PATH. */
	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/test/resources/config/test.properties";

	/** The Constant CHROME_DRIVER_PATH. */
	public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/test/resources/drivers/chromedriver.exe";
}
