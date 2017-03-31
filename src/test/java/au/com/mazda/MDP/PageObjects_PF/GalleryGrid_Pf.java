/// *
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
// * The Class GalleryGrid_Pf.
// *
// * @author cheaus
// */
// public class GalleryGrid_Pf extends SuperClass {
//
// /** The loc inpage nav list. */
// @FindBy(how = How.CSS, using = "span[data-test='in-page-navigation-item']")
// public List<WebElement> LOC_INPAGE_NAV_LIST;
//
// /** The loc gallery heading. */
// @FindBy(how = How.CSS, using = "div[data-test='heading']/h2")
// public WebElement LOC_GALLERY_HEADING;
//
// /** The loc gallery img list. */
// @FindBy(how = How.CSS, using = "figure[data-test='gallery-item']")
// public List<WebElement> LOC_GALLERY_IMG_LIST;
//
// /** The loc gallery video list. */
// @FindBy(how = How.CSS, using = "video")
// public List<WebElement> LOC_GALLERY_VIDEO_LIST;
//
// /** The loc gallery img overlay. */
// @FindBy(how = How.CSS, using = "div[data-test='overlay']")
// public WebElement LOC_GALLERY_IMG_OVERLAY;
//
// /** The loc gallery img overlayclose. */
// @FindBy(how = How.CSS, using = "div[data-test='overlay-close']")
// public WebElement LOC_GALLERY_IMG_OVERLAYCLOSE;
//
// /** The loc fiftyfiftyblock img. */
// @FindBy(how = How.CSS, using = "section[data-test='fifty-fifty-block']")
// public WebElement LOC_FIFTYFIFTYBLOCK_IMG;
//
// // @FindBy(how = How.XPATH, using =
// // "//span[data-test='in-page-navigation-item']")
// // public List<WebElement> LOC_INPAGE_NAV_LIST;
// //
// // @FindBy(how = How.XPATH, using = "//div[data-test='heading']")
// // public WebElement LOC_GALLERY_HEADING;
// //
// // @FindBy(how = How.XPATH, using = "//figure[data-test='gallery-item']")
// // public List<WebElement> LOC_GALLERY_IMG;
// //
// // @FindBy(how = How.XPATH, using = "//video")
// // public List<WebElement> LOC_GALLERY_VIDEO;
// //
// // @FindBy(how = How.XPATH, using = "//div[data-test='overlay']")
// // public WebElement LOC_GALLERY_IMG_OVERLAY;
// //
// // @FindBy(how = How.XPATH, using = "//div[data-test='overlay-close']")
// // public WebElement LOC_GALLERY_IMG_OVERLAYCLOSE;
// //
// // @FindBy(how = How.XPATH, using =
// // "//section[data-test='fifty-fifty-block']")
// // public WebElement LOC_FIFTYFIFTYBLOCK_IMG;
// // SeleniumActions selAct;
//
// // constructor with driver as the parameter, to invoke the same driver when
// // executing the tests
// /**
// * Instantiates a new gallery grid pf.
// *
// * @param driver
// * the driver
// */
// public GalleryGrid_Pf(final WebDriver driver) {
// PageFactory.initElements(driver, this);
// }
//
// /**
// * Verify gallery imgs.
// *
// * @throws Exception
// * the exception
// */
// public void verifyGalleryImgs() throws Exception {
// try {
// final int count = getCountofElements(this.LOC_GALLERY_IMG_LIST,
// "Images in Gallery Grid");
// for (int i = 0; i <= count; i++) {
// this.LOC_GALLERY_IMG_LIST.get(i).click();
// isElementPresent(this.LOC_GALLERY_IMG_OVERLAY);
// isElementPresent(this.LOC_FIFTYFIFTYBLOCK_IMG);
// isElementPresent(this.LOC_GALLERY_HEADING);
// clickOnElement(this.LOC_GALLERY_IMG_OVERLAYCLOSE);
//
// }
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// throw new Exception(e.toString());
// }
//
// }
//
// /**
// * Verify gallery in nav page.
// *
// * @throws Exception
// * the exception
// */
// public void verifyGalleryInNavPage() throws Exception {
//
// try {
//
// // getCountofElements(LOC_INPAGE_NAV_LIST,
// // "Navigation List in Gallery Grid");
// // getAllElements(LOC_INPAGE_NAV_LIST);
// // selectThisElement("Gallery", LOC_INPAGE_NAV_LIST);
// isElementPresent(this.LOC_GALLERY_HEADING);
// getTextofElement(this.LOC_GALLERY_HEADING);
//
// getCountofElements(this.LOC_GALLERY_VIDEO_LIST,
// "Videos in Gallery Grid");
// } catch (final Exception e) {
// // TODO Auto-generated catch block
// MDP_MyCustomisedLogs.error(e.toString());
// throw new Exception(e.toString());
// }
//
// }
//
// /**
// * Verify gallery videos.
// *
// * @throws Exception
// * the exception
// */
// public void verifyGalleryVideos() throws Exception {
// try {
// final int count = getCountofElements(this.LOC_GALLERY_VIDEO_LIST,
// "Videos in Gallery Grid");
// for (int i = 0; i <= count; i++) {
// this.LOC_GALLERY_IMG_LIST.get(i).click();
//
// }
// } catch (final Exception e) {
// MDP_MyCustomisedLogs.error(e.toString());
// throw new Exception(e.toString());
// }
//
// }
//
// }
