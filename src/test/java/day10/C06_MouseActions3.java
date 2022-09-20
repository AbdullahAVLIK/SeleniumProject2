package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

public class C06_MouseActions3 extends TestBase_BeforeClassAfterClass {
    @Test
    public void test1() {
        //Yeni bir class olusturalim:MouseActions3
        //1- https://www.amazon.com/adresine gidelim
        driver.get("https://www.amazon.com");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirelim
        WebElement account = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(account).perform();
        //3“Create a list” butonuna basalim
        WebElement  create =driver.findElement(By.xpath("//*[text()='Create a List']"));
        create.click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu testedelim
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='heading']")).getText().equals("Your Lists"));
    }
}
