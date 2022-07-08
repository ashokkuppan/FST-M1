package activities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {
    private static String fileName = "resources/TestSheet.xlsx";

    public static void main(String[] args){
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet("DataTypes in Java");

        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;

        for (Object[] datatype : datatypes) {
            Row row = sh.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            wb.write(outputStream);
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }
}
