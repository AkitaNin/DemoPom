package nintester.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class dabet_element_locator {
    WebDriver driver;

    @BeforeTest
    public void Setup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dabet.com/");
    }
    @Test
    public void login(){
            driver.findElement(By.xpath("//span[contains(text(), 'Đăng Nhập')]")).click();
            if (driver.findElement(By.xpath("//div[@class ='modal-auth']")).isDisplayed()){
                driver.findElement(By.xpath("//input[@placeholder ='Nhập tên đăng nhập']")).sendKeys("nbet001");
                driver.findElement(By.xpath("//input[@placeholder = 'Nhập từ 6 đến 32 ký tự']")).sendKeys("123456");
            }

            driver.findElement(By.xpath("//button[@type = 'submit']")).click();







           /* driver.findElement(By.xpath(""))
            driver.findElement(By.xpath(""))*/
        }



    }
