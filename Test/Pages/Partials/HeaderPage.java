package Pages.Partials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
/**
 * Created by Bruno on 13/12/2015.
 */
public class HeaderPage {

        private static FirefoxDriver driver;


    public HeaderPage(FirefoxDriver driver)
    {
        this.driver = driver;
    }

    public void toDoLink(){
    driver.findElement(By.className("navbar-brand")).click();
}

    public void homeLink(){
        driver.findElementByLinkText("Home").click();
    }

    public void myTaskLink(){
        driver.findElementByLinkText("My Tasks").click();
    }

    public void signOut(){
        driver.findElementByLinkText("Sign out").click();
    }

    public void SignIn(){

        driver.findElementByLinkText("Sign In").click();
    }

    public void register(){
        driver.findElementByLinkText("Register").click();
    }

}

