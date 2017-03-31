/// **
// *
// */
// package au.com.mazda.MDP.TestCases;
//
// import org.testng.annotations.Test;
//
// import au.com.mazda.MDP.PageObjects_PF.DropDown_Pf;
// import au.com.mazda.MDP.PageObjects_PF.PostCodePopp_PF;
// import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
//
//// TODO: Auto-generated Javadoc
/// **
// * The Class DropDownTC.
// *
// * @author cheaus
// */
// public class DropDownTC extends SuperClass {
//
// /**
// * Test drop down.
// *
// * @throws Exception
// * the exception
// */
// @Test
// public static void testDropDown() throws Exception {
// try {
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// final DropDown_Pf drpDwn_PF = new DropDown_Pf(driver);
// PostCodePopp_PF postCodePf = new PostCodePopp_PF(driver);
// // getURLFromSpreadsheet();
// // loginToEpiServer();
// driver.get(
// "http://koalaqa.azurewebsites.net/compare/?cars=Mazda2,CX-5");
// loginToEpiServer();
// // getURLFromSpreadsheet();
// // driver.get("http://localhost:3200/vehicles/mazda-3/gallery");
// // driver.get("http://koalaqa.azurewebsites.net/#");
// // driver.get(
// // "http://koala.node.chdigital.com.au/vehicles/mazda-3/gallery");
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// waitImplictly(driver, 40);
// postCodePf.execute_PostCodeUP_Enter("3141");
// // softAssert.assertEquals("xcy", "xcy" );
// drpDwn_PF.selectDrpDown();
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", ""); //
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
//
// }
