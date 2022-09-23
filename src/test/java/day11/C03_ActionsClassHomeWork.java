package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

public class C03_ActionsClassHomeWork extends TestBase_BeforeClassAfterClass {
    @Test
    public void test01() {
        //Yeni Class olusturun ActionsClassHomeWork
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
}
