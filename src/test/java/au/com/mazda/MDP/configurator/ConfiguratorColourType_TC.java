package au.com.mazda.MDP.configurator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

/**
 * The Class ConfiguratorColourType_TC.
 */
public class ConfiguratorColourType_TC extends Configurator_PF {

    /**
     * Instantiates a new configurator colour type TC.
     *
     * @param driver
     *            the driver
     */
    public ConfiguratorColourType_TC(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    /**
     * Execute config colour test cases.
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
    @Test(description = "Executing the Test cases for the Colour selection Configurator Page")
    public void executeConfigColourTestCases(String model, String body,
            String grade, String transmission, String engineType) {
        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);
            MDP_MyCustomisedLogs
                    .info("Executing test cases for Colour select step");

            // verify gradesheader presence
            verifyColourheaderPresence();

            // Method to verify exterior colour
            verifyExteriorcolourPresence(model, body, grade, transmission,
                    engineType);

            // Method to verify interior swatch images
            verifyInteriorOptionPresence(model, body, grade, transmission,
                    engineType);

            // verify stepcounter present
            // verifyStepCounterPresence();

            // verify CTA buttons presence
            verifyCtaButtonsPresence();

            // verify sticky footer presence
            verifyStickyFooterPresence();

            MDP_MyCustomisedLogs.endTestCase(strTestName);

        } catch (Exception e) {
            e.printStackTrace();
            MDP_MyCustomisedLogs.error(e.toString());
        }
    }

    /**
     * Verify colourheader presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyColourheaderPresence() throws Exception {
        int count = getCountofElements(WE_LIST_HEADING_BUILD,
                "Heading in Configurator");
        MDP_MyCustomisedLogs
                .info("Count of Heading elements in Grade select step Configurator are : "
                        + count);

        Assert.assertEquals(getTextofElement(WE_SUBHEADING_BUILD).toUpperCase(),
                "SELECT A COLOUR");
        getAllElements(WE_LIST_HEADING_BUILD,
                "Header in Grade select Configurator");
    }

    /**
     * Verify exteriorcolour presence.
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
     * @throws Exception
     *             the exception
     */
    private void verifyExteriorcolourPresence(String model, String body,
            String grade, String transmission, String engineType)
                    throws Exception {
        SoftAssert sa = new SoftAssert();
        selectThisElement("Exterior", WE_LIST_BODYTYPE);
        sa.assertTrue(true);
        int count = getCountofElements(this.WE_LIST_COLOURBUTTONS,
                "Count of exterior colour buttons");

        MDP_MyCustomisedLogs
                .info("Count of colour buttons elements in Configurator are : "
                        + count);

        getExteriorcolour(this.WE_LIST_COLOURBUTTONS,
                this.WE_LIST_EXTERIORTOOLTIP);
        sa.assertAll();
    }

    /**
     * Gets the exteriorcolour.
     *
     * @param WE_LIST_COLOURBUTTONS2
     *            the we list colourbuttons2
     * @param WE_LIST_EXTERIORTOOLTIP2
     *            the we list exteriortooltip2
     * @throws Exception
     *             the exception
     */
    private static void getExteriorcolour(
            List<WebElement> WE_LIST_COLOURBUTTONS2,
            List<WebElement> WE_LIST_EXTERIORTOOLTIP2) throws Exception {

        String colour = "";
        try {

            for (WebElement we : WE_LIST_COLOURBUTTONS2) {
                waitExplicit(we);

                getTooltipElement(we, "Tooltip");
                Thread.sleep(3000);
                clickOnElement(we);

                // getImage(WE_GET_IMAGE1, "Image for selected colour: ");

                MDP_MyCustomisedLogs.info("Colour for  :" + we.getText() + "");
            }
        } catch (Exception e) {
            MDP_MyCustomisedLogs.error("Colour  " + colour
                    + "  is not present in the webpage" + e.toString());
            throw new Exception("Colour  " + colour
                    + "  is not present in the webpage" + e.toString());
        }
    }

    /**
     * Verify interior option presence.
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
     * @throws Exception
     *             the exception
     */
    private static void verifyInteriorOptionPresence(String model, String body,
            String grade, String transmission, String engineType)
                    throws Exception {

        selectThisElement("Interior", WE_LIST_BODYTYPE);

        int count = getCountofElements(WE_LIST_SWATCHIMAGES,
                "Count of Interior options present");

        MDP_MyCustomisedLogs
                .info("Count of Interior swatch elements present in Configurator are : "
                        + count);

        getInterioroptions(WE_LIST_SWATCHIMAGES, WE_LIST_SWATCHIMAGES);
    }

    /**
     * Gets the interior options.
     *
     * @param wE_LIST_SWATCHIMAGES
     *            the w E LIS T SWATCHIMAGES
     * @param wE_LIST_SWATCHIMAGES2
     *            the w E LIS T SWATCHIMAGES 2
     * @throws Exception
     *             the exception
     */
    private static void getInterioroptions(
            List<WebElement> wE_LIST_SWATCHIMAGES,
            List<WebElement> wE_LIST_SWATCHIMAGES2) throws Exception {

        String tooltext = "";
        try {

            for (WebElement we : WE_LIST_SWATCHIMAGES) {
                waitExplicit(we);
                getTooltipElement(we, "Tooltip");
                // colour = we.getText();
                Thread.sleep(3000);
                clickOnElement(we);

                // getImage(WE_GET_IMAGE1, "Image for selected swatch: ");
                MDP_MyCustomisedLogs
                        .info("Swatch image for  :" + we.getText() + "");
            }
        } catch (Exception e) {
            MDP_MyCustomisedLogs.error("Image  " + tooltext
                    + "  is not present in the webpage" + e.toString());
            throw new Exception("Image  " + tooltext
                    + "  is not present in the webpage" + e.toString());
        }
    }

    /**
     * Verify step counter presence.
     *
     * @throws Exception
     *             the exception
     */

    // private static void verifyStepCounterPresence() throws Exception
    //
    // {
    // int count = getCountofElements(WE_LIST_STEPCOUNTER,
    // "Count of stepcounter");
    // MDP_MyCustomisedLogs
    // .info("Count of stepcounter in configurator are : " + count);
    //
    // getStepcounterElements(WE_LIST_STEPCOUNTER, "Tooltip value");
    //
    // }

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
        selectThisElement("Next step", WE_LIST_BUTTONS);

    }
}
