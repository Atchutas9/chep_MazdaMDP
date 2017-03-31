package au.com.mazda.MDP.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import au.com.mazda.MDP.Utility.MDP_Constant;
import au.com.mazda.MDP.Utility.MDP_Excel;
import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
import au.com.mazda.MDP.configurator.ConfiguratorBodyType_TC;
import au.com.mazda.MDP.configurator.ConfiguratorColourType_TC;
import au.com.mazda.MDP.configurator.ConfiguratorDriveTrain_TC;
import au.com.mazda.MDP.configurator.ConfiguratorGradeType_TC;
import au.com.mazda.MDP.configurator.ConfiguratorSummary_TC;

/**
 * The Class Configurator_Tc.
 */
public class Configurator_Tc extends SuperClass {

    /** The run. */
    int run = 1;

    /** The sa. */
    SoftAssert sa = new SoftAssert();

    /**
     * Gets the configurator data.
     *
     * @return the configurator data
     */
    @DataProvider(name = "ConfiguratorData")
    public static Object[][] getConfiguratorData() {

        Object[][] arrObj = MDP_Excel
                .getExcelData(MDP_Constant.CONFIGURATOR_EXCEL_FILE_PATH);
        return arrObj;

    }

    /**
     * Verify configurator test scenarios.
     *
     * @param runMode
     *            the run mode
     * @param model
     *            the model
     * @param body
     *            the body
     * @param driveTrain
     *            the drive train
     * @param grade
     *            the grade
     * @param transmission
     *            the transmission
     * @param engineType
     *            the engine type
     * @param colour
     *            the colour
     */
    @Test(dataProvider = "ConfiguratorData", description = "Executing the test cases for the Configurator Page")
    public static void verifyConfiguratorTestScenarios(String runMode,
            String model, String body, String driveTrain, String grade,
            String transmission, String engineType, String colour) {
        //
        try {

            MDP_MyCustomisedLogs.info("row info======" + runMode + " " + model
                    + " " + body + " " + driveTrain + " " + grade + " "
                    + transmission + " " + engineType + " " + colour);

            getURLFromSpreadsheet();
            ConfiguratorLandingPage_TC lpObj = new ConfiguratorLandingPage_TC(
                    driver);
            lpObj.executeLandingPageTestCases(model);

            if (!body.equalsIgnoreCase(MDP_Constant._SKIP)) {
                ConfiguratorBodyType_TC bodyObj = new ConfiguratorBodyType_TC(
                        driver);
                bodyObj.executeConfigBodyTestCases(model, body);
            }
            if (!driveTrain.equalsIgnoreCase(MDP_Constant._SKIP)) {
                ConfiguratorDriveTrain_TC driveObj = new ConfiguratorDriveTrain_TC(
                        driver);
                driveObj.executeConfigDriveTrainTestCases(model, body,
                        driveTrain);
            }
            ConfiguratorGradeType_TC gradeObj = new ConfiguratorGradeType_TC(
                    driver);
            ConfiguratorGradeType_TC.executeConfigGradeTestCases(model, body,
                    grade, transmission, engineType);

            if (colour.equalsIgnoreCase(MDP_Constant._RUN)) {
                ConfiguratorColourType_TC colourObj = new ConfiguratorColourType_TC(
                        driver);
                colourObj.executeConfigColourTestCases(model, body, grade,
                        transmission, engineType);
            }

            ConfiguratorSummary_TC summaryObj = new ConfiguratorSummary_TC(
                    driver);
            summaryObj.executeConfigSummaryTestCases(model, body, grade,
                    transmission, engineType, driveTrain);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
