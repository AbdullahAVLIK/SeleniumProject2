package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

public class C03_WebTables extends TestBase_BeforeAfter {
    @Test
    public void test01() {
        //
        //Bir onceki class'taki adrese gidelim
        //login() methodunu kullanarak sayfaya giris yapalim
        //input olarak verilen satir ve sutun sayisina sahip
        //cell'deki texti yazdiralim.
        //
        //int satir = 3;
        //int sutun = 4;
        //
        //
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement username = driver.findElement(By.xpath("//*[@id='UserName']"));
        Actions actions = new Actions(driver);
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        int satir =3;
        int sutun =4;
        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(arananCell.getText());
    }
}
