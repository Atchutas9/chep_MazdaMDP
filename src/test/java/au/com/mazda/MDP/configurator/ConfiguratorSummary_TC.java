package au.com.mazda.MDP.configurator;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

/**
 * The Class ConfiguratorSummary_TC.
 */
public class ConfiguratorSummary_TC extends Configurator_PF {

    /** The sa. */
    SoftAssert sa = new SoftAssert();

    /**
     * Instantiates a new configurator summary TC.
     *
     * @param driver
     *            the driver
     */
    public ConfiguratorSummary_TC(WebDriver driver) {
        super(driver);

    }

    /**
     * Execute config summary test cases.
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
     * @param driveTrain
     *            the drive train
     */
    @Test(description = "Executing the test cases for the Configurator Summary Page")
    public void executeConfigSummaryTestCases(String model, String body,
            String grade, String transmission, String engineType,
            String driveTrain) {

        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);

            MDP_MyCustomisedLogs
                    .info("Executing the Summary Item page of config");

            // Method to check Bodytype header present
            verifySummaryheaderPresence();

            // Method to select a model
            verifySummaryItemPresence(model, body, grade, transmission,
                    engineType, driveTrain);

            // Method to check stepcounter
            verifyStepCounterPages(WE_LIST_STEPCOUNTER, WE_SUBHEADING_BUILD);

            // method to check featured specs
            verifyFeaturedSpecspresence();

            // Method to check Stickyfooter present
            verifyStickyFooterPresence();

            // verify CTA buttons presence
            verifyCtaButtonsPresence();

            // driver.close();

            MDP_MyCustomisedLogs.endTestCase(strTestName);
        } catch (Exception e) {
            e.printStackTrace();
            MDP_MyCustomisedLogs.error(e.toString());

        }

    }

    /**
     * Verify summaryheader presence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifySummaryheaderPresence() throws Exception {
        int count = getCountofElements(WE_LIST_HEADING_BUILD,
                "Heading in Configurator");
        MDP_MyCustomisedLogs
                .info("Count of Heading elements in Summary step Configurator are : "
                        + count);

        Assert.assertEquals(getTextofElement(WE_SUBHEADING_BUILD).toUpperCase(),
                "HERE'S YOUR SUMMARY");
        getAllElements(WE_LIST_HEADING_BUILD,
                "Header in Grade select Configurator");
    }

    /**
     * Verify summary item presence.
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
     * @param driveTrain
     *            the drive train
     * @throws Exception
     *             the exception
     */
    private void verifySummaryItemPresence(String model, String body,
            String grade, String transmission, String engineType,
            String driveTrain) throws Exception {

        List<String> elementsList = getAllElementsList(WE_LIST_SUMMARY,
                "Summary of Build Model");
        boolean gradePresent = checkIfValueIsInList(grade, elementsList,
                "Grade");
        boolean drivePresent = checkIfValueIsInList(driveTrain, elementsList,
                "DriveTrain");
        boolean transmissionPresent = checkIfValueIsInList(transmission,
                elementsList, "Transmission");
        boolean enginePresent = checkIfValueIsInList(engineType, elementsList,
                "EngineType");

        this.sa.assertTrue(gradePresent, "Grade is Present");
        this.sa.assertTrue(drivePresent, "DriveTrainPresent");
        this.sa.assertTrue(transmissionPresent, "Transmission Present");
        this.sa.assertTrue(enginePresent, "Engine Type Present");

        MDP_MyCustomisedLogs.info("Summary Page for Build Model:  ");
    }

    /**
     * Check if value is in list.
     *
     * @param str
     *            the str
     * @param elementsList
     *            the elements list
     * @param type
     *            the type
     * @return true, if successful
     */
    private static boolean checkIfValueIsInList(String str,
            List<String> elementsList, String type) {
        String toCheck = str.toLowerCase();
        boolean strExists = false;
        if (elementsList.contains(toCheck)) {
            strExists = true;
        }
        MDP_MyCustomisedLogs
                .info(type + "  " + str + " is present on Summary Page");
        return strExists;

    }

    /**
     * Gets the all elements list.
     *
     * @param elements
     *            the elements
     * @param str
     *            the str
     * @return the all elements list
     * @throws Exception
     *             the exception
     */
    public static List<String> getAllElementsList(List<WebElement> elements,
            String str) throws Exception {
        String sEleText = "";
        List<String> elementsList = new ArrayList<String>();
        try {
            for (WebElement ele : elements) {
                waitExplicit(ele);
                if (ele.getText() != null) {
                    sEleText = ele.getText();
                    elementsList.add(sEleText.toLowerCase());
                    MDP_MyCustomisedLogs.info("Elements in " + str + "are: "
                            + sEleText + " is present on page");
                    getScreenshot(getBrowserDetails(caps), strTestName, "Pass",
                            sEleText);

                }
            }

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(
                    sEleText + "is not present in the page " + e.toString());
            throw new Exception(
                    sEleText + "is not present in the page " + e.toString());
        }
        return elementsList;
    }

    /**
     * Verify step counter pages.
     *
     * @param elements
     *            the elements
     * @param heading
     *            the heading
     * @throws Exception
     *             the exception
     */
    private static void verifyStepCounterPages(List<WebElement> elements,
            WebElement heading) throws Exception {

        String tooltip = "";
        try {
            for (WebElement ele : elements) {
                waitExplicit(ele);
                if (ele.getText() != null) {

                    Actions action = new Actions(driver);
                    action.moveToElement(ele).click().perform();
                    WebElement we = ele.findElement(By.tagName("span"));
                    tooltip = we.getText();
                }

                String subHeading = heading.getText();
                // System.out.println("tootip from stepcounter
                // pages===="+tooltip+"heading======"+subHeading);
                MDP_MyCustomisedLogs.info("Elements in Tooltip are: " + tooltip
                        + "Element from Subheading are:  " + subHeading);
                if (tooltip.equalsIgnoreCase(subHeading)) {
                    MDP_MyCustomisedLogs
                            .info("Element from Tooltip equals Subheading");
                }
                getScreenshot(getBrowserDetails(caps), strTestName, "Pass",
                        tooltip);

            }

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(tooltip
                    + "is not present in the Stepcounter " + e.toString());
            throw new Exception(tooltip + "is not present in the Stepcounter "
                    + e.toString());

        }
        // return sEleText;
    }

    /**
     * Verify featured specspresence.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyFeaturedSpecspresence() throws Exception {
        MDP_MyCustomisedLogs.info("Featured Specs for Build model are:  ");

        mouseHoverElement(WE_LIST_FEATURESPECS, "Featued Specs for: ");

        clickOnElement(WE_LIST_FEATURESPECS);
        Thread.sleep(2000);
        getTextofElement(WE_LIST_GRADEFEATURESPECS);
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

}
