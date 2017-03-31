/*
 *
 */
package au.com.mazda.MDP.Utility;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import au.com.mazda.MDP.TestCases.SuperClass;

// TODO: Auto-generated Javadoc
/**
 * The Class MDP_MyCustomisedLogs.
 *
 * @author cheaus customised logs to print in console, log file, html reports
 */
public class MDP_MyCustomisedLogs extends SuperClass {

    /** The my log. */
    private static Logger myLog = Logger
            .getLogger(MDP_MyCustomisedLogs.class.getName());

    /**
     * Debug.
     *
     * @param message
     *            the message
     */
    public static void debug(final String message) {

        myLog.debug(message);
        System.out.println(message);
        Reporter.log(message);

    }

    // end test case
    /**
     * End test case.
     *
     * @param sTestCaseID
     *            the s test case ID
     */
    public static void endTestCase(final String sTestCaseID) {
        myLog.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "Ends Test Case ID "  //$NON-NLS-2$
                + sTestCaseID + "             XXXXXXXXXXXXXXXXXXXXXX");
        myLog.info("X");
        myLog.info("X");
        myLog.info("X");
        myLog.info("X");

        System.out.println(
                "XXXXXXXXXXXXXXXXXXXXXXX             " + "Ends Test Case ID "  //$NON-NLS-2$
                        + sTestCaseID + "             XXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("X");
        System.out.println("X");
        System.out.println("X");
        System.out.println("X");

        Reporter.log(
                "XXXXXXXXXXXXXXXXXXXXXXX             " + "Ends Test Case ID "  //$NON-NLS-2$
                        + sTestCaseID + "             XXXXXXXXXXXXXXXXXXXXXX");
        Reporter.log("X");
        Reporter.log("X");
        Reporter.log("X");
        Reporter.log("X");

    }

    /**
     * Error.
     *
     * @param message
     *            the message
     */
    public static void error(final String message) {

        myLog.error(message);
        System.out.println(message);
        Reporter.log(message);

    }

    /**
     * Fatal.
     *
     * @param message
     *            the message
     */
    public static void fatal(final String message) {

        myLog.fatal(message);
        System.out.println(message);
        Reporter.log(message);

    }

    // giving information about the test case
    /**
     * Info.
     *
     * @param message
     *            the message
     */
    public static void info(final String message) {

        myLog.info(message);
        System.out.println(message);
        Reporter.log(message);

    }

    // skip test case
    /**
     * Skip test case.
     *
     * @param sTestCaseID
     *            the s test case ID
     * @param message
     *            the message
     */
    public static void skipTestCase(final String sTestCaseID,
            final String message) {

        myLog.info("XXXXXXXXXXXXXXXXXXXXXXX             " + " Test case ID "  //$NON-NLS-2$
                + sTestCaseID
                + " is skipped            XXXXXXXXXXXXXXXXXXXXXX. The Reason for skipping test case is  < "
                + message + " >");
        myLog.info("X");
        myLog.info("X");
        myLog.info("X");
        myLog.info("X");

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXX             "
                + " Test case ID " + sTestCaseID
                + " is skipped          XXXXXXXXXXXXXXXXXXXXXX. The Reason for skipping test case is  < "
                + message + " >");
        System.out.println("X");
        System.out.println("X");
        System.out.println("X");
        System.out.println("X");

        Reporter.log("XXXXXXXXXXXXXXXXXXXXXXX             " + " Test case ID "  //$NON-NLS-2$
                + sTestCaseID
                + " is skipped             XXXXXXXXXXXXXXXXXXXXXX. The Reason for skipping test case is  < "
                + message + " >");
        Reporter.log("X");
        Reporter.log("X");
        Reporter.log("X");
        Reporter.log("X");

    }

    // to print log for the beginning of the test case, to know which test case
    // is being executed
    /**
     * Start test case.
     *
     * @param sTestCaseID
     *            the s test case ID
     */
    public static void startTestCase(final String sTestCaseID) {

        myLog.info(
                "**********************************************************************************");
        myLog.info(
                "**********************************************************************************");
        myLog.info("$$$$$$$$$$$     Starts executing Test case ID        "
                + sTestCaseID + "          $$$$$$$$$$$$$");
        myLog.info(
                "**********************************************************************************");
        myLog.info(
                "**********************************************************************************");

        System.out.println(
                "**********************************************************************************");
        System.out.println(
                "**********************************************************************************");
        System.out.println(
                "$$$$$$$$$$$    Starts executing Test case ID          "
                        + sTestCaseID + "          $$$$$$$$$$$$$");
        System.out.println(
                "**********************************************************************************");
        System.out.println(
                "**********************************************************************************");

        Reporter.log(
                "**********************************************************************************");
        Reporter.log(
                "**********************************************************************************");
        Reporter.log("$$$$$$$$$$$      Starts executing Test case ID        "
                + sTestCaseID + "          $$$$$$$$$$$$$");
        Reporter.log(
                "**********************************************************************************");
        Reporter.log(
                "**********************************************************************************");

    }

    /**
     * Warn.
     *
     * @param message
     *            the message
     */
    public static void warn(final String message) {

        myLog.warn(message);
        System.out.println(message);
        Reporter.log(message);

    }

}
