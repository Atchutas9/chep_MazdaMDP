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
 * The Class Configurator_PF.
 *
 * @author cheaus
 */
public class Configurator_PF extends SuperClass {

    /** The we list heading build. */
    @FindBy(how = How.CSS, using = "div[data-test='heading']")
    public List<WebElement> WE_LIST_HEADING_BUILD;

    /** The we list select model. */
    @FindBy(how = How.CSS, using = "li[data-test='flex-icon-link']")
    public List<WebElement> WE_LIST_SELECT_MODEL;

    /** The we list menu nav link. */
    @FindBy(how = How.TAG_NAME, using = "a")
    public List<WebElement> WE_LIST_MENU_NAV_LINK;

    /**
     * Instantiates a new configurator PF.
     *
     * @param driver
     *            the driver
     */
    public Configurator_PF(final WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    /**
     * Execute configurator.
     *
     * @throws Exception
     *             the exception
     */
    public void execute_Configurator() throws Exception {

        verifyConfiguratorHeadersPresence();
        verifyModelCarsPresence();
        verifySelectModel();
    }

    /*
     * gets the count of header elements and retireves text
     */

    /**
     * Verify configurator headers presence.
     *
     * @throws Exception
     *             the exception
     */
    public void verifyConfiguratorHeadersPresence() throws Exception {

        final int count = getCountofElements(this.WE_LIST_HEADING_BUILD,
                "Heading in Configurator");
        MDP_MyCustomisedLogs.info(
                "Count of Heading elements in Configurator are : " + count);

        getAllElements(this.WE_LIST_HEADING_BUILD, "Headers in Configurator");

    }

    /**
     * Verify model cars presence.
     *
     * @throws Exception
     *             the exception
     */
    public void verifyModelCarsPresence() throws Exception {

        final int count = getCountofElements(this.WE_LIST_SELECT_MODEL,
                "Heading in Configurator");
        MDP_MyCustomisedLogs.info(
                "Count of Heading elements in Configurator are : " + count);

        getAllElements(this.WE_LIST_SELECT_MODEL, "Model Cars in configurator");

    }

    /**
     * Verify select model.
     *
     * @throws Exception
     *             the exception
     */
    public void verifySelectModel() throws Exception {

        final int count = getCountofElements(this.WE_LIST_SELECT_MODEL,
                "Heading in Configurator");
        MDP_MyCustomisedLogs.info(
                "Count of Heading elements in Configurator are : " + count);

        selectThisElement("Mazda2", this.WE_LIST_SELECT_MODEL);

    }

}
