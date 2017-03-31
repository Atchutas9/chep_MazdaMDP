package au.com.mazda.MDP.configurator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import au.com.mazda.MDP.TestCases.SuperClass;

// TODO: Auto-generated Javadoc
/**
 * The Class Configurator_PF.
 *
 * @author cheaus
 */
public class Configurator_PF extends SuperClass {

    /**
     * Instantiates a new configurator PF.
     *
     * @param driver
     *            passes the driver parameter
     */
    public Configurator_PF(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    /** The we list postcodepopup. */
    @FindBy(how = How.CSS, using = "div[data-test='toast-popup']")
    public static WebElement WE_LIST_POSTCODEPOPUP;

    /** The we postcodeinput. */
    @FindBy(how = How.CSS, using = "div[data-test='input-postcode']")
    public static WebElement WE_POSTCODEINPUT;

    /** The we postcodesubmit. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='button']/submit")
    public static WebElement WE_POSTCODESUBMIT;

    /** The we list postcodeclose. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='toast-popup']//div[@data-test='toast-close']")
    public static WebElement WE_LIST_POSTCODECLOSE;

    /** The postcode. */
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    public WebElement POSTCODE;

    /** The loc list menu navlink. */
    @FindBy(how = How.CSS, using = "a[data-test='nav-link']")
    public static List<WebElement> LOC_LIST_MENU_NAVLINK;

    /** The loc list menu buyingguide. */
    @FindBy(how = How.XPATH, using = "//li[@data-test='flex-icon-link']/a/div[1]/span[1]")
    public static List<WebElement> LOC_LIST_MENU_BUYINGGUIDE;

    /** The we list heading build. */
    @FindBy(how = How.CSS, using = "div[data-test='heading']")
    public static List<WebElement> WE_LIST_HEADING_BUILD;

    /** The we subheading build. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='heading']/h1")
    public static WebElement WE_SUBHEADING_BUILD;

    /** The we list model. */
    // @FindBy(how = How.CSS, using = "div[data-test='flex-nav-link']")
    @FindBy(how = How.XPATH, using = "//main[@class='main-content']//li[@data-test='flex-icon-link']")
    public static List<WebElement> WE_LIST_MODEL;

    /** The we select model. */
    @FindBy(how = How.XPATH, using = "//main[@class='main-content']//li[@data-test='flex-icon-link']/a/div[1]/span[1]")
    public static List<WebElement> WE_SELECT_MODEL;

    /** The we list bodytype. */
    @FindBy(how = How.CSS, using = "div[data-test='text-toggle']")
    public static List<WebElement> WE_LIST_BODYTYPE;

    /** The we description. */
    @FindBy(how = How.CSS, using = "p[data-test='description']")
    public static List<WebElement> WE_DESCRIPTION;

    /** The we list drivetraintype. */
    @FindBy(how = How.CSS, using = "div[data-test='text-toggle']")
    public static List<WebElement> WE_LIST_DRIVETRAINTYPE;

    /** The we get image. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='image-selector']")
    public static List<WebElement> WE_GET_IMAGE;

    /** The we get image1. */
    @FindBy(how = How.XPATH, using = "//img[@data-test='active-vehicle']")
    public static List<WebElement> WE_GET_IMAGE1;

    /** The we list stepcounter. */
    @FindBy(how = How.XPATH, using = "//ol[@data-test='StepCounter']/li")
    public static List<WebElement> WE_LIST_STEPCOUNTER;

    /** The we list stickyfooter. */
    @FindBy(how = How.CSS, using = "div[data-test='fixed-bar']")
    public static List<WebElement> WE_LIST_STICKYFOOTER;

    /** The we list buttons. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='button']/button")
    public static List<WebElement> WE_LIST_BUTTONS;

    /** The we list gradetype. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='grades']//div[@data-test='text-toggle']")
    public static List<WebElement> WE_LIST_GRADETYPE;

    /** The we list gradetransmissions. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='transmissions']//div[@data-test='text-toggle']")
    public static List<WebElement> WE_LIST_GRADETRANSMISSIONS;

    /** The we list gradeengines. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='engines']//div[@data-test='text-toggle']")
    public static List<WebElement> WE_LIST_GRADEENGINES;

    /** The we list gradehighlights. */
    @FindBy(how = How.XPATH, using = "//ul[@data-test='stat-list']")
    public static WebElement WE_LIST_GRADEHIGHLIGHTS;

    /** The we list gradefeaturespecs. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='accordion']")
    public static WebElement WE_LIST_GRADEFEATURESPECS;

    /** The we list featurespecs. */
    @FindBy(how = How.CSS, using = "div:nth-child(4) > div > div:nth-child(1) > span")
    public static WebElement WE_LIST_FEATURESPECS;

    /** The we list colourbuttons. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='bubble']")
    public List<WebElement> WE_LIST_COLOURBUTTONS;

    /** The we list exteriortooltip. */
    @FindBy(how = How.XPATH, using = "//span[@data-test='bubble-span']")
    public List<WebElement> WE_LIST_EXTERIORTOOLTIP;

    /** The we list swatchimages. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='bubble']")
    public static List<WebElement> WE_LIST_SWATCHIMAGES;

    /** The we list interiortooltip. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='swatch-icon']//span[@data-test='bubble-span']")
    public static List<WebElement> WE_LIST_INTERIORTOOLTIP;

    /** The we image. */
    @FindBy(how = How.XPATH, using = "//img[@data-test='active-vehicle']")
    public static WebElement WE_IMAGE;

    /** The we list summary. */
    @FindBy(how = How.XPATH, using = "//div[@data-test='summary-item']")
    public static List<WebElement> WE_LIST_SUMMARY;

    /** The we list menu nav link. */
    @FindBy(how = How.TAG_NAME, using = "a")
    public static List<WebElement> WE_LIST_MENU_NAV_LINK;
}
