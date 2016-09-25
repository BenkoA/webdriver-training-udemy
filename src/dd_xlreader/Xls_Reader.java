package dd_xlreader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by adrianbenko on 25/09/2016.
 */
public class Xls_Reader {

    public String path;
    public FileInputStream fis = null;
    public FileOutputStream fileOut = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow  row = null;
    private XSSFCell cell = null;

    public Xls_Reader(String path) {
        this.path = path;

        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * returns the row count in a sheet
     * @param sheetName
     * @return
     */
    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return 0
        }
        else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }
    }

    /**
     * returns the data from a cell
     * @param sheetName
     * @param colName
     * @param rowNum
     * @return
     */
    public String getCellData(String sheetName, String colName, int rowNum){
        try{
            if (rowNum <= 0)
                return  "";

            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1;
            if (index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);

            for (int i = 0; i < row.getLastCellNum(); i++){
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
            if (col_Num == -1)
                return  "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum-1);
            if (row == null)
                return "";
            cell = row.getCell(col_Num);

            if (cell == null)
                return "";

            if (cell.getCellType() == Cell.CELL_TYPE_STRING)
                return cell.getStringCellValue();
            else
                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC || cell.getCellType() ++ Cell.CELL_TYPE_DATE) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    double d = cell.getNumericCellValue();
                }
            }
            return "";
        }
    }
}
