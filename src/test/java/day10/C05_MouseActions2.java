package day10;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

public class C05_MouseActions2 extends TestBase_BeforeClassAfterClass {
    @Test
    public void test1() {
       //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresinegidelim
        driver.get("https://demoqa.com/droppable");
        //2“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dragHere= driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dragHere).perform();
        //3“Drop here” yazisi yerine “Dropped!” oldugunu testedin
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Dropped!']")).getText(),"Dropped!");

    }
}
