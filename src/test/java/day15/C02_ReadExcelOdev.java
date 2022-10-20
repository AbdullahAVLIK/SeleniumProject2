package day15;

import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C02_ReadExcelOdev {
    //Yeni bir test method olusturalim readExcel2()
    @Test
    public void readExcel2() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(0);
        Cell cell =row.getCell(1);
        System.out.println("cell = " + cell);



        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String cell1 =cell.toString();
        System.out.println("cell1 = " + cell1);
        //-2.satir 4.cell’in afganistan’in baskenti oldugunu testedelim
        String actualData=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedData ="Kabil";
        Assert.assertEquals(expectedData,actualData);
        //-Satir sayisinibulalim
        int rowNumber =workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Satır Sayisi: "+(rowNumber+1));;
        //-Fiziki olarak kullanilan satir sayisinibulun
        int physicalNumberOfRows =workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Fiziki olarak kullanilan satir sayisi: "+physicalNumberOfRows);
        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        List<String> countries =new ArrayList<>();
        List<String> capitals =new ArrayList<>();
        Map<String,String> countriesAndCapitals= new HashMap<>();
        for (int i = 0; i <=rowNumber ; i++) {
            countries.add(workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString());
            capitals.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
            countriesAndCapitals.put(countries.get(i),capitals.get(i));
        }
        System.out.println(countriesAndCapitals);

        }

    }

