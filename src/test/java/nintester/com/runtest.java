package nintester.com;
import Home.Basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class runtest {

    public void printF (){
        Basepage sayHi = new Basepage();
        sayHi.getHi();

    }

    public static void main(String[] args) {
        System.out.println("Hello this is new style");

        WebDriver driverCr = new ChromeDriver();
        driverCr.get("https://www.youtube.com/");

/* WebDriver driverFx = new FirefoxDriver();
        driverFx.get("https://www.youtube.com/");*/



    }
}
