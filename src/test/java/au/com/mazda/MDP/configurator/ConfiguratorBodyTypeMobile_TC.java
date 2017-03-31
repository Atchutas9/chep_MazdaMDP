package au.com.mazda.MDP.configurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorBodyTypeMobile_TC.
 */
public class ConfiguratorBodyTypeMobile_TC extends ConfiguratorMobile_PF {

    /**
     * Instantiates a new configurator body type mobile TC.
     *
     * @param driver
     *            the driver
     */
    public ConfiguratorBodyTypeMobile_TC(WebDriver driver) {
        super(driver);
    }

    /**
     * Execute config body test cases.
     *
     * @param model
     *            the model
     * @param body
     *            the body
     */
    @Test(description = "Executing the Test cases for the Bodytype selection Configurator Page")
    public void executeConfigBodyTestCases(String model, String body) {
        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);
            MDP_MyCustomisedLogs.info(
                    "Executing Test cases for Mobile Build a mazda select step");

            // verifypostcodepopup
            verifyPostcodePopup();

            // verify landing page
            verifyConfiguratorLandingPage();

            // Method to check model list
            verifyModelListPresence();

            // verify to select a model passed from excel
            verifySelectModel(model);

            MDP_MyCustomisedLogs.endTestCase(strTestName);
        } catch (Exception e) {
            e.printStackTrace();
            MDP_MyCustomisedLogs.error(e.toString());
        }

    }

    /**
     * Verify postcode popup.
     *
     * @throws Exception
     *             the exception
     */
    private void verifyPostcodePopup() throws Exception {

        isElementPresent(WE_LIST_POSTCODEPOPUP);

        getTextofElement(WE_LIST_POSTCODEPOPUP);

        // clickOnElement(WE_LIST_POSTCODECLOSE);

        sendValues(this.POSTCODE, "3000");
        // clickOnElement(WE_POSTCODESUBMIT);
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

    }
}
