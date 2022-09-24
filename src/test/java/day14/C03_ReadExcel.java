package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {

        // belirtilen satir no ve sutun no degerlerini parametre olarak alip
        // o cell'deki datayi konsola yazdirin
        // sonra sonucun konsolda yazanla ayni oldugunu dogrulayin
        int row=12;
        int cell =2;

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData =workbook.getSheet("Sayfa1").getRow(row-1).getCell(cell-1).toString();
        System.out.println(actualData);
        String expectedData = "Baku";
        Assert.assertEquals(expectedData,actualData);

        //public Cell yazdir(String sheet, int satir, int sutun) throws IOException {
        //
        //    String patch = "src/recources/ulkeler.xlsx";
        //    FileInputStream fileInputStream = new FileInputStream(patch);
        //    Workbook workbook = WorkbookFactory.create(fileInputStream);
        //    Cell data = workbook.getSheet(sheet).getRow(satir).getCell(sutun);
        //
        //    return data;
        //}
    }
}
