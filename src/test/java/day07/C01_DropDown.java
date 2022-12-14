package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {
    //●Bir class oluşturun:DropDown
    //●https://the-internet.herokuapp.com/dropdown adresinegidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin veyazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin veyazdırın
    //4.Tüm dropdown değerleri(value)yazdırın
    //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //Falseyazdırın.
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://the-internet.herokuapp.com/dropdown adresinegidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void test1() throws InterruptedException {
        //<select id="dropdown">
        //    <option value="" disabled="disabled" selected="selected">Please select an option</option>
        //    <option value="1">Option 1</option>
        //    <option value="2">Option 2</option>
        //  </select>
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(ddm);
        options.selectByIndex(1);
        Thread.sleep(2000);
        options.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        options.selectByIndex(1);
        Thread.sleep(2000);
        options.selectByValue("2");
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
