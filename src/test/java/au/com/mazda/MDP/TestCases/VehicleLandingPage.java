/*
 *
 */
package au.com.mazda.MDP.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleLandingPage.
 *
 * @author cheaus
 */
public class VehicleLandingPage {

    /** The dri. */
    public static WebDriver dri;

    /**
     * Gets the sub menu items.
     *
     * @return the sub menu items
     * @throws InterruptedException
     *             the interrupted exception
     */
    @SuppressWarnings("unused")
    private static void getSubMenuItems() throws InterruptedException {

        // List<WebElement> radiobutton =
        // driver1.findElements(By.cssSelector("label[data-test='radio-group-label']"));
        // WebDriverWait wait = new WebDriverWait(driver1, 2000);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[data-test='radio-group-label']")));

        final List<WebElement> radiobutton = dri.findElements(
                By.cssSelector("label[data-test='radio-group-label']"));
        final WebDriverWait wait = new WebDriverWait(dri, 4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("label[data-test='radio-group-label']")));

        System.out.println("radiobutton.size() " + radiobutton.size());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("label[data-test='radio-group-label']")));
        // for (WebElement submenu : radiobutton) {
        for (int i = 0; i < radiobutton.size(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("label[data-test='radio-group-label']")));
            System.out.println(
                    " submenu.getText before clicking on the radio button: "
                            + radiobutton.get(i).getText());
            final Actions actions = new Actions(dri);
            actions.moveToElement(radiobutton.get(i)).build();
            // actions.click();
            // actions.build();
            // actions.perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("label[data-test='radio-group-label']")));
            // Thread.sleep(2000);
            final String ToolTipText = radiobutton.get(i).getAttribute("value");
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("label[data-test='radio-group-label']")));
            System.out.println("Tooltip value is: " + ToolTipText);
            // System.out.println(
            // " submenu.getText before clicking on the radio button: "
            // + submenu.getText());
            // if(submenu.getAttribute("value").equals(""))
            if (!radiobutton.get(i).isSelected()) {

                radiobutton.get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector("label[data-test='radio-group-label']")));
                final String str = radiobutton.get(i).getText();
                System.out.println(
                        "str - radion button value after clicking on radio button:"
                                + str);
            }

        }
    }

    /**
     * Checks if is element clickable.
     *
     * @param elements
     *            the elements
     * @throws Exception
     *             the exception
     */
    public static void isElementClickable(final List<WebElement> elements)
            throws Exception {
        for (final WebElement e : elements) {
            e.getText();
            System.out.println("e.getText() +" + e.getText());
        }
        getSubMenuItems();
    }
    // List<WebElement> radiobutton =
    // driver1.findElements(By.cssSelector("div[data-test='hex-icon']"));
    // span[data-test='bubble-span']
    // List<WebElement> radiobutton =
    // driver1.findElements(By.cssSelector("input[type='radio']"));
    // WebElement ele =
    // driver1.findElement(By.cssSelector("input[type='radio']"));
    // System.out.println("ele.getext : " +ele.getText());
    // List<WebElement> radiobutton =
    // driver1.findElements(By.cssSelector("span[data-test='bubble-span']"));
    // List<WebElement> radiobutton =
    // driver1.findElements(By.cssSelector("label[data-test='radio-group-label']"));
    // List<WebElement> attr =

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws Exception
     *             the exception
     */
    public static void main(final String[] args) throws Exception {
        // WebDriver driver1;
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        final FirefoxBinary binary = new FirefoxBinary();
        final FirefoxProfile profile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir")
                        + "/Browsers/FirefoxDriver/geckodriver");
        capabilities.setCapability("marionette", true);
        dri = new FirefoxDriver(binary, profile, capabilities);
        dri.get("http://localhost:3200/vehicles/mazda-3/trims");
        dri.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        final List<WebElement> eleLoc = dri
                .findElements(By.cssSelector("div[data-test='text-toggle']"));
        System.out.println(eleLoc.size());
        isElementClickable(eleLoc);
        dri.quit();

    }

}
