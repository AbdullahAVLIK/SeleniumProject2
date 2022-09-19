package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_IframeTest02 {
    //●Bir class olusturun:IframeTest02
    //1)"http://demo.guru99.com/test/guru99home/"sitesine gidiniz
    //2)sayfadaki iframe sayısınıbulunuz.
    //3)ilk iframe'deki (Youtube) play butonunatıklayınız.
    //4)ilk iframe'den çıkıp ana sayfayadönünüz
    //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html)
    //tıklayınız

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
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        //1)"http://demo.guru99.com/test/guru99home/"sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2)sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeList);
        System.out.println(iframeList.size());
        //3)ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@width='560']")));
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        //4)ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5)ikinci iframe'deki (Jmeter Made Easy) linke(https://www.guru99.com/live-selenium-project.html) tıklayınız
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='a077aa5e']")));
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        Thread.sleep(2000);
    }
}
