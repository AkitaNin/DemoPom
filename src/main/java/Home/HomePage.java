package Home;

import D4.DataFaker;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static D4.DataFaker.parseJsonFileToJsonObject;

public class HomePage {
    // dabet
    WebDriver driver;
    public HomePage(WebDriver driver){
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
    By REGISTER_POPUP = By.xpath("//div[contains(text(), 'Đăng Ký Thành Viên')]");

    //Xpath mainpage
    By ROW_SPORTGAME = By.xpath("//span[contains(text(), 'THỂ THAO ')]");
    By ROW_CARDGAME = By.xpath("//span[contains(text(), 'GAME BÀI ')]");
    By ROW_LIVEGAME = By.xpath("//span[contains(text(), 'LIVE ')]");


    //click btn login
    public void clickBtnLogin (){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Thời gian chờ tối đa là 10 giây
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement btnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(BTN_LOGIN)); // Chờ phần tử hiển thị
        btnLogin.click();
    }

    //click btn submit
    public void clickBtnSmLogin(){
        if(driver.findElement(BTN_SUBMITLOGIN).isEnabled()) {
            driver.findElement(BTN_SUBMITLOGIN).click();
        }
    }

    //click btn logout
    public void clickBtnLogout (){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement btnLogout = wait.until(ExpectedConditions.visibilityOfElementLocated(BTN_LOGOUT));
        btnLogout.click();
    }

    //click btn submit logout
    public void clickBtnSmLogout (){
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
            clickBtnSmLogout();
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

    //scrolling
    public void scrollUntilElement (By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element =  driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(element.getText());
    }

    public void listAllTxtCard(){
       // List<WebElement> cardNames = driver.findElements(By.xpath("//div[@class='container']//div[@class='col col-card-game']//div[@class='card-game-item__name']/span"));
        List<WebElement> cardNames = driver.findElements(By.xpath("//div[@class='card-game-item__name']/span"));
        for (WebElement cardName : cardNames) {
            System.out.println("Tên: " + cardName.getText());
        }
    }

    public void listAllTxtSport(){
        List<WebElement> sportNames = driver.findElements(By.xpath("//div[@class='sport-title-container']//div[@class='title']"));
        for (WebElement sportName : sportNames) {
            System.out.println("Tên: " + sportName.getText());
        }
    }

    //Register thêm thành viên popup
    public void
    enter_newusername (String username){
        driver.findElement(INPUT_USERNAME_NEW).sendKeys(username);
    }

    public void enter_newpassword (String password){
        driver.findElement(INPUT_PASSWORD_NEW).sendKeys(password);
    }

    public void enter_phoneNumber (String phoneNumber){
        driver.findElement(INPUT_PHONENUMBER_NEW).sendKeys(phoneNumber);
    }

    public void clickBtnRegister (){
        driver.findElement(BTN_REGISTER).click();
    }

    public void clickBtnSubmitRegister (){
        if(driver.findElement(BTN_SUBMIT_REGISTER).isEnabled()){
            driver.findElement(BTN_SUBMIT_REGISTER).click();
        }
    }

    public boolean isRegisterPopupisDisplay() {
        try {
            // Kiểm tra xem phần tử popup có hiển thị hay không
            return driver.findElement(REGISTER_POPUP).isDisplayed();
        } catch (Exception e) {
            // Nếu phần tử không tìm thấy (tức là popup chưa xuất hiện), trả về false
            return false;
        }
    }
    //Test chuc nang cua dang ky xem truyen du lieu ok ko
    public void inPutTest(){
            enter_newusername("username");
            enter_newpassword("taco1345");
            enter_phoneNumber("2141252152151");
            //clickBtnSubmitRegister();
    }

    public void inputDataFake(){
        if (isRegisterPopupisDisplay()){
            DataFaker dataFaker = new DataFaker();
            String filePath = "src/test/test-data/datakafer.json";
            dataFaker.generateUserData(filePath);

            try {
                JSONObject userData = parseJsonFileToJsonObject(filePath);
                String username = (String) userData.get("username");
                String password = (String) userData.get("password");
                String phoneNumber = (String) userData.get("phoneNumber");

                //Điền các thông tin đã tạo và click submit
                enter_newusername(username);
                enter_newpassword(password);
                enter_phoneNumber(phoneNumber);
                clickBtnSubmitRegister();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void loginAgainWithNewAccount(){
        String filePath = "src/test/test-data/datakafer.json";
        try {
        JSONObject getData = parseJsonFileToJsonObject(filePath);
        String username = (String) getData.get("username");
        String password = (String) getData.get("password");
        //Điền các thông tin đã tạo và click submit
         clickBtnLogin();
         enterUserPassIfPopupIsDisplay(username,password);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        clickBtnSmLogin();
    }

}