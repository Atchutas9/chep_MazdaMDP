/// *
// *
// */
// package au.com.mazda.MDP.TestCases;
//
// import org.testng.annotations.Test;
//
// import au.com.mazda.MDP.PageObjects_PF.PostCodePopp_PF;
// import au.com.mazda.MDP.Utility.MDP_Constant;
// import au.com.mazda.MDP.Utility.MDP_Excel;
// import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
//
//// TODO: Auto-generated Javadoc
/// **
// * The Class PostCodePopUp_Tc.
// *
// * @author cheaus
// */
// public class PostCodePopUp_Tc extends SuperClass {
//
// /**
// * Test verify close post code pop up.
// */
// @Test(description = "verifying close on post code pop up")
// public static void testVerifyClosePostCodePopUp() {
// try {
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// PostCodePopp_PF postcode_PF = new PostCodePopp_PF(driver);
// getURLKoala();
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// driver.navigate().refresh();
// postcode_PF.execute_PostCodeUP_Close();
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", "");
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
//
// }
//
// /**
// * Test verify get cookie post code.
// */
// @Test(description = "Get cookie for post code ")
// public static void testVerifyGetCookiePostCode() {
// try {
// // execute_getCookiePostCode
//
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// final PostCodePopp_PF postcode_PF = new PostCodePopp_PF(driver);
// getURLKoala();
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// postcode_PF.execute_getCookiePostCode();
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", "");
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
//
// }
//
// /**
// * Test verify post code popup presence.
// */
// @SuppressWarnings("unused")
// @Test(description = "verifying post code icon is present or not")
// public static void testVerifyPostCodePopupPresence() {
// try {
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// final PostCodePopp_PF postcode_PF = new PostCodePopp_PF(driver);
// getURLKoala();
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// // softAssert.assertEquals("xcy", "xcy" );
// postcode_PF.execute_PostCodePopUPPresence();
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", "");
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
//
// /**
// * Test verify submit post codepop up.
// */
// @Test(description = "Post Code Pop Up submit")
// public static void testVerifySubmitPostCodepopUp() {
// try {
//
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// final PostCodePopp_PF postcode_PF = new PostCodePopp_PF(driver);
// getURLKoala();
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// final int i_RowCount = MDP_Excel.getRowCount(
// MDP_Constant.S_EXCEL_FILE_PATH,
// MDP_Constant.S_SHEET_POST_CODE_POPUP);
//
// for (int i = 1; i <= i_RowCount; i++) {
//
// final String TestCaseID = MDP_Excel.getCellValue(
// MDP_Constant.S_EXCEL_FILE_PATH,
// MDP_Constant.S_SHEET_POST_CODE_POPUP, i,
// MDP_Constant.I_COL_TEST_CASE_ID);
// final String sRunMode = MDP_Excel.getCellValue(
// MDP_Constant.S_EXCEL_FILE_PATH,
// MDP_Constant.S_SHEET_POST_CODE_POPUP, i,
// MDP_Constant.I_COL_RUN_MODE);
// if (sRunMode.equalsIgnoreCase("yes")
// || sRunMode.equalsIgnoreCase("y")) {
// MDP_MyCustomisedLogs.startTestCase(TestCaseID);
//
// final String sPostCode = MDP_Excel.getCellValue(
// MDP_Constant.S_EXCEL_FILE_PATH,
// MDP_Constant.S_SHEET_POST_CODE_POPUP, i,
// MDP_Constant.I_COL_POSTCODE);
//
// if (sPostCode.length() == 4) {
// final int[] postcodeArray = new int[4];
// for (int i1 = 0; i1 < sPostCode.length(); i1++) {
// if (Character.isDigit(sPostCode.charAt(i1))) {
// postcodeArray[i1] = sPostCode.charAt(i1);
//
// }
//
// }
// if (postcodeArray.length > 0) {
// driver.navigate().refresh();
// postcode_PF.execute_PostCodeUP_Submit(sPostCode);
// getScreenshot(driver, str_DriverBrowserName,
// str_DriverOS, str_DriverVersion, TestCaseID,
// "PASS", sPostCode);
// } else {
//
// MDP_MyCustomisedLogs
// .info("Not executing the post code as the value from excel is : "
// + sPostCode);
//
// getScreenshot(driver, str_DriverBrowserName,
// str_DriverOS, str_DriverVersion,
// "verify_PostCodePopUp", "PASS", sPostCode);
// }
//
// } else {
//
// MDP_MyCustomisedLogs
// .info("Not executing the post code as the value from excel is : "
// + sPostCode);
//
// getScreenshot(driver, str_DriverBrowserName,
// str_DriverOS, str_DriverVersion, strTestName,
// "PASS", sPostCode);
// }
//
// MDP_MyCustomisedLogs.endTestCase("Post Code Pop Up");
//
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", sPostCode);
//
// } else {
// MDP_MyCustomisedLogs.skipTestCase(TestCaseID,
// "Skipping the test case < " + TestCaseID
// + " > as the Run Mode for this test case is < "
// + sRunMode + " >");
//
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", "");
// }
// }
//
// } catch (final Exception e)
//
// {
// MDP_MyCustomisedLogs.error(e.toString());
// }
//
// }
//
// }
