/*
 *
 */
package au.com.mazda.MDP.TestCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.mazda.MDP.Utility.MDP_Constant;
import au.com.mazda.MDP.Utility.MDP_Excel;
import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

// TODO: Auto-generated Javadoc
/**
 * The Class FindAllLinks_Tc.
 *
 * @author cheaus
 */
public class FindAllLinks_Tc extends SuperClass {

    /** The linkcount. */
    private static int linkcount;

    /** The link text. */
    private static String linkText;
    // private boolean bIsValid = false;

    private static SoftAssert sa = new SoftAssert();

    /**
     * Gets the links response.
     *
     * @param strTestCaseId
     *            the str test case id
     * @param strUrl
     *            the str url
     * @throws Exception
     *             the exception
     */
    private static void getLinksResponse(final String strTestCaseId,
            final String strUrl) throws Exception {

        try {

            MDP_MyCustomisedLogs
                    .info("Getting  Total child links for  " + strTestCaseId);

            linkcount = driver.findElements(By.tagName("a")).size();
            MDP_MyCustomisedLogs.info(
                    "Total number of links is/are : < " + linkcount + " >");  //$NON-NLS-2$

            for (int i = 0; i < linkcount; i++) {
                linkText = driver.findElements(By.tagName("a")).get(i)
                        .getText();
                final String url = driver.findElements(By.tagName("a")).get(i)
                        .getAttribute("href");

                MDP_MyCustomisedLogs.info("");

                if (!linkText.equals("")) {
                    MDP_MyCustomisedLogs.info(
                            "    Now testing for link text   " + linkText);

                    MDP_MyCustomisedLogs
                            .info("     Now testing for url    " + url);

                } else {
                    MDP_MyCustomisedLogs.info("     URL is blank    " + url);
                    // sa.assertFalse(false, " URL is blank " + url);

                }

                if (url != null) {
                    final boolean bIsValid = getResponseCode(url,
                            strTestCaseId);

                    if (bIsValid) {

                        MDP_MyCustomisedLogs.info("Response Status is < OK > ");
                        // sa.assertEquals(bIsValid, true);

                        MDP_MyCustomisedLogs
                                .info("Valid link: <<  " + url + "  >>");  //$NON-NLS-2$
                        // sa.assertTrue(true, "Valid link: << " + url + " >>");

                        Thread.sleep(1000);
                        driver.manage().timeouts().implicitlyWait(5,
                                TimeUnit.SECONDS);

                        if (!linkText.equals("")) {
                            driver.findElements(By.tagName("a")).get(i).click();
                            waitImplictly(driver, 60);
                            driver.manage().timeouts().implicitlyWait(5,
                                    TimeUnit.SECONDS);
                            MDP_MyCustomisedLogs.info("Clicked on :  < "
                                    + linkText + "  > and the URL is < " + url
                                    + " > ");
                            // sa.assertTrue(true, "Clicked on : < " + linkText
                            // + " > and the URL is < " + url + " > ");

                        } else {
                            waitImplictly(driver, 60);
                            // ((JavascriptExecutor)
                            // driver).executeScript("window.scrollTo(0,"
                            // +
                            // driver.findElements(By.tagName("a")).get(i).getLocation().y
                            // + ")");

                            // driver.findElements(By.tagName("a")).get(i).click();
                            driver.get(url);
                            waitImplictly(driver, 60);
                            driver.manage().timeouts().implicitlyWait(5,
                                    TimeUnit.SECONDS);
                            MDP_MyCustomisedLogs
                                    .info("Clicked on URL is < " + url + " > ");  //$NON-NLS-2$
                            // sa.assertTrue(true,
                            // "Clicked on URL is < " + url + " > ");

                        }

                        getScreenshot(driver, str_DriverBrowserName,
                                str_DriverOS, str_DriverVersion, strTestCaseId,
                                "PASS", linkText);

                    } else {

                        MDP_MyCustomisedLogs
                                .info("Broken link: <<  " + url + "  >>");
                        // sa.assertFalse(false,
                        // "Broken link: << " + url + " >>");//$NON-NLS-2$

                    }
                } else {

                    MDP_MyCustomisedLogs.info("No URL for" + linkText);
                    // sa.assertFalse(false, "No URL for" + linkText);

                    continue;
                }
            }

        } catch (final Exception e) {

            getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
                    str_DriverVersion, strTestCaseId, "FAIL", linkText);

            MDP_MyCustomisedLogs.info(e.toString());

        }
        sa.assertAll();
    }

    /**
     * Gets the response code.
     *
     * @param sCheckUrl
     *            the s check url
     * @param strTestCaseID
     *            the str test case ID
     * @return the response code
     * @throws Exception
     *             the exception
     */

    @SuppressWarnings("javadoc")
    private static boolean getResponseCode(final String sCheckUrl,
            final String strTestCaseID) throws Exception {
        boolean bValidResponse = false;
        int iResp_Code = 0;
        String sResp_Status = null;
        try {

            final URL u = new URL(sCheckUrl);
            final HttpURLConnection httpCon = (HttpURLConnection) u
                    .openConnection();
            httpCon.setRequestMethod("GET");
            httpCon.setConnectTimeout(5000);

            httpCon.connect();
            sResp_Status = httpCon.getResponseMessage();
            iResp_Code = httpCon.getResponseCode();

            MDP_MyCustomisedLogs
                    .info("HTTP Response Code is : [ " + iResp_Code + " ]");  //$NON-NLS-2$

            MDP_MyCustomisedLogs
                    .info("HTTP Response Status is : [ " + sResp_Status + " ]");  //$NON-NLS-2$

            if ((iResp_Code == 404) || (iResp_Code == 505)
                    || (iResp_Code == 524)) {
                bValidResponse = false;
            } else {
                bValidResponse = true;
            }

        } catch (final Exception e) {

            getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
                    str_DriverVersion, strTestCaseID, "FAIL", linkText);

            MDP_MyCustomisedLogs.error(e.toString()
                    + "|| description of the error : Response code is < "
                    + iResp_Code + " > with response status is: < "
                    + sResp_Status);

        }
        return bValidResponse;

    }

    // actual test case begins to verify and validate links
    /**
     * Test verify links campaigns.
     *
     * @throws Exception
     *             the exception
     */
    @Test(description = "verifying  and validating links")
    public static void testVerifyLinksCampaigns() throws Exception {

        MDP_MyCustomisedLogs.startTestCase(strTestName);

        verifyLinks_Execute();

        MDP_MyCustomisedLogs.endTestCase(strTestName);

    }

    // called method to verifying links
    /**
     * Verify links execute.
     *
     * @throws Exception
     *             the exception
     */
    private static void verifyLinks_Execute() throws Exception {

        try {

            final int i_RowCount = MDP_Excel.getRowCount(
                    MDP_Constant.S_EXCEL_FILE_PATH,
                    MDP_Constant.S_SHEET_TEST_CASES);
            for (int i = 1; i <= i_RowCount; i++) {

                final String strTestCaseID = MDP_Excel.getCellValue(
                        MDP_Constant.S_EXCEL_FILE_PATH,
                        MDP_Constant.S_SHEET_TEST_CASES, i,
                        MDP_Constant.I_COL_TEST_CASE_ID);
                final String strRunMode = MDP_Excel.getCellValue(
                        MDP_Constant.S_EXCEL_FILE_PATH,
                        MDP_Constant.S_SHEET_TEST_CASES, i,
                        MDP_Constant.I_COL_RUN_MODE);
                if (strRunMode.equalsIgnoreCase("y")
                        || strRunMode.equalsIgnoreCase("yes")) {

                    MDP_MyCustomisedLogs.startTestCase(strTestCaseID);

                    final String str_URL = MDP_Excel.getCellValue(
                            MDP_Constant.S_EXCEL_FILE_PATH,
                            MDP_Constant.S_SHEET_TEST_CASES, i,
                            MDP_Constant.I_COL_URL);

                    driver.get(str_URL);

                    MDP_MyCustomisedLogs.info("navigated to " + str_URL);

                    driver.manage().window().maximize();
                    waitImplictly(driver, 60);
                    loginToEpiServer();
                    getLinksResponse(strTestCaseID, str_URL);

                } else {

                    MDP_MyCustomisedLogs.skipTestCase(strTestCaseID,
                            "Skipping the test case < " + strTestCaseID
                                    + " > as the Run Mode for this test case is < "
                                    + strRunMode + " >");

                }

            }
        } catch (final Exception e) {

            MDP_MyCustomisedLogs.error(e.toString());
        }

    }

};
