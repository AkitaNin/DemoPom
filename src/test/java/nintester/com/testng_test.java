package nintester.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class testng_test {

    WebDriver driver;
    @BeforeTest
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ano.trade/");
    }
    @Test
    public void Testcase1_inputFAQ(){
        System.out.println("KÍ ZÔ ĐẦU CÁ HÚ");

    }
    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("FINISH");
    }



    /*@Test
    public void test02(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        driver.quit();
    }*/
}
