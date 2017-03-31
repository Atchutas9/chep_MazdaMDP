// package au.com.mazda.MDP.TestCases;
//
// import java.io.FileInputStream;
// import java.io.IOException;
//
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.testng.annotations.Test;
//
// import au.com.mazda.MDP.Utility.MDP_Constant;
// import au.com.mazda.MDP.Utility.MDP_Excel;
// import au.com.mazda.MDP.Utility.MDP_MyCustomisedLogs;
// import au.com.mazda.MDP.configurator.ConfiguratorBodyTypeMobile_TC;
//
//
// public class ConfiguratorMobile_TC extends SuperClass{
//
// @Test(description = "Executing the test cases for the Configurator Page")
// public void verifyConfiguratorTestScenarios() {
// FileInputStream file = null;
// XSSFWorkbook workbook = null;
// try{
// file = new FileInputStream(MDP_Constant.CONFIGURATOR_EXCEL_FILE_PATH);
//
// //Get the workbook instance for XLS file
// workbook = new XSSFWorkbook (file);
// int noOfSheets = workbook.getNumberOfSheets();
// System.out.println("no of sheets====="+noOfSheets);
// MDP_MyCustomisedLogs.info("Number of Sheets: " +noOfSheets);
// getURLFromSpreadsheet();
//
// for(int i=0; i<=0 ; i++){
// XSSFSheet sheet = workbook.getSheetAt(i);
// int noOfRows = sheet.getLastRowNum();
// System.out.println(noOfRows);
// for(int j=1; j<=1; j++){
//
// String runMode = MDP_Excel.getCellValue( sheet,j,0);
// String model = MDP_Excel.getCellValue( sheet,j,1);
// String body = MDP_Excel.getCellValue( sheet,j,2);
// String driveTrain = MDP_Excel.getCellValue( sheet,j,3);
// String grade = MDP_Excel.getCellValue( sheet,j,4);
// String transmission = MDP_Excel.getCellValue( sheet,j,5);
// String engineType = MDP_Excel.getCellValue( sheet,j,6);
// String colour = MDP_Excel.getCellValue( sheet,j,7);
//
//
// System.out.println("row"+j+" info======"+runMode+" " +model+" "+ body+" "
// +driveTrain+" "+grade+" "+
// transmission+" "+engineType+" "+colour);
//
// //check order of pages for diff models
// //order the test cases
// //include next steps click
// //check the required parameters to pass in diff methods
// if(runMode.equalsIgnoreCase(MDP_Constant._RUN)){
//
// if(!body.equalsIgnoreCase(MDP_Constant._SKIP)){
// ConfiguratorBodyTypeMobile_TC bodyObj = new
// ConfiguratorBodyTypeMobile_TC(driver);
// bodyObj.executeConfigBodyTestCases(model,body);
// /* }else{
// ConfiguratorLandingPage_TC lpObj = new ConfiguratorLandingPage_TC(driver);
// lpObj.executeLandingPageTestCases(model);
// }
// if(!driveTrain.equalsIgnoreCase(MDP_Constant._SKIP)){
// ConfiguratorDriveTrain_TC driveObj = new ConfiguratorDriveTrain_TC(driver);
// driveObj.executeConfigDriveTrainTestCases(model, body, driveTrain);
// }
// ConfiguratorGradeType_TC gradeObj = new ConfiguratorGradeType_TC(driver);
// gradeObj.executeConfigGradeTestCases(model,body,grade,transmission,engineType);
//
// if(colour.equalsIgnoreCase(MDP_Constant._RUN)){
// ConfiguratorColourType_TC colourObj = new ConfiguratorColourType_TC(driver);
// colourObj.executeConfigColourTestCases(model, body, grade,
// transmission,engineType);
// }
//
// ConfiguratorSummary_TC summaryObj = new ConfiguratorSummary_TC(driver);
// summaryObj.executeConfigSummaryTestCases(model, body, grade,
// transmission,engineType, driveTrain); */
// }
// else{
// MDP_MyCustomisedLogs.info("The Run mode is: n");
// }
// }
// }
// }
// }catch(Exception e){
// e.printStackTrace();
// }finally{
// try {
// workbook.close();
// file.close();
// } catch (IOException e) {
//
// e.printStackTrace();
// }
// }
// }
//
// }
