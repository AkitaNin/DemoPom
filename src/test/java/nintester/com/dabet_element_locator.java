package nintester.com;

import Home.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class dabet_element_locator {
    //private static final Logger log = LoggerFactory.getLogger(dabet_element_locator.class);
    private static final Logger log = LoggerFactory.getLogger(dabet_element_locator.class);
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void Setup () {
        log.info("Setting up the WebDriver and opening the website...");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("https://dabet.com/");
        log.info("Setup completed.");
    }

    @Test
    public void login_logout() {
        loginPage.clickBtnlogin();
        loginPage.enterUserPassIfPopupIsDisplay("nbet001","123456");
        loginPage.clickBtnSMlogin();
        loginPage.clickBtnlogout();
        loginPage.logoutIfLogoutPopupIsDisplayed();
    }

    @Test
    public  void register_new(){

    }

    @Test
    public void list_gamename(){
        loginPage.scrollUntilElement(By.xpath("//span[contains(text(), 'LIVE ')]"));
        loginPage.listAllTxtCard();
        loginPage.listAllTxtSport();
    }

}
