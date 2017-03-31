/// *
// *
// */
// package au.com.mazda.MDP.TestCases;
//
// import java.util.Iterator;
// import java.util.Set;
//
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
//
//// TODO: Auto-generated Javadoc
/// **
// * The Class getCookie_PostCode.
// *
// * @author cheaus
// */
// public class getCookie_PostCode {
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
// public static void main(final String[] args) throws Exception {
//
// driver2 = new ChromeDriver();
// driver2.get("http://koala.node.chdigital.com.au/");
//
// // Thread.sleep(5000);
//
// driver2.findElement(By.cssSelector(
// "#koala > div > div > footer > div > span > div:nth-child(1)"))
// .click();
//
// driver2.findElement(By.cssSelector(
// "#koala > div > div > footer > div > span > div:nth-child(2) > div >
/// div.rmq-63c906da > div > input[type='text']"))
// .clear();
// driver2.findElement(By.cssSelector(
// "#koala > div > div > footer > div > span > div:nth-child(2) > div >
/// div.rmq-63c906da > div > input[type='text']"))
// .sendKeys("3205");
// driver2.findElement(By.cssSelector(
// "#koala > div > div > footer > div > span > div:nth-child(2) > div >
/// div.rmq-63c906da > button"))
// .click();
//
// Thread.sleep(3000);
// final Set<org.openqa.selenium.Cookie> cookies = driver2.manage()
// .getCookies();
// System.out.println("Size: " + cookies.size());
//
// final Iterator<org.openqa.selenium.Cookie> itr = cookies.iterator();
// while (itr.hasNext()) {
// final org.openqa.selenium.Cookie cookie = itr.next();
// System.out.println(cookie.getName() + "::" + cookie.getPath() + "<"
// + cookie.getDomain() + "> ||" + cookie.getValue() + "::"
// + cookie.getExpiry());
// }
//
// }
//
// }
