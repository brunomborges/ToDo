package Pages;
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
public class LoginPage {
        private static FirefoxDriver driver;

        public LoginPage(FirefoxDriver driver){
            this.driver = driver;

        }

        public void setEmail(String email){
            driver.findElementById("user_email").sendKeys(email);
        }

        public void setPassword(String password){
            driver.findElementById("user_password").sendKeys(password);
        }

        public void clickLoginButton(){
            driver.findElementByCssSelector("input[value = 'Sign in").click();
        }

    }
