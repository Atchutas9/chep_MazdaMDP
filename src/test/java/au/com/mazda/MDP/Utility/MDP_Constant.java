/*
 *
 */
package au.com.mazda.MDP.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class MDP_Constant.
 *
 * @author cheaus
 */
public class MDP_Constant {

    /** The s excel file path. */
    public static String S_EXCEL_FILE_PATH = System.getProperty("user.dir")
            + "/src/test/java/au/com/mazda/MDP/TestData/MDP_TestCases_TestData.xlsx";

    /** The s sheet test cases. */
    public static String S_SHEET_TEST_CASES = "TestCases";

    /** The s sheet test data. */
    public static String S_SHEET_TEST_DATA = "TestData";

    /** The s sheet post code popup. */
    public static String S_SHEET_POST_CODE_POPUP = "PostCode";

    /**
     * The i col test case id. This will have all the id's for the columns in
     * spreadsheet
     */
    public static int I_COL_TEST_CASE_ID = 0;

    /** The i col run mode. */
    public static int I_COL_RUN_MODE = 1;

    /** The i col url. */
    public static int I_COL_URL = 2;

    /** The i col section name. */
    public static int I_COL_SECTION_NAME = 3;

    /** The i col paragraph1. */
    public static int I_COL_PARAGRAPH1 = 4;

    /** The i col paragraph2. */
    public static int I_COL_PARAGRAPH2 = 5;

    /** The i col paragraph3. */
    public static int I_COL_PARAGRAPH3 = 6;

    /** The i col postcode. */
    public static int I_COL_POSTCODE = 3;

    /** The s screenshot path. */
    public static String S_SCREENSHOT_PATH = System.getProperty("user.dir")
            + "/screenshots/";

    /** The s virtual box scripts path. */
    public static String S_VIRTUAL_BOX_SCRIPTS_PATH = System
            .getProperty("user.dir") + "/RunVirtualBoxScripts/";  //$NON-NLS-2$

    /** The s selenium grid shell script path. */
    public static String S_SELENIUM_GRID_SHELL_SCRIPT_PATH = System
            .getProperty("user.dir")
            + "/SeleniumGrid/SeleniumGrid_3.0.0-beta2/bashScript_SeleniumGrid.sh";

    /** The s logs html. */
    /*
     * public static String S_LOGS_HTML = System.getProperty("user.dir") +
     * "/src/test/java/au.com.mazda.MDP.Logs_HTML/MAZDA_MDP_Redevelopment_AutomationReport.html";
     */

    // public static final String S_BS_USERNAME = "cheproximity";
    // public static final String S_BS_AUTOMATE_KEY = "j3Hepy4RMEvPez9bNKhP";
    /** The Constant S_BS_USERNAME_ATC. */
    public static final String S_BS_USERNAME_ATC = "atchutasaragadam1";

    /** The Constant S_BS_AUTOMATE_KEY_ATC. */
    public static final String S_BS_AUTOMATE_KEY_ATC = "Yw3T8KPmCdyonEFvmkNr";
    // public static final String S_BS_URL = "https://" + S_BS_USERNAME + ":"
    // + S_BS_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    /** The Constant S_BS_URL. */
    public static final String S_BS_URL = "https://" + S_BS_USERNAME_ATC + ":"  //$NON-NLS-2$
            + S_BS_AUTOMATE_KEY_ATC + "@hub-cloud.browserstack.com/wd/hub";

    /** The Constant S_NODE_URL. */
    // public static final String S_NODE_URL = "http://127.0.0.1:4444";

    /** The Constant S_KOALA_LOCAL_URL. */
    // public static final String S_KOALA_LOCAL_URL = "http://localhost:3200/";

    // public static final String selenium_grid_Localhost =
    // "http://169.254.248.55:5566/wd/hub";
    // public static final String selenium_grid_Localhost =
    // "http://10.0.0.38:5555/wd/hub";
    // public static final String selenium_grid_Localhost =
    // "http://localhost:5555/wd/hub";
    // public static final String
    // selenium_grid_Localhost="http://10.0.2.15:5566/wd/hub";
    // public static final String
    // selenium_grid_Localhost="http://192.168.56.101:5566/wd/hub";
    /** The Constant S_SELENIUM_GRID_LOCALHOST. */
    // public static final String S_SELENIUM_GRID_LOCALHOST =
    // "http://192.168.32.34:5566/wd/hub";

    /** The Constant S_SEL_STANDALONE_JAR. */
    public static final String S_SEL_STANDALONE_JAR = "java -jar selenium-server-standalone-3.0.1.jar";

    /**
     * The Constant S_SEL_EXIT_SELGRID_PROCESS.
     */
    public static final String S_SEL_EXIT_SELGRID_PROCESS = "lsof -t -i :4444 | xargs kill";

    /** The Constant S_NODEURL. */
    public static final String S_NODEURL = "http://0.0.0.0:4444/wd/hub";

    /** The Constant _SKIP. */
    public static final String _SKIP = "N";

    /** The Constant _RUN. */
    public static final String _RUN = "Y";

    /** The Constant CONFIGURATOR_EXCEL_FILE_PATH. */
    public static final String CONFIGURATOR_EXCEL_FILE_PATH = System
            .getProperty("user.dir")
            + "/src/test/java/au/com/mazda/MDP/TestData/Configurator_TestData.xlsx";
    /** The Constant S_PATHSERVER. */
    public static final String S_PATHSERVER = System.getProperty("user.dir")
            + "/Browsers/" + "./seleniumstandalonescript.sh";
}
