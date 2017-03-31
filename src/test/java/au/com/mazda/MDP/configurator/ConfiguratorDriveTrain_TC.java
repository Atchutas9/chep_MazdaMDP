package au.com.mazda.MDP.configurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorDriveTrain_TC.
 */
public class ConfiguratorDriveTrain_TC extends Configurator_PF {

    /**
     * Instantiates a new configurator drive train TC.
     *
     * @param driver
     *            the driver
     */
    public ConfiguratorDriveTrain_TC(WebDriver driver) {
        super(driver);
    }

    /**
     * Execute config drive train test cases.
     *
     * @param model
     *            the model
     * @param body
     *            the body
     * @param driveTrain
     *            the drive train
     */
    @Test(description = "Executing the test cases for Drivetrain Configurator  Page")
    public void executeConfigDriveTrainTestCases(String model, String body,
            String driveTrain) {
        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);
            MDP_MyCustomisedLogs.info(
                    "Executing Test cases for Drivetrain step in configurator");

            // Method to check drivetrain header presence
            verifyDrivetrainHeader();

            // Method to check drivetraintype presence
            VerifyDriveTrainType(model, body, driveTrain);

            // Method to check stepcounter
            verifyStepCounterPresence();

            // Select a drivetrain and description
            verifyDrivetrainSelect(driveTrain);

            // method to check stickyfooter
            verifyStickyFooterPresence();

            // verify CTA buttons presence
            verifyCtaButtonsPresence();

            MDP_MyCustomisedLogs.endTestCase(strTestName);
        } catch (Exception e) {
            e.printStackTrace();
            MDP_MyCustomisedLogs.error(e.toString());
        }
    }

    /**
     * Verify drivetrain header.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyDrivetrainHeader() throws Exception {
        int count = getCountofElements(WE_LIST_HEADING_BUILD,
                "Heading in Configurator");
        MDP_MyCustomisedLogs.info(
                "Count of Heading elements in Configurator are : " + count);

        getAllElements(WE_LIST_HEADING_BUILD, "Headers in Configurator");
    }

    /**
     * Verify drive train type.
     *
     * @param model
     *            the model
     * @param body
     *            the body
     * @param driveTrain
     *            the drive train
     * @throws Exception
     *             the exception
     */
    private static void VerifyDriveTrainType(String model, String body,
            String driveTrain) throws Exception {
        int count = getCountofElements(WE_LIST_DRIVETRAINTYPE,
                "Drivetype elements in configurator");
        MDP_MyCustomisedLogs
                .info("Number of Drivetrains available for selected model are:  "
                        + count);

        getAllElements(WE_LIST_DRIVETRAINTYPE,
                "Drivetrains available for selected model:  ");

    }

    /**
     * Verify step counter presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyStepCounterPresence() throws Exception {
        int count = getCountofElements(WE_LIST_STEPCOUNTER,
                "count of stepcounter");
        MDP_MyCustomisedLogs
                .info("Count of stepcounter in configurator are : " + count);

        getStepcounterElements(WE_LIST_STEPCOUNTER, "Tooltip value");

    }

    /**
     * Verify drivetrain select.
     *
     * @param driveTrain
     *            the drive train
     * @throws Exception
     *             the exception
     */
    private static void verifyDrivetrainSelect(String driveTrain)
            throws Exception {
        selectThisElement(driveTrain, WE_LIST_DRIVETRAINTYPE);
        getImage(WE_GET_IMAGE1, "Image for selected model");
        getAllElements(WE_DESCRIPTION, "Drivetrain description:  ");

    }

    /**
     * Verify sticky footer presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyStickyFooterPresence() throws Exception {

        int count = getCountofElements(WE_LIST_STICKYFOOTER, "Sticky Footer");
        MDP_MyCustomisedLogs
                .info("Stickyfooter in configurator are : " + count);

        getAllElements(WE_LIST_STICKYFOOTER, "Stickyfooter value");
        getAllImages(WE_LIST_STICKYFOOTER, "Stickyfooter image");

    }

    /**
     * Verify cta buttons presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyCtaButtonsPresence() throws Exception {
        int count = getCountofElements(WE_LIST_BUTTONS, "CTA Buttons");
        MDP_MyCustomisedLogs.info("CTA Buttons in configurator are : " + count);
        getAllElements(WE_LIST_BUTTONS, "CTA Buttons: ");
        selectThisElement("Next step", WE_LIST_BUTTONS);
    }

}
