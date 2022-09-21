package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

import static utilities.TestBase_BeforeClassAfterClass.driver;

public class C01_KeyboardActions01 extends TestBase_BeforeClassAfterClass {
    @Test
    public void test1() {
        //Bir Class olusturalim KeyboardActions1
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin
        Actions actions = new Actions(driver);
        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        actions.click(searchBox).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT).
                sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").
                sendKeys("1").sendKeys(Keys.ENTER).perform();

        // ve Enter’a basarak arama  yaptirin aramanin gerceklestigini test edin
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(result.getText().contains("samsung A71"));

    }
}
