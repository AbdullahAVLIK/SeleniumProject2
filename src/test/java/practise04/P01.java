package practise04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase_BeforeClassAfterClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBase_BeforeClassAfterClass {
    @Test
    public void test01(){
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        // tüm hayvan emojilerine tıklayın

        //locaters:--->>>

        //div[@class='mdl-tabs__panel is-active']/div/img
        //div[@id='nature']/div/img
        //div[@class='mdl-tabs__panel is-active']//img
        //div[3]//img

        //foreach:
        List<WebElement>animals = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
//        for (WebElement each:animals) {
//            each.click();
//        }

        //lambda ile:
        animals.forEach(t -> t.click());

        // formu doldurun (dilediğinizi yazabilirsiniz)
        driver.switchTo().defaultContent();// önce iframden cıkmalıyız
        //11 tane dolduracağımız alanları liste attık web element olarak.
        List<WebElement> forms = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        //bu listi kullanarak her bir veb elementi kolayca listde bulunan web elemente gönderebileceğiz
        List<String>texts = new ArrayList<String>(Arrays.asList("bu","listi","kullanarak","her","bir","texte","bir ",
                "eleman ","göndere","biliyoruz","ok"));
        for (int i = 0; i <forms.size() ; i++) {
            forms.get(i).sendKeys(texts.get(i));
        }
        Actions actions = new Actions(driver);
        actions.click(forms.get(10));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        /*
         for (int i = 0; i < text.size() ; i++) {
            inputListesi.get(i).sendKeys(text.get(i));
        }
         */

        /*
        List<WebElement>metinList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>metin=new ArrayList<>(Arrays.asList("Türkiyenin","en","büyük","klübü","Galatasaray'ın",
        "harika","forveti","Icardi","Cok iyi degil mi?","",""));
         */

        /*
        driver.findElements(By.cssSelector("input[class=\"mdl-textfield__input\"]")).forEach(t->t.sendKeys(faker.name().name()));
         */

        // apply butonuna tıklayın
        //driver.findElement(By.cssSelector("button#send")).click();
    }
}
