package Steps;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.TaskPage;
import cucumber.api.java.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bruno on 13/12/2015.
 */
public class TaskPageTest {
    public FirefoxDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void addTask() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        TaskPage taskPage = new TaskPage(driver);

        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.Header.SignIn();
        loginPage.setEmail("brunomelgarejoborges@gmail.com");
        loginPage.setPassword("jbr2514201");
        loginPage.clickLoginButton();

        mainPage.Header.myTaskLink();
        taskPage.addTask("testOne");
        taskPage.doneTask(0);
        Assert.assertEquals(true, taskPage.getDone(0));
    }
}
