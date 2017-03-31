/// *
// *
// */
// package au.com.mazda.MDP.TestCases;
//
// import org.testng.annotations.Test;
//
// import au.com.mazda.MDP.PageObjects_PF.GalleryGrid_Pf;
// import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
//
//// TODO: Auto-generated Javadoc
/// **
// * The Class GalleryGrid_Tc.
// *
// * @author cheaus is the user name
// */
// public class GalleryGrid_Tc extends SuperClass {
//
// /**
// * Test verify gallery grid presence.
// *
// * @throws Exception
// * the exception
// */
// @Test(description = "verifying Gallery Grid elements are present or not")
// public static void testVerifyGalleryGridPresence() throws Exception {
// try {
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// final GalleryGrid_Pf gallery_PF = new GalleryGrid_Pf(driver);
// getURLFromSpreadsheet();
// loginToEpiServer();
// driver.get(
// "http://koalaqa.azurewebsites.net/module-library/content-modules/gallery-grid/");
// // getURLFromSpreadsheet();
// // driver.get("http://localhost:3200/vehicles/mazda-3/gallery");
// // driver.get("http://koalaqa.azurewebsites.net/#");
// // driver.get(
// // "http://koala.node.chdigital.com.au/vehicles/mazda-3/gallery");
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// // softAssert.assertEquals("xcy", "xcy" );
// gallery_PF.verifyGalleryInNavPage();
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", ""); //
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
//
// /**
// * Test verify images presence.
// *
// * @throws Exception
// * the exception
// */
// @Test(description = "verifying Gallery Grid images are present or not")
// public static void testVerifyImagesPresence() throws Exception {
// try {
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// final GalleryGrid_Pf gallery_PF = new GalleryGrid_Pf(driver);
// getURLFromSpreadsheet();
// loginToEpiServer();
// // driver.get("http://localhost:3200/vehicles/mazda-3/gallery");
// // driver.get("http://koalaqa.azurewebsites.net/#");
// // driver.get(
// // "http://koala.node.chdigital.com.au/vehicles/mazda-3/gallery");
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// // softAssert.assertEquals("xcy", "xcy" );
// gallery_PF.verifyGalleryImgs();
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", ""); //
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
//
// /**
// * Test verify videos presence.
// *
// * @throws Exception
// * the exception
// */
// @Test(description = "verifying Gallery Grid videos are present or not")
// public static void testVerifyVideosPresence() throws Exception {
// try {
// MDP_MyCustomisedLogs.startTestCase(strTestName);
//
// final GalleryGrid_Pf gallery_PF = new GalleryGrid_Pf(driver);
// getURLFromSpreadsheet();
// loginToEpiServer();
// // driver.get("http://localhost:3200/vehicles/mazda-3/gallery");
// // driver.get("http://koalaqa.azurewebsites.net/#");
// // driver.get(
// // "http://koala.node.chdigital.com.au/vehicles/mazda-3/gallery");
// MDP_MyCustomisedLogs.info("navigated to " + driver.getCurrentUrl());
//
// // softAssert.assertEquals("xcy", "xcy" );
// gallery_PF.verifyGalleryVideos();
// getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
// str_DriverVersion, strTestName, "PASS", ""); //
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
// }
