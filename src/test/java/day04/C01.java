package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/ ");

       //2- arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//       3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);
//       4- Bulunan sonuc sayisini yazdiralim
        //<div class="a-section a-spacing-small a-spacing-top-small">
        // <span>1-24 of 230 results for</span><span> </span><span
        // class="a-color-state a-text-bold">"Samsung headphones"</span></div>
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("sonucYazisi.getText() = " + sonucYazisi.getText());
//       5- Ilk urunu tiklayalim
        List<WebElement> sonuclarListesi = driver.findElements(By.xpath("//img[@class='s-image']"));
        sonuclarListesi.get(0).click();
//       6- Sayfadaki tum basliklari yazdiralim*/
        for (int i = 0; i <7 ; i++) {
            List<WebElement> baslıklarListesi = driver.findElements(By.xpath("//h"+i));
            for (WebElement each: baslıklarListesi ) {
                System.out.println(each.getText());
            }
        }
        //7- Sayfayı kapatiniz:
        driver.close();



    }
}
