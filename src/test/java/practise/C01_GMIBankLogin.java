package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1) https://www.gmibank.com/ adresine gidiniz
        driver.get("https://www.gmibank.com/");
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        // 3) Username: Batch81, Password: Batch81+
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement signin = driver.findElement(By.xpath("(//span[text()='Sign in'])[3]"));
        username.sendKeys("Batch81");
        password.sendKeys("Batch81+");
        signin.click();
    }
}
