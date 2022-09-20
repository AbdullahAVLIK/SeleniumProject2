package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class C04_MouseActions1 extends TestBase_BeforeClassAfterClass {
    //1Yeni bir class olusturalim:MouseActions1
    //2https://the-internet.herokuapp.com/context_menu sitesine gidelim 3-Cizili alan uzerinde sag clickyapalim
    //4Alert’te cikan yazinin “You selected a context menu”oldugunu
    //testedelim.
    //5Tamam diyerek alert’ikapatalim
    //6Elemental Selenium linkinetiklayalim
    //7Acilan sayfada h1 taginda “Elemental Selenium” yazdigini testedelim
    @Test
    public void test1() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3-Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        //4-Alert’te cikan yazinin “You selected a context menu” oldugunu testedelim.
        Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu"));
        //5-Tamam diyerek alert’ikapatalim
        driver.switchTo().alert().accept();
        //6-Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[@target='_blank']")).click();
        //7Acilan sayfada h1 taginda “Elemental Selenium” yazdigini testedelim
        List<String> handleList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handleList.get(1));
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(h1.getText().equals("Elemental Selenium"));

    }
}
