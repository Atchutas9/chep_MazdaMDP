package au.com.mazda.MDP.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
import au.com.mazda.MDP.configurator.Configurator_PF;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguratorLandingPage_TC.
 */
public class ConfiguratorLandingPage_TC extends Configurator_PF {

    /** The sa. */
    SoftAssert sa = new SoftAssert();

    /**
     * Instantiates a new configurator landing page TC.
     *
     * @param driver
     *            the driver
     */
    public ConfiguratorLandingPage_TC(WebDriver driver) {
        super(driver);

    }

    /**
     * Execute landing page test cases.
     *
     * @param model
     *            the model
     */
    @Test(description = "Executing the Test cases for the Configurator Landing Page")
    public void executeLandingPageTestCases(String model) {

        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);
            MDP_MyCustomisedLogs
                    .info("Executing Test cases for Configurator Landing Page");

            // verify header present
            verifyHeaderpresence();

            // verify list of models
            verifyModelListPresence();

            // select a model
            selectaModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            MDP_MyCustomisedLogs.error(e.toString());
        }
    }

    /**
     * Verify headerpresence.
     *
     * @throws Exception
     *             the exception
     */
    private void verifyHeaderpresence() throws Exception {
        int count = getCountofElements(WE_LIST_HEADING_BUILD,
                "Heading in Configurator");
        this.sa.assertEquals(count, 1);
        MDP_MyCustomisedLogs.info(
                "Count of Heading elements in Configurator are : " + count);

        // sa.assertEquals(getTextofElement(WE_SUBHEADING_BUILD).toUpperCase(),
        // "SELECT A MODEL");
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

        MDP_MyCustomisedLogs
                .info("Count of Model elements in Configurator Landing Page are : "
                        + count);

        getAllElements(WE_LIST_MODEL, "Models in Configurator Landing Page");
        // getAllImages(WE_LIST_MODEL,"Model Cars Images in configurator");
    }

    /**
     * Selecta model.
     *
     * @param model
     *            the model
     * @throws Exception
     *             the exception
     */
    private static void selectaModel(String model) throws Exception {
        selectThisElement(model, WE_SELECT_MODEL);
    }
}
