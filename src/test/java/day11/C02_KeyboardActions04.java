package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

public class C02_KeyboardActions04 extends TestBase_BeforeClassAfterClass {
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        // 2- Yeni hesap olustur butonuna basalim
        WebElement account = driver.findElement
                (By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        account.click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement name = driver.findElement(By.xpath("//*[@name=\"firstname\"]"));
        Actions actions = new Actions(driver);
        name.sendKeys("ahhmet");// DİRECT actions.click(searchBox). devamında sendKeys() ile devam edilebilir
        actions.sendKeys(Keys.TAB).        // bir önceki class da olduğu gibi
                sendKeys("yılmaz").
                sendKeys(Keys.TAB).
                sendKeys("ahmetyılmaz@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("ahmetyılmaz@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("ahmetyılmaz12abAB.").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("1").
                sendKeys(Keys.TAB).
                sendKeys("JUN").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.LEFT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();


        // 4- Kaydol tusuna basalim
    }
}
