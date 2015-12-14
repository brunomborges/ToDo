package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.TaskPage;
import cucumber.api.java.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Bruno on 13/12/2015.
 */
public class ModalPage {
    private static FirefoxDriver driver;

    public ModalPage(FirefoxDriver driver){
        this.driver = driver;
    }

    public void setSubDescription(String description){
        driver.findElementById("new_sub_task").sendKeys(description +  Keys.RETURN);
    }

    public void setDueDate(String date){
        driver.findElementById("dueDate").sendKeys(date + Keys.RETURN);
    }

    public void modalOpened() {
        boolean result = driver.findElement(By.className("modal-title")).isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }

    public void setDone(int index){
        driver.findElements(By.xpath("//input[@ng-model='sub_task.completed']")).get(index).click();
    }

    public boolean getDone(int index)
    {
        String succeedColor = "rgba(223, 240, 216, 1)";
        String backgroundColor = driver.findElements(By.xpath("//tr[@ng-repeat='sub_task in task.sub_tasks']/td[descendant::input]")).get(index).getCssValue("background-color");
        return backgroundColor.equals(succeedColor);
    }
}
