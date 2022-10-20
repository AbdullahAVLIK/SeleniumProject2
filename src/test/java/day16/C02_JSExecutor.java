package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeClassAfterClass;

public class C02_JSExecutor extends TestBase_BeforeClassAfterClass {

   /* js.executeScript("arguments[0].scrollIntoView(true);", auto.downloadInvoiceButton);
try {
     driver.findElement(By.linkText("Scans")).click();
  } catch (Exception e) {
     JavascriptExecutor executor = (JavascriptExecutor) driver;
     executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Scans")));
  }*/



    @Test
    public void test01() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Asagidaki carreers butonunu gorunceye kadar js ile scroll yapalim
        WebElement carreers = driver.findElement(By.xpath("//a[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carreers);
        //Carreers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",carreers);

    }
    //1.Adim : JavascriptExecutor kullanmak icin ilk adim olarak driver’imizi JavascriptExecutor’a cast edelim
    //1-JavascriptExecutor jse=(JavascriptExecutor)driver;
    //
    //2.Adim : Kullanacagimiz WebElement’I locate edelim
    // 2-WebElement xElement=driver.findElement(//Locate)
    //
    // 3.Adim : Js driver ile executeScript method’unu calistiralim, icine parameter olarak ilgili script ve webelemnt’I yazalim
    //3-jse.executeScript("arguments[0].scrollIntoView(true);",xElement)
    //
    //4.Adim : xElement elementine click yapmak icin
    //4-jse.executeScript("arguments[0].click();",xElement)
    // */
}
