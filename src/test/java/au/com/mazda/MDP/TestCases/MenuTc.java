/*
 *
 */
package au.com.mazda.MDP.TestCases;

import org.testng.annotations.Test;

import au.com.mazda.MDP.PageObjects_PF.MenuPf;
import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;

// TODO: Auto-generated Javadoc
// This test cases is to retrieve menu elements

/**
 * The Class MenuTc.
 *
 * @author cheaus
 */
public class MenuTc extends SuperClass {

    // test case to verify Menu items
    /**
     * Test verify menu.
     */
    @Test(description = "verify Menu")
    public static void testVerifyMenu() {
        try {
            MDP_MyCustomisedLogs.startTestCase(strTestName);

            final MenuPf menuPF = new MenuPf(driver);
            getURLFromSpreadsheet();

            menuPF.executeMenu();
            // verifyLinks_Execute();
            getScreenshot(driver, str_DriverBrowserName, str_DriverOS,
                    str_DriverVersion, strTestName, "PASS", "");

            MDP_MyCustomisedLogs.endTestCase(strTestName);
        } catch (final Exception e) {
            MDP_MyCustomisedLogs.error(e.toString());
        }

    }

}
