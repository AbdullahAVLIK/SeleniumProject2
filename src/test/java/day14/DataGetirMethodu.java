package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataGetirMethodu {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        String sheet="Sayfa1";
        int row =4;
        int cell =4;
        String actualData = cellBul(dosyaYolu,sheet,row,cell);
        System.out.println(actualData);
        String expectedData = "Cezayir";
        Assert.assertEquals(expectedData,actualData);
    }

    public String cellBul(String dosyaYolu,String sheet, int row, int cell) throws IOException {
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        return workbook.getSheet(sheet).getRow(row-1).getCell(cell-1).toString();
    }
}
