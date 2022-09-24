package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void test01() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-Turkce baskentler sutununu yazdiralim
        int lastRow =workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(lastRow);
        String turkceBaskentler ="";
        for (int i = 0; i <=lastRow ; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }
        //Workbook workbook = WorkbookFactory.create(fis);
        //        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        //        List<String> turkceBaskentler = new ArrayList<String>();
        //        int j = 0;
        //        for (int i = 0; i <=sonSatir ; i++) {
        //            turkceBaskentler.add(i,workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());        //
        //        }
        //        for (int i = 0; i <=sonSatir ; i++) {
        //            System.out.println(i + "inci Sehir = " + turkceBaskentler.get(i).toString());
        //        }



        //List<String> list=new ArrayList<>();
        //for (int i = 0; i <=sonsatir ; i++) {
        //    list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        //}
        //list.forEach(t-> System.out.println(t));
    }
}
