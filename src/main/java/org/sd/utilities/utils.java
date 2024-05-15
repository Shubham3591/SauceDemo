package org.sd.utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class utils {

    public static String TESTDATA_SHEET_PATH = (System.getProperty("user.dir") + "/src/main/java/org/sd/testDataExcel/TitanDevTestdata.xlsx");
    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (Exception e) {
            System.err.println("Exception captured inside Logout Method \n" + e);
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (Exception e) {
            System.err.println("Exception captured inside Logout Method \n" + e);
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        //System.out.println(sheet.getLastRowNum() + "--------");
        sheet.getRow(0).getLastCellNum();
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                //data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                String str = sheet.getRow(i + 1).getCell(k).toString();
                data[i][k] = str.replace(".0", "");
                //System.out.println(data[i][k]);
            }
        }
        return data;
    }



}
