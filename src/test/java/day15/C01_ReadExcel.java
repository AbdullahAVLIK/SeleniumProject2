package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //excel tablosundaki tüm elementleri yazdırın

        //nestedForLoop;
        int lastRow =workbook.getSheet("Sayfa1").getLastRowNum();
        String allCell ="";
        for (int i = 0; i <lastRow ; i++) {
            for (int j = 0; j <4 ; j++) {
                allCell = workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString();
                System.out.println(allCell);
            }
       }
        //print f ile :::
        for (int i = 0; i <=lastRow ; i++) {
            System.out.printf("%-15s %-15s %-15s %-15s\n",
                    workbook.getSheet("Sayfa1").
                            getRow(i).getCell(0),
                    workbook.getSheet("Sayfa1").
                            getRow(i).getCell(1),
                    workbook.getSheet("Sayfa1").
                            getRow(i).getCell(2),
                    workbook.getSheet("Sayfa1").
                            getRow(i).getCell(3));
        }
    }
}
