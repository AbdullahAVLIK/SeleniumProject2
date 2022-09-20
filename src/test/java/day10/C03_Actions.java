package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

public class C03_Actions extends TestBase_BeforeClassAfterClass {
    @Test
    public void test1() {
        //amazon sayfasina gidelim account menusunden create a list linkine tıklayalım
        driver.get("https://www.amazon.com");
        WebElement account = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(account).perform();
        WebElement  create =driver.findElement(By.xpath("//*[text()='Create a List']"));
        create.click();
    }
}
