/*
 *
 */
package au.com.mazda.MDP.Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The Class MDP_Excel.
 *
 * @author cheaus
 */
public class MDP_Excel {

    /**
     * Gets the cell value.
     *
     * @param sExcelFile
     *            the s excel file
     * @param sSheetName
     *            the s sheet name
     * @param iRowNum
     *            the i row num
     * @param iColNum
     *            the i col num
     * @return the cell value
     * @throws Exception
     *             the exception
     */

    public static String getCellValue(final String sExcelFile,
            final String sSheetName, final int iRowNum, final int iColNum)
                    throws Exception {
        try {
            final FileInputStream fis = new FileInputStream(sExcelFile);
            final Workbook workbook = WorkbookFactory.create(fis);

            final Cell cell = workbook.getSheet(sSheetName).getRow(iRowNum)
                    .getCell(iColNum);
            fis.close();
            workbook.close();
            return cell.getStringCellValue();
        } catch (Exception e) {
            MDP_MyCustomisedLogs
                    .info("Successfully logged in to the Episerver koalaqa!!!"
                            + e.toString());
            return "";
        }
    }

    /**
     * Gets the cell value.
     *
     * @param sheet
     *            the sheet
     * @param row
     *            the row
     * @param col
     *            the col
     * @return the cell value
     */
    public static String getCellValue(XSSFSheet sheet, int row, int col) {
        String cellVal = "";
        try {
            Cell cell = sheet.getRow(row).getCell(col);
            if (cell != null) {
                cellVal = cell.getStringCellValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellVal;
    }

    /**
     * Gets the column count. public static String getCellValue(XSSFSheet sheet,
     * int row, int col) { String cellVal = ""; try { Cell cell =
     * sheet.getRow(row).getCell(col); if(cell != null) cellVal =
     * cell.getStringCellValue(); }catch(Exception e){ e.printStackTrace();
     *
     * @param sExcelFile
     *            the s excel file
     * @param sSheetName
     *            the s sheet name
     * @param rowNum
     *            the row num
     * @return the column count
     */

    public static int getColumnCount(final String sExcelFile,
            final String sSheetName, final int rowNum) {
        try {
            final FileInputStream fis = new FileInputStream(sExcelFile);
            final Workbook workbook = WorkbookFactory.create(fis);
            final int iColCount = workbook.getSheet(sSheetName).getRow(rowNum)
                    .getPhysicalNumberOfCells();
            fis.close();
            workbook.close();
            return iColCount;
        } catch (final Exception e) {
            MDP_MyCustomisedLogs
                    .info("Successfully logged in to the Episerver koalaqa!!!"
                            + e.toString());
            return 0;
        }
    }

    /**
     * Gets the row count.
     *
     * @param sExcelFile
     *            the s excel file
     * @param sSheetName
     *            the s sheet name
     * @return the row count
     */

    public static int getRowCount(final String sExcelFile,
            final String sSheetName) {
        try {
            final FileInputStream fis = new FileInputStream(sExcelFile);
            final Workbook workbook = WorkbookFactory.create(fis);
            final int iRowCount = workbook.getSheet(sSheetName).getLastRowNum();
            fis.close();
            workbook.close();
            return iRowCount;

        } catch (Exception e) {
            MDP_MyCustomisedLogs
                    .info("Successfully logged in to the Episerver koalaqa!!!"
                            + e.toString());
            return 0;

        }
    }

    /**
     * Gets the excel data.
     *
     * @param dataproviderExcelFilePath
     *            the dataprovider excel file path
     * @return the excel data
     */
    public static Object[][] getExcelData(String dataproviderExcelFilePath) {
        String[][] arrExcelData = null;
        FileInputStream file = null;
        XSSFWorkbook workbook = null;

        try {
            file = new FileInputStream(dataproviderExcelFilePath);
            workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int noOfRows = sheet.getLastRowNum();
            System.out.println("No of rows====" + noOfRows);
            MDP_MyCustomisedLogs.info("Number of Rows:  " + noOfRows);

            int noOfCols = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("No of cols====" + noOfCols);
            MDP_MyCustomisedLogs.info("Number of Cols:  " + noOfCols);

            arrExcelData = new String[noOfRows][noOfCols];

            for (int i = 1; i <= noOfRows; i++) {

                for (int j = 0; j < noOfCols; j++) {
                    arrExcelData[i - 1][j] = MDP_Excel.getCellValue(sheet, i,
                            j);
                }
            }
            workbook.close();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // finally {
        // try {
        // workbook.close();
        // file.close();
        // } catch (Exception e) {
        //
        // e.printStackTrace();
        // }
        // }
        return arrExcelData;
    }

}
