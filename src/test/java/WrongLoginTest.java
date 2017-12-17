import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class WrongLoginTest {
    private ChromeDriver driver;
    //private LoginPage wrongLoginPage;

    @BeforeMethod
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void loginFail() throws InstantiationException{
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("1111");
        driver.findElement (By.id("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("#login button")).click();
        assertTrue(driver.findElement(By.cssSelector(".flash.error")).isDisplayed());
    }
}
