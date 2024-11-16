package Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    // dabet
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Xpath login
    By BTN_LOGIN = By.xpath("//span[contains(text(), 'Đăng Nhập')]");
    By LOGIN_POPUP = By.xpath("//div[@class ='modal-auth']");
    By INPUT_USERNAME = By.xpath("//input[@placeholder ='Nhập tên đăng nhập']");
    By INPUT_PASSWORD = By.xpath("//input[@placeholder = 'Nhập từ 6 đến 32 ký tự']");
    By BTN_SUBMITLOGIN = By.xpath("//button[@type = 'submit']");
    By BTN_LOGOUT = By.xpath("//span[contains(text(), 'Đăng xuất')]");
    By LOGOUT_POPUP = By.xpath("//div[contains(text(),'Bạn muốn thoát tài khoản?')]");
    By BTN_SUBMITLOGOUT = By.xpath("//button[contains(text(),'Đăng xuất')]");

    //Xpath Register
    By BTN_REGISTER = By.xpath("//a[contains(text(), 'Đăng Ký')] ");
    By INPUT_USERNAME_NEW = By.xpath("//input[@placeholder='Tên đăng nhập từ 6 đến 29 ký tự']");
    By INPUT_PASSWORD_NEW = By.xpath("//input[@placeholder='Nhập từ 6 đến 32 ký tự']");
    By INPUT_PHONENUMBER_NEW = By.xpath("//input[@placeholder='Nhập số điện thoại']");
    By BTN_SUBMIT_REGISTER = By.xpath("//button[@type = 'submit']");

    //click btn login
    public void clickBtnlogin (){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Thời gian chờ tối đa là 10 giây
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement btnlogin = wait.until(ExpectedConditions.visibilityOfElementLocated(BTN_LOGIN)); // Chờ phần tử hiển thị
        btnlogin.click();
    }

    //click btn submit
    public void clickBtnSMlogin (){
        driver.findElement(BTN_SUBMITLOGIN).click();
    }

    //click btn logout
    public void clickBtnlogout (){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement btnlogout = wait.until(ExpectedConditions.visibilityOfElementLocated(BTN_LOGOUT));
        btnlogout.click();
    }

    //click btn submit logout
    public void clickBtnSMlogout (){
        driver.findElement(BTN_SUBMITLOGOUT).click();
    }

    //Check login popup is displayed
    public boolean isLoginPopupDisplayed() {
        try {
            // Kiểm tra xem phần tử popup có hiển thị hay không
            return driver.findElement(LOGIN_POPUP).isDisplayed();
        } catch (Exception e) {
            // Nếu phần tử không tìm thấy (tức là popup chưa xuất hiện), trả về false
            return false;
        }
    }

    //Enter username/password when login-popup is true
    public void enterUserPassIfPopupIsDisplay (String username, String password){
        if(isLoginPopupDisplayed()){
            enterUsername(username);
            enterPassword(password);
        }
        else {
            System.out.println("FAILED");
        }
    }

    //Check logout popup is displayed
    public boolean isLogoutPopupDisplayed() {
        try {
            // Kiểm tra xem phần tử popup có hiển thị hay không
            return driver.findElement(LOGOUT_POPUP).isDisplayed();
        } catch (Exception e) {
            // Nếu phần tử không tìm thấy (tức là popup chưa xuất hiện), trả về false
            return false;
        }
    }

    //click btn LOGOUT when logoutpopup is true
    public void logoutIfLogoutPopupIsDisplayed (){
        if(isLogoutPopupDisplayed()){
            clickBtnSMlogout();
        }
        else {
            System.out.println("FAILED");
        }
    }

    //enter username
    public void enterUsername(String username){
        driver.findElement(INPUT_USERNAME).sendKeys(username);
    }

    //enter password
    public void enterPassword(String password){
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
    }
}
