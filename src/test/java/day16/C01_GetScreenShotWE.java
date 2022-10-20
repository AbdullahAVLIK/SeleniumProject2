package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBase_BeforeClassAfterClass {
    @Test
    public void test01() throws IOException {
        //Amazaon sayfasına gidelim
        driver.get("https://www.amazon.com");
        //nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //arama sonucu resmini alalım
        WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu =aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntuleri/WE"+tarih+".jpeg"));


    }
}
