package nintester.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class nbet {
    WebDriver driver;

    @BeforeTest
    public void Setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nbet.com/");
    }

    @Test
    public void login(){
        //Click đăng nhập
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/form/button"));
        btnLogin.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement btnLoginAgen = driver.findElement(By.xpath("//*[@id=\"login-required___BV_modal_body_\"]/div/div[2]/button/div"));
        btnLoginAgen.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //điền user/pass
        //WebElement username = driver.findElement(By.name("username"));
        WebElement username = driver.findElement(By.xpath("//*[@id=\"modalLogin___BV_modal_body_\"]/div/div[3]/div[1]/div/input"));
        username.sendKeys("goldnbet01");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //WebElement password = driver.findElement(By.name("password"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"modalLogin___BV_modal_body_\"]/div/div[3]/div[2]/div/input"));

        password.sendKeys("123456");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //click submit
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"modalLogin___BV_modal_body_\"]/div/div[3]/button/div"));
        submit.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello");
    }


}
