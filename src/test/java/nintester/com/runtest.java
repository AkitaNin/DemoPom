package nintester.com;
import Home.BasePage;


public class runtest {

    public void printF (){
        BasePage sayHi = new BasePage();
        sayHi.getHi();

    }

    public static void main(String[] args) {
   /*     System.out.println("Hello this is new style");

        WebDriver driverCr = new ChromeDriver();
        driverCr.get("https://www.youtube.com/");
*/
/* WebDriver driverFx = new FirefoxDriver();
        driverFx.get("https://www.youtube.com/");*/

        //student
        Student st = new Student();

        st.getInfor();
        st.display();

    }
}
