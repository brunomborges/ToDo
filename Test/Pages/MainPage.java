package Pages;
import Pages.Partials.HeaderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


/**
 * Created by Bruno on 13/12/2015.
 */
public class MainPage {
    private static FirefoxDriver driver;
    private static String url = "http://qa-test.avenuecode.com/";
    public HeaderPage Header;

    public  MainPage(FirefoxDriver driver){
        this.driver = driver;
        this.Header = new HeaderPage(driver);
    }

    public void open(){
        driver.get(url);
    }

    public void signUp(){
        driver.findElementByLinkText("Sign Up").click();
    }

    public void sucsessMessage(){
        boolean result = driver.findElement(By.className("alert-info")).isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }

}
