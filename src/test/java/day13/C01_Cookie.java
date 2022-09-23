package day13;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase_BeforeAfter;

import java.util.Set;

public class C01_Cookie extends TestBase_BeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //-tum cookie’leri listeleyin
        Set<Cookie> allCookies = driver.manage().getCookies();
        //System.out.println(allCookies);
       /* int sayac = 1;
        for (Cookie each : allCookies) {
            System.out.println(sayac + ".ci Cookie");
            System.out.print(each.getName() + " ,");
            System.out.print(each.getValue());
            System.out.println();
            sayac++;
        }*/
        //stream ile;
        //allCookies.stream().forEach(t -> System.out.println("name : " + t.getName() + " value :" + t.getValue()));
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Thread.sleep(2000);
        Assert.assertTrue(allCookies.size() > 5);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w : allCookies) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
            }
        }
        allCookies.stream().
                filter(t -> t.getName().
                equals("i18n-prefs")).
                forEach(t -> Assert.assertEquals("USD", t.getValue()));
        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        for (Cookie w : allCookies) {
            if (w.getName().equals("en sevdigim cookie")) {
                Assert.assertEquals("cikolatali", w.getValue());
            }
        }
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        Cookie cookie1 = new Cookie("skin","noskin");
        driver.manage().deleteCookie(cookie1);
        Set<Cookie> allCookies1 = driver.manage().getCookies();
        allCookies1.stream().forEach(t -> System.out.println("name : " + t.getName() + " value :" + t.getValue()));
        Assert.assertFalse(allCookies1.contains("skin"));
        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Set<Cookie> allCookies2 = driver.manage().getCookies();
        Assert.assertTrue(allCookies2.isEmpty());

    }
}
