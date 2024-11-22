package nintester.com;

import Home.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;


public class dabet_element_locator {
    //private static final Logger log = LoggerFactory.getLogger(dabet_element_locator.class);
    //private static final Logger log = LoggerFactory.getLogger(dabet_element_locator.class);
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void Setup () {
        //log.info("Setting up the WebDriver and opening the website...");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get("https://dabet.com/");
        //log.info("Setup completed.");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void login_logout() {
        homePage.clickBtnLogin();
        homePage.enterUserPassIfPopupIsDisplay("nbet001","123456");
        homePage.clickBtnSmLogin();
        homePage.clickBtnLogout();
        homePage.logoutIfLogoutPopupIsDisplayed();
    }

    @Test
    public  void register_new() throws InterruptedException {
        homePage.clickBtnRegister();
        Thread.sleep(3000);
        homePage.inputDataFake();
        homePage.clickBtnLogout();
        homePage.logoutIfLogoutPopupIsDisplayed();
        Thread.sleep(2000);
        homePage.loginAgainWithNewAccount();
    }

    @Test
    public void list_gamename(){
        homePage.scrollUntilElement(By.xpath("//span[contains(text(), 'LIVE ')]"));
        homePage.listAllTxtCard();
        homePage.listAllTxtSport();
    }

}
