package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void test01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //-WorkbookFactory.create(fileInputStream)
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int lastRow =workbook.getSheet("Sayfa2").getLastRowNum();//index e göre verdiği için bir eklemeliyiz
        System.out.println(lastRow);
        int expectedLastRow= 6;
        Assert.assertEquals(expectedLastRow,lastRow+1);//index e göre verdiği için +1 eklemeliyiz
        int usedRowNumber= workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println(usedRowNumber);
        int expectedUsedRowNumber =3;
        Assert.assertEquals(expectedUsedRowNumber,usedRowNumber);


    }
}
