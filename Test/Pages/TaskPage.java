package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Bruno on 13/12/2015.
 */
public class TaskPage {

    private static FirefoxDriver driver;

    public  TaskPage(FirefoxDriver driver){
        this.driver = driver;
    }

    public void getUrl (String url){
        driver.get(url);
    }

    public void addTask(String description){
        driver.findElementById("new_task").sendKeys(description + Keys.RETURN);
    }

    public void doneTask(int index){
        driver.findElements(By.xpath("//input[@type='checkbox' and @ng-model='task.completed']")).get(index).click();
    }

    public boolean getDone(int index)
    {
        String succeedColor = "rgba(223, 240, 216, 1)";
        String backgroundColor = driver.findElements(By.xpath("//tr[@ng-repeat='task in tasks']/td")).get(index).getCssValue("background-color");
        return backgroundColor.equals(succeedColor);
    }

    public void addSubtask(int index) {
        driver.findElements(By.xpath("//button[contains(text(), 'Manage Subtasks')]")).get(index).click();
    }
    
}
