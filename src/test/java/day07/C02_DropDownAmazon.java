package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownAmazon {
    //●Bir class oluşturun:C3_DropDownAmazon
    //●https://www.amazon.com/ adresinegidin.
    //-Test1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
    //oldugunu testedin
    //-Test2
    //1.Kategori menusunden Books seceneginisecin
    //2.Arama kutusuna Java yazin vearatin
    //3.Bulunan sonuc sayisiniyazdirin
    //4.Sonucun Java kelimesini icerdigini testedin
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://www.amazon.com/ adresinegidin.
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu testedin
        ////div[@id='nav-search-dropdown-card']
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println("drops.size() = " + drops.size());
        for(WebElement each: drops ){
            System.out.println(each.getText());
        }
        int dropListesi =drops.size();
        int expectedSayi = 45;
        Assert.assertFalse("dropSayisi Testi",expectedSayi==dropListesi);

    }
    @Test
    public void test2(){
        //-Test2
        //1.Kategori menusunden Books secenegini secin
        WebElement all = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options =new Select(all);
        options.selectByVisibleText("Books");
        //2.Arama kutusuna Java yazin ve aratin
        WebElement searchDropdownBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchDropdownBox.sendKeys("java"+ Keys.ENTER);
        //3.Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());
        //4.Sonucun Java kelimesini icerdigini testedin
        String expectedSonuc = "java";
        String actualSonuc =sonucSayisi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}
