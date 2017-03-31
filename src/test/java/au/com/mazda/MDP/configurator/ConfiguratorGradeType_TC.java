package au.com.mazda.MDP.configurator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorGradeType_TC.
 */
public class ConfiguratorGradeType_TC extends Configurator_PF {

    /**
     * Instantiates a new configurator grade type TC.
     *
     * @param driver
     *            the driver
     */
    public ConfiguratorGradeType_TC(WebDriver driver) {
        super(driver);
    }

    /**
     * Execute config grade test cases.
     *
     * @param model
     *            the model
     * @param body
     *            the body
     * @param grade
     *            the grade
     * @param transmission
     *            the transmission
     * @param engineType
     *            the engine type
     */
    @Test(description = "Executing the Test cases for the Gradetype selection Configurator Page")
    public static void executeConfigGradeTestCases(String model, String body,
            String grade, String transmission, String engineType) {
        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);
            MDP_MyCustomisedLogs
                    .info("Executing Test cases for Gradetype select step");

            // verify gradesheader presence
            verifyGradesheaderPresence();

            // verify grade types present
            verifyGradetypePresence(grade);

            // verify grade description present
            verifyGradeDescriptionPresence(grade);

            // verify gradehighlights
            verifyGradeTransmissionEnginePresence(grade, transmission,
                    engineType);

            // verify stepcounter present
            verifyStepCounterPresence();

            // verify sticky footer presence
            verifyStickyFooterPresence();

            // verify CTA buttons presence
            verifyCtaButtonsPresence();

            // verify Featured Specs presence
            verifyFeatureSpecsPresence();

            MDP_MyCustomisedLogs.endTestCase(strTestName);

        } catch (Exception e) {
            e.printStackTrace();
            MDP_MyCustomisedLogs.error(e.toString());
        }
    }

    /**
     * Verify gradesheader presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyGradesheaderPresence() throws Exception {
        int count = getCountofElements(WE_LIST_HEADING_BUILD,
                "Heading in Configurator");
        MDP_MyCustomisedLogs
                .info("Count of Heading elements in Grade select step Configurator are : "
                        + count);

        Assert.assertEquals(getTextofElement(WE_SUBHEADING_BUILD).toUpperCase(),
                "SELECT A GRADE");
        getAllElements(WE_LIST_HEADING_BUILD,
                "Header in Grade select Configurator");
    }

    /**
     * Verify gradetype presence.
     *
     * @param grade
     *            the grade
     * @throws Exception
     *             the exception
     */
    private static void verifyGradetypePresence(String grade) throws Exception {
        int count = getCountofElements(WE_LIST_GRADETYPE, "Count of Gradetype");
        MDP_MyCustomisedLogs
                .info("Count of Gradetype in Select Grade are : " + count);

        getAllElements(WE_LIST_GRADETYPE, "Gradetype in Select Grade Step");
        selectThisElement(grade, WE_LIST_GRADETYPE);
        getTextofElement(WE_LIST_GRADEHIGHLIGHTS);
        // getImage(WE_GET_IMAGE1, "Gradetype Image in configurator");

    }

    /**
     * Verify grade description presence.
     *
     * @param grade
     *            the grade
     * @throws Exception
     *             the exception
     */
    private static void verifyGradeDescriptionPresence(String grade)
            throws Exception {

        selectThisElement(grade, WE_LIST_GRADETYPE);
        getAllElements(WE_DESCRIPTION, "Grade Description:  ");

    }

    /**
     * Verify grade transmission engine presence.
     *
     * @param grade
     *            the grade
     * @param transmission
     *            the transmission
     * @param engineType
     *            the engine type
     * @throws Exception
     *             the exception
     */
    private static void verifyGradeTransmissionEnginePresence(String grade,
            String transmission, String engineType) throws Exception {

        selectThisElement(grade, WE_LIST_GRADETYPE);
        selectThisElement(transmission, WE_LIST_GRADETRANSMISSIONS);
        getAllElements(WE_LIST_GRADEENGINES, "Engine type for selected Grade: "
                + grade + "  :Transmission:  " + transmission + ": ");

    }

    /**
     * Verify step counter presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyStepCounterPresence() throws Exception

    {
        int count = getCountofElements(WE_LIST_STEPCOUNTER,
                "count of stepcounter");
        MDP_MyCustomisedLogs
                .info("Count of stepcounter in configurator are : " + count);

        getStepcounterElements(WE_LIST_STEPCOUNTER, "Tooltip value");

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
        // getAllImages(WE_LIST_STICKYFOOTER, "Stickyfooter image");
        // selectThisElement("Next step", WE_LIST_BUTTONS);

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

    }

    /**
     * Verify feature specs presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyFeatureSpecsPresence() throws Exception {

        isElementPresent(WE_LIST_GRADEFEATURESPECS);
        selectThisElement("Next Step", WE_LIST_BUTTONS);

    }
}
