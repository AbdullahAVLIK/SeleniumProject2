package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase_BeforeClassAfterClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C05_GetScreenshot extends TestBase_BeforeClassAfterClass {
    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidip tüm sayfanın remini alalım
        driver.get("https://www.hepsiburada.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi =ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntuleri/allPage_"+tarih+".jpeg"));

    }
}
