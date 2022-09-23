package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase_BeforeClassAfterClass;

import java.time.Duration;

public class C05_Odevler extends TestBase_BeforeClassAfterClass {
    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement box1 = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(box1).perform();
        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        //Popup mesajini yazdirin
        System.out.println("Popup mesaji = " + driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        WebElement box2= driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(box2).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold\" kutusunda cikan yazi = " + box2.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement box3 = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(box3).perform();
        driver.close();
    }

    @Test
    public void test02() {
        //“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("https://webdriveruniversity.com/IFrame/index.html");
        //“Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[@href='products.html']")).click();
        //“Cameras product”i tiklayin
        driver.findElement(By.xpath("//img[@id='camera-img']")).click();
        //Popup mesajini yazdirin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//b[text()='SPECIAL OFFER!']")));
        WebElement textBox = driver.findElement(By.xpath("//h4[@class='modal-title']"));
        System.out.println(textBox.getText());
        //“close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();
        //"https://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("https://webdriveruniversity.com/index.html"));
    }

    @Test
    public void test03() {
        //1."http://webdriveruniversity.com/" adresine gidin
        //2."Login Portal" a  kadar asagi inin
        //3."Login Portal" a tiklayin  4.Diger window'a gecin
        //5."username" ve  "password" kutularina deger yazdirin
        //6."login" butonuna basin
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin  8.Ok diyerek Popup'i kapatin
        //Ilk sayfaya geri donun
        //Ilk sayfaya donuldugunu test edin
    }
}
