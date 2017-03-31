/// *
// *
// */
// package au.com.mazda.MDP.TestCases;
//
// import java.util.List;
// import java.util.concurrent.TimeUnit;
//
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
//
//// TODO: Auto-generated Javadoc
/// **
// * The Class Configurator.
// *
// * @author cheaus
// */
// public abstract class Configurator {
//
// /** The driver 2. */
// public static WebDriver driver2;
//
// /**
// * The main method.
// *
// * @param args
// * the arguments
// * @throws Exception
// * the exception
// */
// @SuppressWarnings("unused")
// public static void main(final String[] args) throws Exception {
//
// // driver1 = new ChromeDriver();
// // driver1.get("https://www.mazdausa.com/");
// driver2 = new ChromeDriver();
// driver2.get("http://koala.node.chdigital.com.au/");
//
// driver2.get(
// "http://koala.node.chdigital.com.au/vehicles/mazda-3/trims");
// driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
// // #trims > div
// // #trims > div
//
// // Get input tag and store in List variable name is
// // number_of_hidden_input_Elements
// final List<WebElement> number_of_hidden_input_Elements = driver2
// .findElements(By.cssSelector("div[data-test='text-toggle']"));
// // Print total size input hidden webelements
// System.out.println("\n\nInput Hidden Element =: "
// + number_of_hidden_input_Elements.size());
// System.out.println(
// "========================================================");
// for (int i = 0; i < number_of_hidden_input_Elements.size(); i++) {
// // Print all hidden input webelements value
// if (number_of_hidden_input_Elements.get(i).getAttribute("type")
// .trim().equalsIgnoreCase("radio")) {
// // Check empty text
// if (!(number_of_hidden_input_Elements.get(i)
// .getAttribute("value").trim().isEmpty())) {
// // Print hidden Element texts
// System.out.println("Input Hidden Element = " + i + " " //$NON-NLS-2$
// + number_of_hidden_input_Elements.get(i)
// .getAttribute("value").trim());
// }
// }
// }
// // List<WebElement> allTags_config_trim_div =
// // driver2.findElements(By.cssSelector("div[data-test='bubble']"));
// // List<WebElement> allTags_config_trim_div =
// // driver2.findElements(By.tagName("div"));
// // final List<WebElement> allTags_config_trim_div = driver2
// // .findElements(By.cssSelector("input[type='radio']"));
// // List<WebElement> allTags_config_trim_div =
// // driver2.findElements(By.id("trims"));
//
// // WebElement ele_jet_black_mica =
// // driver2.findElement((By.cssSelector("input[type='radio' and
// // value='jet-black-mica']")));
// // String str_jet_black_mica = ele_jet_black_mica.getText();
// // System.out.println("str_jet_black_mica :: " +str_jet_black_mica);
// System.out.println(
// " ************ allTags_config_trim_div ****************");
// // getAllElementsText_1(allTags_config_trim_div);
// driver2.quit();
// }
//
// // private static void getAllElementsText_1(List<WebElement> elements) {
// //
// // try {
// // int eleCount = elements.size();
// // //for(WebElement we : elements) {
// // System.out.println(" eleCount : " +eleCount);
// // for (int i = 0; i < eleCount; i++) {
// //
// // final String eleText = elements.get(i).getText();
// //
// //
// // // if(eleText.length()!=0) {
// // System.out.println(eleText);
// // // }
// //
// //
// // }
// //
// // }catch(Exception e) {
// // System.out.println(e.toString());
// // }
//
// // }
// }
