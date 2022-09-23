package day11;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClassAfterClass;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C05_KeyboardActions02 extends TestBase_BeforeClassAfterClass {
    @Test
    @Ignore
    public void test01() {
        //Bir Class olusturalim KeyboardActions2
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        //videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        //videoyu calistirdiginizi test edin
        WebElement fullscreen_Button = driver.findElement
                (By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        Assert.assertTrue(fullscreen_Button.isDisplayed());
    }



    @Test
    @Ignore
    public void test02() {
        // amazon gidin
        driver.get("https://www.amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement allBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(allBox);
        //allBox.click();
        List<WebElement> optionsList = options.getOptions();
        for (WebElement each : optionsList) {
            System.out.println(each.getText());
        }
        //dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println("dropdown menu eleman sayisi :" + optionsList.size());
        int expectedSayi = 40;
        int actualSayi = optionsList.size();
        Assert.assertFalse("listede 28 eleman var,40 olmadığını test ediyorum",
                expectedSayi == actualSayi);

        //dropdown menuden elektronik bölümü seçin

        // 1. Yontem:
        // options.selectByValue("search-alias=electronics-intl-ship");
        // 2. Yontem:
        options.selectByIndex(10);
        // 3.Yontem:
        //options.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iphone" + Keys.ENTER);
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisi = driver.findElement
                (By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println("sonucYazisi.getText() = " + sonucYazisi.getText());
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));
        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement urun1 = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        WebElement urun2 = driver.findElement(with(By.tagName("img")).toRightOf(urun1));
        urun2.click();
        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String urun2Title = driver.getTitle();
        // WebElement urun2Price = driver.findElement
        // (By.xpath("'//div[@class='flex flex-col'])[2]"));
        // String urun2PriceS =urun2Price.getText();
        System.out.println(urun2Title);
        //System.out.println(urun2PriceS);
    }

        @Test
        public void test03() {

            //yeni bir sekme açarak amazon anasayfaya gidin
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.amazon.com.tr");
            //dropdown’dan bebek bölümüne secin
            //bebek puset aratıp bulundan sonuç sayısını yazdırın
            //sonuç yazsının puset içerdiğini test edin
            //5-üçüncü ürüne relative locater kullanarak tıklayin
            //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
            // Test 4
            //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

        }


}
