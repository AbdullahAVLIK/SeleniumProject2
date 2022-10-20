package day15;

import com.beust.ah.A;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {
    @Test
    public void deleteExcel() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //-Row objesi olusturun sheet.getRow(3)
        Row row = sheet.getRow(0);
        //-Cell objesi olusturun row.getCell(3)
        Cell cell = row.getCell(4);
        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //-Silindiğini test edin
       // System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString());


    }
}
