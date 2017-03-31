/**
 *
 */
package au.com.mazda.MDP.Utility;

import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class TestUtil.
 *
 * @author cheaus
 */
public class TestUtil {

    /**
     * Gets the data.
     *
     * @param testCase
     *            finds the test in xls
     * @param xls
     *            - gets the # of rows and # of cols
     * @return object array
     * @throws Exception
     *             when the data is null
     */
    public static Object[][] getData(String testCase, MDP_Excel xls)
            throws Exception {
        System.out.println("*************");

        // find the test in xlx
        // find number of cols in test
        // number of rows in test
        // put the data in hastable and put hashtable in object array
        // return object array

        int testCaseStartRowNum = 0;
        for (int rNum = 1; rNum <= MDP_Excel.getRowCount(
                MDP_Constant.S_EXCEL_FILE_PATH,
                MDP_Constant.S_SHEET_TEST_DATA); rNum++) {
            if (testCase.equalsIgnoreCase(
                    MDP_Excel.getCellValue(MDP_Constant.S_EXCEL_FILE_PATH,
                            MDP_Constant.S_SHEET_TEST_DATA, 0, rNum))) {
                testCaseStartRowNum = rNum;
                break;

            }
        }
        System.out.println("Test starts from row ---> " + testCaseStartRowNum);

        // total cols
        int colsStartRowNum = testCaseStartRowNum + 1;
        int cols = 0;
        while (!MDP_Excel
                .getCellValue(MDP_Constant.S_EXCEL_FILE_PATH,
                        MDP_Constant.S_SHEET_TEST_DATA, colsStartRowNum, cols)
                .equals("")) {
            cols++;
        }

        System.out.println("Total cols in test --> " + cols);

        // rows
        int rowStartRowNum = testCaseStartRowNum = 1;
        int rows = 0;
        while (!MDP_Excel.getCellValue(MDP_Constant.S_EXCEL_FILE_PATH,
                MDP_Constant.S_SHEET_TEST_DATA, 0, (rowStartRowNum + rows))
                .equals("")) {
            rows++;

        }
        System.out.println("Total rows in test  -> " + rows);
        Object[][] data = new Object[rows][1];
        Hashtable<String, String> table = null;

        // print the test data
        for (int rNum = rowStartRowNum; rNum < (rows
                + rowStartRowNum); rNum++) {
            table = new Hashtable<String, String>();
            for (int cNum = 0; cNum < cols; cNum++) {
                table.put(MDP_Excel.getCellValue(MDP_Constant.S_EXCEL_FILE_PATH,
                        MDP_Constant.S_SHEET_TEST_DATA, colsStartRowNum, cNum),
                        MDP_Excel.getCellValue(MDP_Constant.S_EXCEL_FILE_PATH,
                                MDP_Constant.S_SHEET_TEST_DATA, rNum, cNum));
            }
            data[rNum - rowStartRowNum][0] = table;

        }
        return data;

    }

    /**
     * Checks if is test case executable.
     *
     * @param testCase
     *            -- get the testcase name
     * @param xls
     *            - from this spreadsheet
     * @return true or false
     * @throws Exception
     *             when the test case run node is not Yes
     */
    public static boolean isTestCaseExecutable(String testCase, MDP_Excel xls)
            throws Exception {
        // true - Y
        // false - N
        for (int rNum = 1; rNum <= MDP_Excel.getRowCount(
                MDP_Constant.S_EXCEL_FILE_PATH,
                MDP_Constant.S_SHEET_TEST_CASES); rNum++) {
            if (testCase.equals(
                    MDP_Excel.getCellValue(MDP_Constant.S_EXCEL_FILE_PATH,
                            MDP_Constant.S_SHEET_TEST_CASES, rNum,
                            MDP_Constant.I_COL_TEST_CASE_ID))) {
                // check run mode

                if (MDP_Excel
                        .getCellValue(MDP_Constant.S_EXCEL_FILE_PATH,
                                MDP_Constant.S_SHEET_TEST_CASES, rNum,
                                MDP_Constant.I_COL_RUN_MODE)
                        .equalsIgnoreCase("y")) {
                    return true;
                }
                return false;

            }
        }
        return false;
    }

}
