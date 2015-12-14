package Steps;

        import Pages.LoginPage;
        import Pages.MainPage;
        import Pages.ModalPage;
        import Pages.TaskPage;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.firefox.FirefoxDriver;


        import java.util.concurrent.TimeUnit;

/**
 * Created by Bruno on 13/12/2015.
 */
public class SubTaskTest {

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
    public void openModal() {
        MainPage mainPage = new MainPage(driver);
        ModalPage modalPage = new ModalPage(driver);
        TaskPage taskPage = new TaskPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.Header.SignIn();
        loginPage.setEmail("brunomelgarejoborges@gmail.com");
        loginPage.setPassword("jbr2514201");
        loginPage.clickLoginButton();
        mainPage.Header.myTaskLink();
        taskPage.addTask("testOne");
        taskPage.addSubtask(0);
        modalPage.modalOpened();

    }
    @Test
    public void addTask() {
        MainPage mainPage = new MainPage(driver);
        ModalPage modalPage = new ModalPage(driver);
        TaskPage taskPage = new TaskPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.Header.SignIn();
        loginPage.setEmail("brunomelgarejoborges@gmail.com");
        loginPage.setPassword("jbr2514201");
        loginPage.clickLoginButton();
        mainPage.Header.myTaskLink();
        taskPage.addTask("testOne");
        taskPage.addSubtask(0);
        modalPage.setSubDescription("Total");
        modalPage.setDueDate("10/12/2015");
    }
    @Test
    public void setDone() {
        MainPage mainPage = new MainPage(driver);
        ModalPage modalPage = new ModalPage(driver);
        TaskPage taskPage = new TaskPage(driver);
        mainPage.open();
        LoginPage loginPage = new LoginPage(driver);
        mainPage.Header.SignIn();
        loginPage.setEmail("brunomelgarejoborges@gmail.com");
        loginPage.setPassword("jbr2514201");
        loginPage.clickLoginButton();
        mainPage.Header.myTaskLink();
        taskPage.addTask("testOne");
        taskPage.addSubtask(0);
        modalPage.setSubDescription("Total");
        modalPage.setDueDate("10/12/2015");
        modalPage.setDone(0);
        modalPage.getDone(0);


    }
}
