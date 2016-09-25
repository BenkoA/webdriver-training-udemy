package dd_util;

import dd_core.testCore;
import dd_xlreader.Xls_Reader;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by adrianbenko on 25/09/2016.
 */
public class TestUtil extends testCore {

    public static boolean isExecutable(String testName) {
        for(int rowNum = 2; rowNum <=excel.getRowCount("test_suite"); rowNum++){
            if (excel.getCelLData("test_suite", "TCID", rowNum).equals(testName)){
                return excel.getCellData("test_suite", "Runmode", rowNum).equalsIgnoreCase("Y");
            }
        }
        return false;
    }

    public static Object[][] getData()(String testName) {

        if (excel == null){
            excel = new Xls_Reader(System.getProperty("user.dir")+"//src//dd_properties//testData.xlsx");
        }

        int rows = excel.getRowCount(testName)-1;
        if (rows <= 0) {
            return new Object[1][0];
        }

        rows = excel.getRowCount(testName);
        int cols = excel.getColumnCount(testName);

        System.out.println("Test Name:  " + testName);
        System.out.println("Total Rows:  " + rows);
        System.out.println("Total Cols:  " + cols);

        Object data[][] = new Object[rows -1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++){
            for (int colNum = 0; colNum < cols; colNum++){
                data[rowNum-2][colNum] = excel.getCellData(testName, colNum, rowNum);
            }
        }

        return data;
    }

    public static void captureScreenshot(){
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int sec = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.HOUR_OF_DAY);

        String imageDestination = "/test-output";
        Object screenshotAs = testCore.selenium.getScreenshotAs(imageDestination + year + month + day + min + sec + "_" + date);


    }
}
