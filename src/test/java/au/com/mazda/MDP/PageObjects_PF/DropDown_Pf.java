/// **
// *
// */
// package au.com.mazda.MDP.PageObjects_PF;
//
// import java.util.List;
//
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.FindBy;
// import org.openqa.selenium.support.How;
// import org.openqa.selenium.support.PageFactory;
//
// import au.com.mazda.MDP.TestCases.SuperClass;
// import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
//
//// TODO: Auto-generated Javadoc
/// **
// * The Class DropDown_Pf.
// *
// * @author cheaus
// */
// public class DropDown_Pf extends SuperClass {
//
// /** The loc drpdwn. */
// // @FindBy(how = How.CSS, using = "div[class='Select-placeholder']")
// // @FindBy(how = How.CLASS_NAME, using = "Select-input")
// @FindBy(how = How.CSS, using = "div[class='Select-placeholder']")
// public List<WebElement> LOC_DRPDWN;
// // #react-select-15--value > div.Select-placeholder
//
// /** The loc drpdwn listtagname. */
// @FindBy(how = How.TAG_NAME, using = "use")
// public List<WebElement> LOC_DRPDWN_LISTTAGNAME;
//
// /** The loc drpdwn text. */
// @FindBy(how = How.CSS, using = "div[data-test='select']")
// public WebElement LOC_DRPDWN_TEXT;
//
// /**
// * Instantiates a new drop down pf.
// *
// * @param driver
// * the driver
// */
// public DropDown_Pf(final WebDriver driver) {
// PageFactory.initElements(driver, this);
// }
//
// /**
// * Select drp down.
// *
// * @throws Exception
// * the exception
// */
// public void selectDrpDown() throws Exception {
// try {
// getTextofElement(this.LOC_DRPDWN_TEXT);
// getCountofElements(this.LOC_DRPDWN, "Count in drop down");
// getAllElements(this.LOC_DRPDWN, "Elements are");
//
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// throw new Exception(e.toString());
// }
//
// }
//
// }
