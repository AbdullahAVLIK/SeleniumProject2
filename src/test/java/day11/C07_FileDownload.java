package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileDownload extends TestBase_BeforeClassAfterClass {
    //Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //Iki tane metod oluşturun : isExist( ) ve downloadTest( )


    @Test
    public void downloadTest() {
        //downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //test.txt dosyasını indirelim
        //*[@id="content"]/div/a[46]
        WebElement text = driver.findElement(By.xpath("//a[text()='text.txt']"));
        text.click();
    }

    @Test
    public void isExist() {
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu ="C:\\Users\\ABDULLAH\\Downloads\\text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        //indirildiğini konsolda gösterin;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));

    }



}
