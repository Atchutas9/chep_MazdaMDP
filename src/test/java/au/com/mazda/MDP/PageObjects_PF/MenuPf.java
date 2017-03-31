/*
 *
 */
package au.com.mazda.MDP.PageObjects_PF;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import au.com.mazda.MDP.TestCases.SuperClass;
import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuPf.
 *
 * @author cheaus - this class contain page factory elements for menu
 */
public class MenuPf extends SuperClass {

    // element locator for all headers
    /** The loc list menu navlink. */
    // @FindBy(how = How.CSS, using = "a[data-test='nav-link']")
    @FindBy(how = How.XPATH, using = "//a[@data-test='nav-link']")
    // @FindBy(how = How.XPATH, using = "nav[@data-test='global-nav']")
    private List<WebElement> LOC_LIST_MENU_NAVLINK;

    /**
     * Instantiates a new menu pf.
     *
     * @param driver
     *            the driver
     */
    public MenuPf(final WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    /**
     * main method for this class and also the test steps are mentioned here.
     */
    public void executeMenu() {
        try {

            getAllElements(this.LOC_LIST_MENU_NAVLINK, strTestName);

        } catch (final Exception e) {

            MDP_MyCustomisedLogs.error(e.toString());

        }

    }

    // retrieves all the menu link in header or navigation link
    // private void getMenu(List<WebElement> we_list_Menu2) {
    // String sEleText = null;
    // try {
    // for (WebElement ele : we_list_Menu2) {
    // sEleText = ele.getText();
    // System.out.println("Menu Navigation List: " + sEleText);
    // }
    // } catch (Exception e) {
    //
    // MDP_MyCustomisedLogs.error(
    // sEleText + "is not present in the Menu navigation link "
    // + e.toString());
    // }
    //
    // }

}
