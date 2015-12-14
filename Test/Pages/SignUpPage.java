package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Bruno on 13/12/2015.
 */
public class SignUpPage {
    private static FirefoxDriver driver;

    public SignUpPage(FirefoxDriver driver){
        this.driver = driver;
    }

    public void setName(String name){
        driver.findElementById("user_name").sendKeys(name);
    }

    public void setEmail(String email){
        driver.findElementById("user_email").sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElementById("user_password").sendKeys(password);
    }

    public void passwordConfirmation(String passwordConf){
        driver.findElementById("user_password_confirmation").sendKeys(passwordConf);
    }

    public void getErrorMessage() {
        boolean result = driver.findElement(By.className("alert-danger")).isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }
    public void clickSubmit(){
        driver.findElement(By.cssSelector("input[type = 'submit']")).click();
    }
}

