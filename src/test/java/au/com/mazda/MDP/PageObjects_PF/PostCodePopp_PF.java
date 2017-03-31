/// *
// *
// */
// package au.com.mazda.MDP.PageObjects_PF;
//
// import java.util.Iterator;
// import java.util.List;
// import java.util.Set;
//
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.CacheLookup;
// import org.openqa.selenium.support.FindBy;
// import org.openqa.selenium.support.How;
// import org.openqa.selenium.support.PageFactory;
//
// import au.com.mazda.MDP.TestCases.SuperClass;
// import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
//
//// TODO: Auto-generated Javadoc
/// **
// * Post Code Popup page factory css selectors for elements and related
// * behaviour.
// *
// * @author Atchuta
// * @version 1.0
// */
// public class PostCodePopp_PF extends SuperClass {
//
// /** The loc postcode icon. */
// @CacheLookup
// @FindBy(how = How.CSS, using = "span[data-test='postcode-selector']")
// public WebElement LOC_POSTCODE_ICON;
//
// /** The loc postcode popup. */
// @FindBy(how = How.CSS, using = "div[data-reactroot data-test='toast-popup']")
// public List<WebElement> LOC_POSTCODE_POPUP;
//
// /** The loc input postcode txt. */
// @FindBy(how = How.XPATH, using = "div[@data-test='input-text']")
// public WebElement LOC_INPUT_POSTCODE_TXT;
//
// /** The loc postcode submit btn. */
// @FindBy(how = How.CSS, using = "div[data-test='button']")
// public WebElement LOC_POSTCODE_SUBMIT_BTN;
//
// // SeleniumActions selAct;
//
// /** The loc postcode close. */
// @FindBy(how = How.CSS, using = "div[data-test='contentpostcode']")
// public WebElement LOC_POSTCODE_CLOSE;
//
// /**
// * Instantiates a new post code popp PF.
// *
// * @param driver
// * the driver
// */
// public PostCodePopp_PF(final WebDriver driver) {
// PageFactory.initElements(driver, this);
// }
//
// /**
// * Execute get cookie post code.
// */
// public void execute_getCookiePostCode() {
//
// try {
// MDP_MyCustomisedLogs
// .info("To test 'Get the cookie for the post code");
// execute_PostCodePopUP("3000");
//
// final Set<org.openqa.selenium.Cookie> cookies = driver.manage()
// .getCookies();
// System.out.println("Size: " + cookies.size());
//
// final Iterator<org.openqa.selenium.Cookie> itr = cookies.iterator();
// while (itr.hasNext()) {
// final org.openqa.selenium.Cookie cookie = itr.next();
// System.out.println(cookie.getName() + "::" + cookie.getPath()
// + "<" + cookie.getDomain() + "> ||" + cookie.getValue() //$NON-NLS-2$
// + "::" + cookie.getExpiry());
// }
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
//
// }
//
// /**
// * Instantiates a new post code popp PF.
// *
// * @param sPostCodeFromExcel
// * the s post code from excel
// */
//
// // ***** main execution start for post code pop up ***** //
// /**
// * Execute post code pop UP.
// *
// * @param sPostCodeFromExcel
// * the s post code from excel
// */
// public void execute_PostCodePopUP(final String sPostCodeFromExcel) {
// try {
//
// // verifies the postcode icon present or not
// isElementPresent(this.LOC_POSTCODE_ICON);
// clickOnElement(this.LOC_POSTCODE_ICON); // clicks on post code
// // icon
// getAllElements(this.LOC_POSTCODE_POPUP, "PostCode Pop Up");
// sendValues(this.LOC_INPUT_POSTCODE_TXT, sPostCodeFromExcel);
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
//
// /**
// * main execution start for post code pop up.
// */
// public void execute_PostCodePopUPPresence() {
//
// try {
// // verifies the postcode icon present or not
// isElementPresent(this.LOC_POSTCODE_ICON);
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
//
// }
//
// }
//
// // post code - pop up - Close button
// /**
// * Execute post code U P close.
// */
// public void execute_PostCodeUP_Close() {
//
// try {
// MDP_MyCustomisedLogs
// .info("To test close button on post code pop up");
//
// clickOnElement(this.LOC_POSTCODE_ICON);
// sendValues(this.LOC_INPUT_POSTCODE_TXT, "3000");
// clickOnElement(this.LOC_POSTCODE_CLOSE);
//
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
//
// }
//
// /**
// * Execute post code U P enter.
// *
// * @param sPostCodeFromExcel
// * executes the post code values from excel
// */
// public void execute_PostCodeUP_Enter(final String sPostCodeFromExcel) {
// try {
//
// System.out.println("Enter post code ");
//
// // clickOnElement(this.LOC_POSTCODE_ICON);
// sendValues(this.LOC_INPUT_POSTCODE_TXT, sPostCodeFromExcel);
// clickOnElement(this.LOC_POSTCODE_SUBMIT_BTN);
// getTextofElement(this.LOC_POSTCODE_ICON);
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
//
// // ***** post code pop up - submit button ****** //
// /**
// * Execute post code U P submit.
// *
// * @param sPostCodeFromExcel
// * the s post code from excel
// */
// public void execute_PostCodeUP_Submit(final String sPostCodeFromExcel) {
// try {
//
// System.out.println("To test submit button on post code pop up");
//
// clickOnElement(this.LOC_POSTCODE_ICON);
// sendValues(this.LOC_INPUT_POSTCODE_TXT, sPostCodeFromExcel);
// clickOnElement(this.LOC_POSTCODE_SUBMIT_BTN);
// getTextofElement(this.LOC_POSTCODE_ICON);
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// }
// }
//
// }
