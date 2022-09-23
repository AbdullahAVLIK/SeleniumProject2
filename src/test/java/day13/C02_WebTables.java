package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeAfter;

import java.util.List;
//Bir class oluşturun : C02_WebTables
public class C02_WebTables extends TestBase_BeforeAfter {
    @Test
    public void test01() {
        //login( ) metodun oluşturun ve oturum açın.
        login();
        //table( ) metodu oluşturun
        table();
        //printRows( ) metodu oluşturun //tr
        printRows();
    }
    private void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidip giriş yapın;
        //Username : manager
        //Password : Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement username = driver.findElement(By.xpath("//*[@id='UserName']"));
        Actions actions = new Actions(driver);
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
    }
    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi:  "+sutunSayisi.indexOf(sutunSayisi));
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement headers = driver.findElement(By.xpath("//thead//tr"));
        System.out.println(headers.getText());
        WebElement allBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(allBody.getText());
        /*List<WebElement> allheaders =driver.findElements(By.xpath("//tbody//tr//td"));
        allheaders.stream().forEach(t-> System.out.print(t.getText()+"--*--"));*/
    }
    private void printRows() {
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi: "+rows.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        rows.stream().forEach(t -> System.out.println(t.getText()));
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(rows.get(3).getText());
    }


}
