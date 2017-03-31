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
 * The Class CallToAction_Pf.
 *
 * @author cheaus
 */
public class CallToAction_Pf extends SuperClass {

    /** The loc list cta btn. */
    @FindBy(how = How.CSS, using = "div[data-test='button']")
    public List<WebElement> LOC_LIST_CTA_BTN;

    /**
     * Instantiates a new call to action pf.
     *
     * @param driver
     *            the driver
     */
    public CallToAction_Pf(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Verify cta btn.
     *
     * @throws Exception
     *             the exception
     */
    public void verifyCtaBtn() throws Exception {
        try {
            getCountofElements(this.LOC_LIST_CTA_BTN, "CTA buttons"); //
            getAllElements(this.LOC_LIST_CTA_BTN, "CTA buttons"); //
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(e.toString());
            throw new Exception(e.toString());
        }
    }

}
