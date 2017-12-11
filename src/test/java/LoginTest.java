import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    private ChromeDriver driver;

    // cuyc enq talis chrome driveri tex@, petq e tanq system property
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        //hajord qayl,chrome driver nor, browser@ bacelu hamar
        driver = new ChromeDriver();

    }
    //nor test enq sarqum URL kanchelu hamar
    @Test
    public void login() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/login");
        //run the test, the page should be opened.
        // log in enq linum
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // log in button@ push
        driver.findElement(By.cssSelector("#login button")).click();
        //messagen e cuyc talis

        Thread.sleep(1000); // mi varkyan sleep e linum minchev message@ ga, hetagayum kogtagorcenq "wait", vor@ aveli chisht e
        assertTrue( "Login was not succeed!",driver.findElement(By.cssSelector(".flash.success")).isDisplayed());

    }
    // should close the browser
    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
   }
}
