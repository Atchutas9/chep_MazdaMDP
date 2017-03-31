/*
 *
 */
package au.com.mazda.MDP.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleMDPTests.
 *
 * @author cheaus
 */
public class SampleMDPTests {

    /** The driver 1. */
    public static WebDriver driver1;

    // @FindBy(className="cta-state-1")
    // public static WebElement cta_Mazda3;

    /**
     * Gets the all elements text.
     *
     * @param elements
     *            the elements
     * @return the all elements text
     */
    public static void getAllElementsText(final List<WebElement> elements) {

        try {
            final int eleCount = elements.size();
            // for(WebElement we : elements) {
            for (int i = 0; i < eleCount; i++) {
                final String eleText = elements.get(i).getText();

                if (eleText.length() != 0) {
                    System.out.println(eleText);
                }

            }

        } catch (final Exception e) {
            System.out.println(e.toString());
        }

    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws Exception
     *             the exception
     */
    public static void main(final String[] args) throws Exception {

        // driver1 = new ChromeDriver();
        // driver1.get("https://www.mazdausa.com/");
        driver1 = new SafariDriver();
        driver1.get("http://koala.node.chdigital.com.au/#");
        final List<WebElement> allTags_a = driver1
                .findElements(By.tagName("a"));

        final List<WebElement> allTags_img = driver1
                .findElements(By.tagName("img"));
        final List<WebElement> allTags_div = driver1
                .findElements(By.tagName("div"));
        final List<WebElement> allTags_span = driver1
                .findElements(By.tagName("span"));
        final List<WebElement> allTags_h3 = driver1
                .findElements(By.tagName("h3"));
        // Thread.sleep(7000);
        // driver1.findElement(By.cssSelector("body > main > div.hero > div >
        // div > div.mde-hero__cta-container > a:nth-child(1) > div > span >
        // span.cta-state-1")).isDisplayed();
        // driver1.findElement(By.cssSelector("body > main > div.hero > div >
        // div > div.mde-hero__cta-container > a:nth-child(1) > div > span >
        // span.cta-state-1")).click();
        // String str_CurrentURL = driver1.getCurrentUrl();
        // System.out.println("str_CurrentURL : " +str_CurrentURL);

        System.out.println(
                "     ************      allTags_a    ****************");
        getAllElementsText(allTags_a);
        System.out.println();
        System.out.println(
                "     ************      allTags_img    ****************");
        getAllElementsText(allTags_img);
        System.out.println();
        System.out.println(
                "     ************      allTags_div    ****************");
        getAllElementsText(allTags_div);
        System.out.println();
        System.out.println(
                "     ************      allTags_span    ****************");
        getAllElementsText(allTags_span);
        System.out.println();
        System.out.println(
                "     ************      allTags_h3    ****************");
        getAllElementsText(allTags_h3);

        driver1.quit();

    }
}
