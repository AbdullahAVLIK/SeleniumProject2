package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IframeTest {
    //●Bir class olusturun:IframeTest
    //●https://the-internet.herokuapp.com/iframe adresinegidin.
    //●Bir metod olusturun:iframeTest
    //○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda
    //yazdirin.
    //○Text Box’a “Merhaba Dunya!”yazin.
    //○TextBox’in altinda bulunan “Elemental Selenium”
    // linkini textinin gorunur oldugunu dogrulayin ve konsoldayazdirin.
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.close();

    }

    @Test
    public void test1() throws InterruptedException {
        //●https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //○“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        //<h3>An iFrame containing the TinyMCE WYSIWYG Editor</h3>
        WebElement Iframe = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(Iframe.isDisplayed());
        System.out.println("Iframe.getText() = " + Iframe.getText());
        //○Text Box’a “Merhaba Dunya!”yazin.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr"));
        //frame geçiş yapmadan önce orayı id ile locate ediyoruz .
        driver.switchTo().frame(textBox);// sonrada buraya bu methodla gdiyoruz,
        Thread.sleep(2000);
        WebElement textBox1 = driver.findElement(By.xpath("//p"));
        textBox1.clear();
        Thread.sleep(2000);
        textBox1.sendKeys("Hello World");
        //○TextBox’in altinda bulunan “Elemental Selenium”
        // linkini textinin gorunur oldugunu dogrulayin ve konsoldayazdirin.
        driver.switchTo().defaultContent();// Iframe den cıkış yaptık. yoksa locate alamayız
        WebElement elementalSelenium = driver.findElement
        (By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println("seleniumYazısı.getText() = " + elementalSelenium.getText());
    }
}
