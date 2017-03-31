package au.com.mazda.MDP.configurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorBodyType_TC.
 */
public class ConfiguratorBodyType_TC extends Configurator_PF {

    /** The sa. */
    SoftAssert sa = new SoftAssert();

    /**
     * Instantiates a new configurator body type TC.
     *
     * @param driver
     *            the driver
     */
    public ConfiguratorBodyType_TC(WebDriver driver) {
        super(driver);

    }

    // @Test(description = "Executing the Test cases for the Bodytype selection
    /**
     * Execute config body test cases.
     *
     * @param model
     *            the model
     * @param body
     *            the body
     */
    // Configurator Page")
    @Test(priority = 0, description = "Select a Body  :: 'Build a Mazda' ")
    public void executeConfigBodyTestCases(String model, String body) {
        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);
            MDP_MyCustomisedLogs
                    .info("Executing Test cases for Bodytype select step");

            //
            verifyPostcodepopup();

            // verify landing page
            verifyConfiguratorLandingPage();

            // Method to check model list
            verifyModelListPresence();

            // Method to select a model
            verifySelectModel(model);

            // Method to check bodytype present
            verifyBodyTypePresence(body);

            // method to check body decsription present
            verifyBodyDescriptionPresence(body);

            // Method to check stepcounter
            verifyStepCounterPresence();

            // Method to verify CTA buttons
            verifyCtaButtonsPresence();

            // Method to check Stickyfooter present
            verifyStickyFooter();

            MDP_MyCustomisedLogs.endTestCase(strTestName);
        } catch (Exception e) {
            e.printStackTrace();
            MDP_MyCustomisedLogs.error(e.toString());
        }

    }

    /**
     * Verify postcodepopup.
     *
     * @throws Exception
     *             the exception
     */
    private void verifyPostcodepopup() throws Exception {
        isElementPresent(WE_LIST_POSTCODEPOPUP);
        getTextofElement(WE_LIST_POSTCODEPOPUP);

        clearFieldValue(this.POSTCODE, "Values");
        Thread.sleep(3000);
        sendValues(this.POSTCODE, "3000");
        clickOnElement(WE_POSTCODESUBMIT);
        // clickOnElement(WE_LIST_POSTCODECLOSE);

    }

    /**
     * Verify configurator landing page.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyConfiguratorLandingPage() throws Exception {

        int count = getCountofElements(WE_LIST_HEADING_BUILD,
                "Heading in Configurator");

        MDP_MyCustomisedLogs.info(
                "Count of Heading elements in Configurator are : " + count);

        getAllElements(WE_LIST_HEADING_BUILD, "Headers in Configurator");

    }

    /**
     * Verify model list presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyModelListPresence() throws Exception {
        int count = getCountofElements(WE_LIST_MODEL,
                "Models in Configurator Landing Page");

        // sa.assertNotNull(getCountofElements(WE_LIST_MODEL, "Model count"));
        MDP_MyCustomisedLogs
                .info("Count of Model elements in Configurator Landing Page are : "
                        + count);
        // sa.assertNotNull(WE_LIST_MODEL);

        getAllElements(WE_LIST_MODEL, "Models in Configurator Landing Page");
        // sa.assertNotNull(WE_LIST_MODEL);
        // getAllImages(WE_LIST_MODEL,"Model Cars Images in configurator");
    }

    /**
     * Verify select model.
     *
     * @param model
     *            the model
     * @throws Exception
     *             the exception
     */
    private static void verifySelectModel(String model) throws Exception {
        selectThisElement(model, WE_SELECT_MODEL);

        isElementPresent(WE_LIST_POSTCODEPOPUP);
        clickOnElement(WE_POSTCODESUBMIT);

    }

    /**
     * Verify body type presence.
     *
     * @param body
     *            the body
     * @throws Exception
     *             the exception
     */
    private static void verifyBodyTypePresence(String body) throws Exception {
        int count = getCountofElements(WE_LIST_BODYTYPE, "Count of Bodytype");
        MDP_MyCustomisedLogs
                .info("Count of Bodytype in configurator are : " + count);

        getAllElements(WE_LIST_BODYTYPE, "Bodytype in configurator");
        selectThisElement(body, WE_LIST_BODYTYPE);
        // getAllImages(WE_GET_IMAGE, "Bodytype Images in configurator");

    }

    /**
     * Verify body description presence.
     *
     * @param body
     *            the body
     * @throws Exception
     *             the exception
     */
    private static void verifyBodyDescriptionPresence(String body)
            throws Exception {

        selectThisElement(body, WE_LIST_BODYTYPE);
        getAllElements(WE_DESCRIPTION, "Bodytype Description:  ");

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
     * Verify cta buttons presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyCtaButtonsPresence() throws Exception {
        int count = getCountofElements(WE_LIST_BUTTONS, "CTA Buttons");
        MDP_MyCustomisedLogs.info("CTA Buttons in configurator are : " + count);
        getAllCtaButtons(WE_LIST_BUTTONS, "CTA Buttons: ");

    }

    /**
     * Verify sticky footer.
     *
     * @throws Exception
     *             the exception
     */
    private void verifyStickyFooter() throws Exception {
        int count = getCountofElements(WE_LIST_STICKYFOOTER, "sticky footer");
        MDP_MyCustomisedLogs
                .info("stickyfooter in configurator are : " + count);

        getAllElements(WE_LIST_STICKYFOOTER, "Stickyfooter value");
        // getAllImages(WE_LIST_STICKYFOOTER, "Stickyfooter image");
        selectThisElement("Next step", WE_LIST_BUTTONS);
        this.sa.assertAll();
    }

}
