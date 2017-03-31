/*
 *
 */
package au.com.mazda.MDP.TestCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import au.com.mazda.MDP.Utility.MDP_Constant;
import au.com.mazda.MDP.Utility.MDP_Excel;
import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

/**
 * The Class SuperClass.
 *
 * @author cheaus
 */
public class SuperClass {

    /** The driver. */
    protected static WebDriver driver;

    /** The str driver browser name. */
    protected static String str_DriverBrowserName;

    /** The str driver OS. */
    protected static String str_DriverOS;

    /** The str driver version. */
    protected static String str_DriverVersion;

    /** The str URL. */
    protected static String strURL;

    /** The caps. */
    protected static DesiredCapabilities caps;

    /** The str test name. */
    protected static String strTestName;

    /** The process. */
    protected static ProcessBuilder process;

    /** The softassert. */
    protected static SoftAssert softassert = new SoftAssert();

    /**
     * After Class.
     */

    // @BeforeTest(alwaysRun = true)
    /**
     * Browser execute.
     *
     * @param browser
     *            browser value is taken from testng.xml
     * @throws Exception
     *             throws exception if any
     */
    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public static void browserExecute(final String browser) throws Exception {
        try {

            // configuring logs
            DOMConfigurator.configure("log4j.xml");

            MDP_MyCustomisedLogs.info("Launching Browser < " + browser + " >");

            // executeScript();
            // executes based on the browser parameter
            if (browser.equalsIgnoreCase("mac - firefox")) {

                startSelGridServer();
                process = new ProcessBuilder(
                        "./Browsers/geckodriverV0.13.0Mac");
                process.start();

                // executeScript();
                caps = DesiredCapabilities.firefox();
                caps.setBrowserName("firefox");
                caps.setPlatform(Platform.MAC);
                caps.setVersion("50");

                System.out.println("Node url before initiation : "
                        + MDP_Constant.S_NODEURL);
                driver = new RemoteWebDriver(new URL(MDP_Constant.S_NODEURL),
                        caps);
                        // caps.setCapability("marionette", true);
                        // caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,
                        // true);
                        // caps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS,
                        // true);
                        // caps.setCapability(CapabilityType., value);
                        // str_DriverBrowserName =
                        // caps.getBrowserName().toLowerCase();
                        // str_DriverOS = caps.getPlatform().toString();
                        // str_DriverVersion = caps.getVersion().toString();

                // driver = new FirefoxDriver(caps);

                // MDP_MyCustomisedLogs.info("New firefox driver instantiated");
                //

            } else if (browser.equalsIgnoreCase("mac - chrome")) {

                // final String SELGRID = MDP_Constant.S_SEL_STANDALONE_JAR;
                // process = new ProcessBuilder("./seleniumstandalonescript.sh",
                //
                // "SELGRID");
                // process.start();

                startSelGridServer();
                caps = DesiredCapabilities.chrome();
                caps.setBrowserName("chrome");
                caps.setPlatform(Platform.MAC);
                caps.setVersion("2.24");
                System.out.println("Node url before initiation : "
                        + MDP_Constant.S_NODEURL);
                driver = new RemoteWebDriver(new URL(MDP_Constant.S_NODEURL),
                        caps);
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                // System.setProperty("webdriver.chrome.driver",
                // System.getProperty("user.dir")
                // + "/Browsers/chromedriver");
                // caps = DesiredCapabilities.chrome();
                //
                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // // driver = new ChromeDriver(caps);
                //
                // MDP_MyCustomisedLogs
                // .info("New Chrome driver instantiated : Browser Name < "
                //
                // + str_DriverBrowserName + " > ; Driver OS < "
                // + str_DriverOS + " > ; Driver Version < "
                // + str_DriverVersion + " >");

            } else if (browser.equalsIgnoreCase("mac - safari")) {
                // System.setProperty("webdriver.safari.driver",
                // System.getProperty("user.dir")
                // + "/Browsers/safaridriver");

                startSelGridServer();
                caps = DesiredCapabilities.safari();
                caps.setBrowserName("safari");
                caps.setPlatform(Platform.MAC);
                caps.setVersion("10");
                System.out.println("Node url before initiation : "
                        + MDP_Constant.S_NODEURL);
                driver = new RemoteWebDriver(new URL(MDP_Constant.S_NODEURL),
                        caps);
                // final SafariOptions options = new SafariOptions();
                // options.setUseCleanSession(true);
                // caps.setCapability(SafariOptions.CAPABILITY, options);
                //
                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                //
                // driver = new SafariDriver(caps);
                // MDP_MyCustomisedLogs.info("New Safari driver instantiated");
                //

            }
            if (browser.equalsIgnoreCase("Windows - firefox")) {

                // for Windows
                // System.setProperty("webdriver.gecko.driver",
                // System.getProperty("user.dir")
                // + "\\Browsers\\geckodriverV0.13.0Win64.exe");
                // caps = DesiredCapabilities.firefox();
                //
                // //caps.setCapability("marionette", true);
                // caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                //
                // driver = new FirefoxDriver(caps);
                //
                // MDP_MyCustomisedLogs.info("New firefox driver instantiated");
                //

                startSelGridServer();
                process = new ProcessBuilder(
                        ".\\Browsers\\geckodriverV0.13.0Win64.exe");
                process.start();
                // executeScript();
                caps = DesiredCapabilities.firefox();
                caps.setBrowserName("firefox");
                caps.setPlatform(Platform.ANY);
                caps.setVersion("50");
                System.out.println("Node url before initiation : "
                        + MDP_Constant.S_NODEURL);
                driver = new RemoteWebDriver(new URL(MDP_Constant.S_NODEURL),
                        caps);

            } else if (browser.equalsIgnoreCase("Windows - chrome")) {

                // for Windows
                // System.setProperty("webdriver.chrome.driver",
                // System.getProperty("user.dir")
                // + "\\Browsers\\chromedriver.exe");
                startSelGridServer();
                caps = DesiredCapabilities.chrome();
                caps.setBrowserName("chrome");
                caps.setPlatform(Platform.ANY);
                caps.setVersion("2.24");

                System.out.println("Node url before initiation : "
                        + MDP_Constant.S_NODEURL);
                driver = new RemoteWebDriver(new URL(MDP_Constant.S_NODEURL),
                        caps);
                        // driver = new ChromeDriver(caps);

                // MDP_MyCustomisedLogs.info("New Chrome driver instantiated");
                //

            } else if (browser.equalsIgnoreCase("Windows - IE11")) {

                // String IEPath = System.getProperty("user.dir");
                // String STRIEPath = IEPath + "\\Browsers\\";
                // System.out.println("IEPath: " + IEPath);
                // System.out.println("STRIEPath : " + STRIEPath);
                // Runtime rt = Runtime.getRuntime();
                // rt.exec("cmd.exe /c cd \""+STRIEPath+"\" & start cmd.exe /k
                // \"java -jar selenium-server-standalone-3.0.0-beta2.jar -role
                // webdriver -nodeConfig BrowserCapabilities.json");

                // System.setProperty("webdriver.ie.driver",
                // System.getProperty("user.dir")
                // + "\\Browsers\\IEDriverServer.exe");
                // driver = new EdgeDriver();

                process = new ProcessBuilder(
                        ".\\Browsers\\MicrosoftWebDriver.exe");
                process.start();

                startSelGridServer();
                caps = DesiredCapabilities.internetExplorer();
                caps.setBrowserName("internet explorer");
                caps.setPlatform(Platform.ANY);
                caps.setVersion("11");
                System.out.println("Node url before initiation : "
                        + MDP_Constant.S_NODEURL);
                driver = new RemoteWebDriver(new URL(MDP_Constant.S_NODEURL),
                        caps);
                // caps =DesiredCapabilities.internetExplorer();
                // caps.setBrowserName("internet explorer");
                //
                // driver = new RemoteWebDriver(new
                // URL(MDP_Constant.str_NodeURL), caps);
            } else
                if (browser.equalsIgnoreCase("browser-stack-Apple iPhone 5s")) {

                caps = DesiredCapabilities.iphone();

                caps.setCapability("browserName", "iPhone");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPhone 5S");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                        caps);

                MDP_MyCustomisedLogs.info(
                        "New browser-stack-Apple iPhone 5s driver instantiated");

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  iPhone  6  Plus")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPhone");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPhone  6  Plus");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPhone 6 Plus driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  iPhone  6s")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPhone");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPhone  6S");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPhone 6s driver instantiated");
                //

            } else if (browser.equalsIgnoreCase(
                    "browser-stack-Apple  iPhone  6s  Plus")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPhone");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPhone  6S  Plus");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPhone 6s Plus driver
                // instantiated");

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  iPhone  6")) {

                caps.setCapability("browserName", "iPhone");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPhone  6");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPhone 6 driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Samsung  Galaxy  S5")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "android");
                caps.setCapability("platform", "ANDROID");
                caps.setCapability("device", "Samsung  Galaxy  S5");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Samsung Galaxy S5 driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Google  Nexus  5")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "android");
                caps.setCapability("platform", "ANDROID");
                caps.setCapability("device", "Google  Nexus  5");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Google Nexus 5 driver instantiated");
                //

            } else if (browser.equalsIgnoreCase("browser-stack-Samsung  S4")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "android");
                caps.setCapability("platform", "ANDROID");
                caps.setCapability("device", "Samsung  Galaxy  S4");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Samsung S4 driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  iPad  Mini  4")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPad");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPad  Mini  4");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPad Mini 4 driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  iPad  Mini")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPad");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPad  Mini");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPad Mini driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  ipad  Air")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPad");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPad  Air");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple ipad Air driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Google  Nexus  7")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "android");
                caps.setCapability("platform", "ANDROID");
                caps.setCapability("device", "Google  Nexus  7");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Google Nexus 7 driver instantiated");
                //

            } else if (browser.equalsIgnoreCase(
                    "browser-stack-Samsung  Galaxy  Tab  4  10.1")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "android");
                caps.setCapability("platform", "ANDROID");
                caps.setCapability("device", "Samsung  Galaxy  Tab  4  10.1");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Samsung Galaxy Tab 4 10.1 driver
                // instantiated");

            } else if (browser.equalsIgnoreCase(
                    "browser-stack-Samsung  Galaxy  Note  10.1")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "android");
                caps.setCapability("platform", "ANDROID");
                caps.setCapability("device", "Samsung  Galaxy  Note  10.1");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Samsung Galaxy Note 10.1 driver
                // instantiated");

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  iPad  Pro")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPad");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPad  Pro");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPad Pro driver instantiated");
                //

            } else if (browser
                    .equalsIgnoreCase("browser-stack-Apple  iPad  Mini  2")) {

                caps = new DesiredCapabilities();
                caps.setCapability("browserName", "iPad");
                caps.setCapability("platform", "MAC");
                caps.setCapability("device", "iPad  Mini  2");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(new URL(MDP_Constant.S_BS_URL),
                // caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "New browser-stack-Apple iPad Mini 2 driver instantiated");
                //

            } else if (browser.equalsIgnoreCase("selenium-grid-win10-IE11")) {

                caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("browser", "IE");
                caps.setCapability("browser_version", "11.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(
                // new URL(MDP_Constant.S_SELENIUM_GRID_LOCALHOST), caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "selenium-grid-win10-IE11 driver instantiated via browser
                // stack");

            } else if (browser.equalsIgnoreCase("selenium-grid-win10-MSEdge")) {

                caps = DesiredCapabilities.edge();

                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "13.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");

                // str_DriverBrowserName = caps.getBrowserName().toLowerCase();
                // str_DriverOS = caps.getPlatform().toString();
                // str_DriverVersion = caps.getVersion().toString();
                // driver = new RemoteWebDriver(
                // new URL(MDP_Constant.S_SELENIUM_GRID_LOCALHOST), caps);
                //
                // MDP_MyCustomisedLogs.info(
                // "selenium-grid-win10-MSEdge driver instantiated via browser
                // stack");

            }

            MDP_MyCustomisedLogs.info("New ** " + browser.toUpperCase()
                    + "**  driver instanstiated. " + "Browser Name is : < "
                    + caps.getBrowserName().toLowerCase()
                    + " >,  Driver OS is : < " + caps.getPlatform().toString()
                    + " >, Driver Version is : <" + caps.getVersion().toString()
                    + " >");
        } catch (final Exception e) {

            MDP_MyCustomisedLogs.error(e.toString());
            throw new Exception(e.toString());

        }

    }

    // click on an element
    /**
     * Click on element.
     *
     * @param element
     *            the element
     * @throws Exception
     *             the exception
     */
    public static void clickOnElement(final WebElement element)
            throws Exception {
        try {
            waitExplicit(element);

            element.click();
            softassert.assertNotNull(element);
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error("Unable to click on the element < "
                    + element.getText() + " > " + e.toString());
            throw new Exception(e.toString());

        }

    }

    /**
     * Execute script.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public static void startSelGridServer() throws IOException {

        // final String SELGRID[] = new String[1];
        // SELGRID[0] = MDP_Constant.S_PATHSERVER;
        // SELGRID[1] = MDP_Constant
        // SELGRID[1] = MDP_Constant.S_SEL_STANDALONE_JAR;
        // final String SELGRID = MDP_Constant.S_PATHSERVER;
        // process = new ProcessBuilder(".seleniumstandalonescript.sh",
        // SELGRID);

        // final String SELGRID = MDP_Constant.S_PATHSERVER;
        final String SELGRID = MDP_Constant.S_SEL_STANDALONE_JAR;
        process = new ProcessBuilder("./seleniumstandalonescript.sh",
                "cd Browsers", SELGRID);
                // process = new ProcessBuilder(SELGRID);

        // final Process p = Runtime.getRuntime().exec(SELGRID);
        process.start();

    }

    /**
     * @throws IOException
     */
    public static void stopSelGrid() throws IOException {

        final String SELGRIDSTOP = MDP_Constant.S_SEL_EXIT_SELGRID_PROCESS;
        process = new ProcessBuilder("./seleniumstandalonescript.sh",
                "cd Browsers", SELGRIDSTOP);
                // process = new ProcessBuilder(SELGRID);

        // final Process p = Runtime.getRuntime().exec(SELGRID);
        process.start();

    }

    // retrieve all the elements present in the webelements
    /**
     * Gets the all elements.
     *
     * @param elements
     *            the elements
     * @param str
     *            the str
     * @return the all elements
     * @throws Exception
     *             the exception
     */
    @SuppressWarnings("javadoc")
    public static String getAllElements(final List<WebElement> elements,
            final String str) throws Exception {
        final String sEleText = null;
        try {

            // for (WebElement ele : elements) {
            for (int i = 0; i < elements.size(); i++) {
                // waitExplicit(ele);
                if (elements.get(i) != null) {
                    waitExplicit(elements.get(i));
                    // softassert.assertNotNull(ele.getText());
                    softassert.assertNotNull(elements.get(i).getText());
                    MDP_MyCustomisedLogs.info("Elements in " + str + " are: "
                            + elements.get(i).getText());
                }

            }

        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(
                    sEleText + "is not present in the Menu navigation link "
                            + e.toString());
            throw new Exception(
                    sEleText + "is not present in the Menu navigation link "
                            + e.toString());

        }
        return null;
    }

    // get the count of elements for a particular string
    /**
     * Gets the countof elements.
     *
     * @param elements
     *            the elements
     * @param string
     *            the string
     * @return the countof elements
     * @throws Exception
     *             the exception
     */
    public static int getCountofElements(final List<WebElement> elements,
            final String string) throws Exception {
        boolean countBool = false;
        try {

            int countElements = elements.size();
            if (countElements >= 1) {
                countBool = true;
                MDP_MyCustomisedLogs.info(
                        "Count in  <  " + string + " > is " + elements.size());
                softassert.assertTrue(countBool, "Test passed");
                return elements.size();
            }

        } catch (final Exception e) {
            softassert.assertTrue(countBool, "Test Failed");
            MDP_MyCustomisedLogs.error(e.toString());
            throw new Exception(e.toString());
        }
        softassert.assertTrue(countBool, "Test Failed");
        return 0;

    }

    // public SoftAssert softAssert = new SoftAssert();

    /**
     * Gets the screenshot.
     *
     * @param dr
     *            the dr
     * @param strDriverBrowserName
     *            the str driver browser name
     * @param strDriverOS
     *            the str driver OS
     * @param strDriverVersion
     *            the str driver version
     * @param sTestCaseID
     *            the s test case ID
     * @param sResult
     *            the s result
     * @param sLinkText
     *            the s link text
     * @throws Exception
     *             the exception
     */

    public static void getScreenshot(final WebDriver dr,
            final String strDriverBrowserName, final String strDriverOS,
            final String strDriverVersion, final String sTestCaseID,
            final String sResult, final String sLinkText) throws Exception {

        try {

            final DateFormat dateFormat = new SimpleDateFormat(
                    "MMM/dd/yyyy_hh:mm");
            final Date date = new Date();
            final String sdate = dateFormat.format(date);
            final File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile,
                    new File(MDP_Constant.S_SCREENSHOT_PATH + sTestCaseID + "_"
                            + sLinkText + "_" + sResult + "_" + sdate
                            + ".png"));

        } catch (final Exception e) {

            MDP_MyCustomisedLogs
                    .error("Class : SuperClass || Method: getScreenshot || Desciption: "
                            + e.toString());
            throw new Exception(e.toString());

        }

    }

    // retrieves the text of the element
    /**
     * Gets the textof element.
     *
     * @param element
     *            the element
     * @return the textof element
     * @throws Exception
     *             the exception
     */
    @SuppressWarnings("javadoc")
    public static String getTextofElement(final WebElement element)
            throws Exception {
        try {
            waitExplicit(element);
            MDP_MyCustomisedLogs
                    .info(element.getText() + "is present in the webpage");
            softassert.assertNotNull(element.getText());
            return element.getText();
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(element.getText()
                    + "is not present in the webpage" + e.toString());
            throw new Exception(element.getText()
                    + "is not present in the webpage" + e.toString());
        }

    }

    /**
     * Gets the URL from spreadsheet.
     *
     * @throws Exception
     *             the exception
     */
    public static void getURLFromSpreadsheet() throws Exception {
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

                    strURL = MDP_Excel.getCellValue(
                            MDP_Constant.S_EXCEL_FILE_PATH,
                            MDP_Constant.S_SHEET_TEST_CASES, i,
                            MDP_Constant.I_COL_URL);

                    driver.manage().window().maximize();
                    waitImplictly(driver, 60);
                    driver.get(strURL);
                    loginToEpiServer();

                    waitImplictly(driver, 60);
                    softassert.assertEquals(driver.getCurrentUrl(), strURL);
                    if (driver.getCurrentUrl().equals(strURL)) {
                        MDP_MyCustomisedLogs.info("navigated to " + strURL);
                    }

                } else if (strRunMode.equalsIgnoreCase("n")
                        || strRunMode.equalsIgnoreCase("no")) {

                    MDP_MyCustomisedLogs.skipTestCase(strTestCaseID,
                            strRunMode);

                    continue;

                }
                final String browserName = caps.getBrowserName();
                final String os = caps.getPlatform().toString();
                final String ver = caps.getVersion().toString();

                System.out.println(" browserName :: " + browserName
                        + "  :: os :: " + os + " :: ver ::" + ver);

            }
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(e.toString());
            throw new Exception(e.toString());
        }

    }

    /**
     * Gets the URL koala.
     *
     * @throws Exception
     *             the exception
     */
    // public static void getURLKoala() throws Exception {
    // try {
    // driver.get(strURL);
    // softassert.assertEquals(driver.getCurrentUrl(), strURL);
    // loginToEpiServer();
    // } catch (final Exception e) {
    // MDP_MyCustomisedLogs.error(e.toString());
    // throw new Exception(e.toString());
    // }
    //
    // }

    /**
     * Checks if is element present.
     *
     * @throws Exception
     *             the exception
     */
    // public static void isElementPresent(final WebElement element)
    // throws Exception {
    // try {
    // waitExplicit(element);
    // if (element.isDisplayed()) {
    // softassert.assertTrue(element.isDisplayed(), element.getText()
    // + " Element is present in the webpage");
    // MDP_MyCustomisedLogs
    // .info(element.getText() + "is present in the webpage");
    // softassert.assertNotNull(element.getText(), "Test Passed");
    //
    // }
    // } catch (final Exception e) {
    // softassert.assertFalse(element.isDisplayed(),
    // element.getText() + " Test Failed");
    // MDP_MyCustomisedLogs.error(element.getText()
    // + "is not present in the webpage" + e.toString());
    // throw new Exception(element.getText()
    // + "is not present in the webpage" + e.toString());
    // }
    // softassert.assertAll();
    // }

    /**
     * Login to epi server.
     *
     * @throws Exception
     *             the exception
     */
    protected static void loginToEpiServer() throws Exception {
        try {
            waitExplicit(driver.findElement(By.id("LoginControl_UserName")));

            driver.findElement(By.id("LoginControl_UserName")).clear();
            // driver.findElement(By.id("LoginControl_UserName"))
            // .sendKeys("atchuta.saragadam");
            driver.findElement(By.id("LoginControl_UserName"))
                    .sendKeys("che-testers");

            waitExplicit(driver.findElement(By.id("LoginControl_Password")));
            driver.findElement(By.id("LoginControl_Password")).clear();
            // driver.findElement(By.id("LoginControl_Password"))
            // .sendKeys("June2016");
            driver.findElement(By.id("LoginControl_Password"))
                    .sendKeys("U496o13%JX");

            final WebElement loginBtn = driver
                    .findElement(By.id("LoginControl_Button1"));
            waitExplicit(loginBtn);
            final JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginBtn);
            waitImplictly(driver, 70);
            softassert.assertNotEquals(strURL, driver.getCurrentUrl(),
                    "Successfully logged in to the Episerver URL  "
                            + driver.getCurrentUrl());
            MDP_MyCustomisedLogs
                    .info("Successfully logged in to the Episerver URL "
                            + driver.getCurrentUrl());
            softassert.assertAll();

        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(
                    "unable to login to Episerver koalaqa" + e.toString());
            throw new Exception(
                    "unable to login to Episerver koalaqa" + e.toString());
        }
    }

    /**
     * Select this element.
     *
     * @param string
     *            the string
     * @param elements
     *            the elements
     * @throws Exception
     *             the exception
     */
    public static void selectThisElement(final String string,
            final List<WebElement> elements) throws Exception {
        try {

            for (final WebElement ele : elements) {
                waitExplicit(ele);
                final String str = string.toLowerCase();
                if (str.equalsIgnoreCase(ele.getText())) {
                    ele.click();
                }
            }
        } catch (final Exception e) {
            MDP_MyCustomisedLogs
                    .error(string + "is not present" + e.toString());
            throw new Exception(string + "is not present" + e.toString());
        }

    }

    // send input values to text field
    /**
     * Send values.
     *
     * @param element
     *            the element
     * @param sendText
     *            the send text
     * @throws Exception
     *             the exception
     */
    public static void sendValues(final WebElement element,
            final String sendText) throws Exception {
        try {
            waitExplicit(element);
            element.clear();
            element.sendKeys(sendText);
            MDP_MyCustomisedLogs.info("Value entered in inputfield < "
                    + element.getText() + "> is < " + sendText + " > ");
            softassert.assertNotNull(element.getText());
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error("unable to enter text < " + sendText
                    + " > in the element < " + element.getText() + " > "
                    + e.toString());
            throw new Exception("unable to enter text < " + sendText
                    + " > in the element < " + element.getText() + " > "
                    + e.toString());
        }

    }

    /**
     * Start method.
     *
     * @param method
     *            the method
     */
    @BeforeMethod(alwaysRun = true)
    protected static void startMethod(final Method method) {
        try {
            strTestName = method.getName();
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(e.toString());
        }
    }

    /**
     * Wait explicit.
     *
     * @param element
     *            the element
     * @return the web element
     * @throws Exception
     *             the exception
     */
    @SuppressWarnings("javadoc")
    public static WebElement waitExplicit(final WebElement element)
            throws Exception {
        try {

            final WebElement waitElement = new WebDriverWait(driver, 100)
                    .until(ExpectedConditions.visibilityOf(element));
            return waitElement;

        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error("Element not found " + e.toString());
            throw new Exception("Element not found " + e.toString());
        }

    }

    /**
     * Wait implictly.
     *
     * @param dr
     *            the dr
     * @param timeInSecs
     *            time in secs
     * @throws Exception
     *             the exception
     */
    public static void waitImplictly(final WebDriver dr, int timeInSecs)
            throws Exception {
        try {
            dr.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(e.toString());
            throw new Exception(e.toString());
        }

    }

    /**
     * Clear field value.
     *
     * @param element
     *            the element
     * @param str
     *            the str
     * @throws Exception
     *             the exception
     */
    public static void clearFieldValue(WebElement element, String str)
            throws Exception {
        String sEleText = "";
        try {
            // waitExplicit(element);

            element.clear();

            MDP_MyCustomisedLogs.info("cleared " + str);
            // getScreenshot(getBrowserDetails(caps), strTestName, "Pass", str);
            // final WebDriver dr,
            // final String strDriverBrowserName, final String strDriverOS,
            // final String strDriverVersion, final String sTestCaseID,
            // final String sResult, final String sLinkText

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(sEleText
                    + "is not present in the Stepcounter " + e.toString());
            throw new Exception(sEleText + "is not present in the Stepcounter"
                    + e.toString());
        }
    }

    /**
     * Gets the stepcounter elements.
     *
     * @param elements
     *            the elements
     * @param str
     *            the str
     * @throws Exception
     *             the exception
     */
    public static void getStepcounterElements(List<WebElement> elements,
            String str) throws Exception {
        SoftAssert sa = new SoftAssert();
        String sEleText = "";
        try {
            for (WebElement ele : elements) {
                waitExplicit(ele);
                if (ele.getText() != null)

                {
                    String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent"
                            + "('MouseEvents');evObj.initEvent('mouseover', true, false); "
                            + "arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) "
                            + "{ arguments[0].fireEvent('onmouseover');}";
                    ((JavascriptExecutor) driver).executeScript(mouseOverScript,
                            ele);
                    Actions action = new Actions(driver);
                    action.moveToElement(ele).clickAndHold().perform();
                    Thread.sleep(2000);
                    WebElement we = ele.findElement(By.tagName("span"));
                    sEleText = we.getText();
                    sa.assertTrue(we.getText().length() > 1);
                }

                MDP_MyCustomisedLogs
                        .info("Elements in Tooltip" + str + "are: " + sEleText);
                getScreenshot(getBrowserDetails(caps), strTestName, "Pass",
                        sEleText);

            }

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(sEleText
                    + "is not present in the Stepcounter " + e.toString());
            throw new Exception(sEleText + "is not present in the Stepcounter "
                    + e.toString());

        }
        // return null;
        // sa.assertAll();
    }

    /**
     * Gets the browser details.
     *
     * @param dCaps
     *            the caps
     * @return the browser details
     * @throws Exception
     *             the exception
     */
    public static String getBrowserDetails(DesiredCapabilities dCaps)
            throws Exception {
        try {

            str_DriverBrowserName = dCaps.getBrowserName().toLowerCase();
            str_DriverOS = dCaps.getPlatform().toString();
            str_DriverVersion = dCaps.getVersion().toString();

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(e.toString());
            throw new Exception(e.toString());
        }
        return str_DriverBrowserName + "_" + str_DriverOS + "_"
                + str_DriverVersion;
    }

    /**
     * Gets the screenshot.
     *
     * @param sCaps
     *            the s caps
     * @param sTestCaseID
     *            the s test case ID
     * @param sResult
     *            the s result
     * @param sLinkText
     *            the s link text
     * @throws Exception
     *             the exception
     */
    public static void getScreenshot(String sCaps, String sTestCaseID,
            String sResult, String sLinkText) throws Exception {

        try {

            DateFormat dateFormat = new SimpleDateFormat("MMM/dd/yyyy_hh:mm");
            Date date = new Date();
            String sdate = dateFormat.format(date);
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile,
                    new File(MDP_Constant.S_SCREENSHOT_PATH + "_" + sCaps + "_"
                            + sTestCaseID + "_" + sLinkText + "_" + sResult
                            + "_" + sdate + ".png"));

        } catch (Exception e) {

            MDP_MyCustomisedLogs
                    .error("Class : SuperClass || Method: getScreenshot || Desciption: "
                            + e.toString());
            throw new Exception(e.toString());

        }

    }

    /**
     * Gets the all cta buttons.
     *
     * @param elements
     *            the elements
     * @param str
     *            the str
     * @throws Exception
     *             the exception
     */
    public static void getAllCtaButtons(List<WebElement> elements, String str)
            throws Exception {
        SoftAssert sa = new SoftAssert();
        String sEleText = "";
        try {

            for (WebElement ele : elements) {

                waitExplicit(ele);
                if (ele.getText() != null || ele.isEnabled()) {
                    sEleText = ele.getText();
                    sa.assertTrue(ele.getText().length() > 0);
                    MDP_MyCustomisedLogs.info("Elements in " + str + "are: "
                            + sEleText + " is present on page");
                    getScreenshot(getBrowserDetails(caps), strTestName, "Pass",
                            sEleText);

                }

            }

        } catch (Exception e) {
            sa.assertNull(e);
            MDP_MyCustomisedLogs.error(
                    sEleText + "is not present in the page " + e.toString());
            throw new Exception(
                    sEleText + "is not present in the page " + e.toString());

        }
        // return null;
        // sa.assertAll();
    }

    /**
     * Gets the tooltip element.
     *
     * @param ele
     *            the ele
     * @param str
     *            the str
     * @throws Exception
     *             the exception
     */
    public static void getTooltipElement(WebElement ele, String str)
            throws Exception {
        String sEleText = "";
        try {

            waitExplicit(ele);
            if (ele.getText() != null) {

                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript,
                        ele);
                // Actions action = new Actions(driver);
                // action.moveToElement(ele);
                // action.perform();
                // WebElement we = ele.findElement(By.tagName("span"));

                ele.getText();
            }

            MDP_MyCustomisedLogs.info("Elements in Tooltip are: " + sEleText);
            getScreenshot(getBrowserDetails(caps), strTestName, "Pass",
                    sEleText);

            // }

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(sEleText
                    + "is not present in the Stepcounter " + e.toString());
            throw new Exception(sEleText + "is not present in the Stepcounter "
                    + e.toString());

        }
        // return null;
    }

    /**
     * Gets the image.
     *
     * @param elements
     *            the elements
     * @param str
     *            the str
     * @throws Exception
     *             the exception
     */
    @SuppressWarnings("unused")
    public static void getImage(List<WebElement> elements, String str)
            throws Exception {
        SoftAssert sa = new SoftAssert();
        try {

            for (WebElement ele : elements) {
                waitExplicit(ele);
                if (ele.getText() != null) {
                    // sEleText = ele.getText();
                }
                WebElement img = ele.findElement(By.tagName("img"));
                Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript(
                                "return arguments[0].complete && typeof arguments[0].naturalWidth"
                                        + " != \"undefined\" && arguments[0].naturalWidth > 0",
                                img);
                if (!imageLoaded) {
                    sa.assertNull(imageLoaded);
                    MDP_MyCustomisedLogs.error("Image is Not Present");
                } else {
                    sa.assertNotNull(imageLoaded);
                    MDP_MyCustomisedLogs.error("Image is  Present");
                }
            }
        } catch (Exception e) {
            MDP_MyCustomisedLogs.error("Image  Not Present" + e.toString());
            throw new Exception("Image  Not Present" + e.toString());

        }
        sa.assertAll();
    }

    /**
     * Gets the all images.
     *
     * @param elements
     *            the elements
     * @param str
     *            the str
     * @throws Exception
     *             the exception
     */
    public static void getAllImages(List<WebElement> elements, String str)
            throws Exception {
        SoftAssert sa = new SoftAssert();
        String sEleText = "";
        try {

            for (WebElement ele : elements) {
                waitExplicit(ele);
                if (ele.getText() != null) {
                    sEleText = ele.getText();
                    sa.assertNotNull(ele);
                }
                WebElement img = ele.findElement(By.tagName("img"));
                Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript(
                                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                                img);
                if (!imageLoaded) {
                    sa.assertNull(imageLoaded);
                    MDP_MyCustomisedLogs.error("Image is Not Present");
                } else {
                    sa.assertNotNull(imageLoaded);
                    MDP_MyCustomisedLogs
                            .error("Image for: " + str + ": is  Present");
                }
            }

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error("Image for :  " + sEleText
                    + "  : Not Present" + e.toString());
            throw new Exception("Image for :  " + sEleText + "  : Not Present"
                    + e.toString());

        }
        sa.assertAll();
    }

    /**
     * Mouse hover element.
     *
     * @param element
     *            the element
     * @param str
     *            the str
     * @throws Exception
     *             the exception
     */
    public static void mouseHoverElement(WebElement element, String str)
            throws Exception {
        String sEleText = "";
        try {
            waitExplicit(element);
            if (isElementPresent(element)) {

                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript,
                        element);

                WebElement we = element.findElement(By.tagName("svg"));
                Actions action = new Actions(driver);
                action.moveToElement(we);
                action.perform();

            }

            MDP_MyCustomisedLogs.info("mouse hovered " + str);
            getScreenshot(getBrowserDetails(caps), strTestName, "Pass", str);

        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(sEleText
                    + "is not present in the Stepcounter " + e.toString());
            throw new Exception(sEleText + "is not present in the Stepcounter "
                    + e.toString());
        }
    }

    /**
     * Checks if is element present.
     *
     * @param element
     *            the element
     * @return true, if is element present
     * @throws Exception
     *             the exception
     */
    public static boolean isElementPresent(WebElement element)
            throws Exception {
        boolean elementPresent = false;
        try {
            waitExplicit(element);
            if (element.getText().length() > 2) {
                elementPresent = true;
                MDP_MyCustomisedLogs.info(
                        element.isDisplayed() + "  :is present in the webpage");

            }
        } catch (Exception e) {
            MDP_MyCustomisedLogs.error(element.getText()
                    + "is not present in the webpage" + e.toString());
            throw new Exception(element.getText()
                    + "is not present in the webpage" + e.toString());
        }
        return elementPresent;

    }

    @AfterClass(alwaysRun = true)
    public static void afterClass() {
        try {

            waitImplictly(driver, 60);
            stopSelGrid();
            driver.get(
                    "http://0.0.0.0:4444/selenium-server/driver/?cmd=shutDownSeleniumServer");
            driver.quit();
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(e.toString());
        }
    }
}
