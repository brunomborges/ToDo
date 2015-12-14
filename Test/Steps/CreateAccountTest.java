package Steps;

import Pages.MainPage;
import Pages.SignUpPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bruno on 13/12/2015.
 */
public class CreateAccountTest {
    public FirefoxDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://drivers//chromedriver.exe");

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void createAccount() {
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage  = new SignUpPage(driver);

        mainPage.open();
        mainPage.signUp();
        signUpPage.setName("Bruno");
        signUpPage.setEmail("teste1" + System.currentTimeMillis() + "@gmail.com");
        signUpPage.setPassword("12345678");
        signUpPage.passwordConfirmation("12345678");
        signUpPage.clickSubmit();
        mainPage.sucsessMessage();
    }
}
