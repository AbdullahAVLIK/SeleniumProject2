package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SutunGetir {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        String sheet ="Sayfa1";
        int cell =4;
        List<String> allcell=sutunGetir(dosyaYolu,sheet,cell);
        allcell.stream().forEach(t-> System.out.println(t));
    }

    public List<String> sutunGetir(String dosyaYolu, String sheet, int cell) throws IOException {
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int lastRow =workbook.getSheet(sheet).getLastRowNum();
        List<String>allCell  =new ArrayList<>();
        for (int i = 0; i <=lastRow ; i++) {
            allCell.add(workbook.getSheet(sheet).getRow(i).getCell(cell-1).toString());
        }
        return allCell;
        }
}

