package Steps;

import Pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bruno on 13/12/2015.
 */
public class ToDoSteps {
    public FirefoxDriver driver;


    @Given("^I am in the home page$")
    public void I_am_in_the_home_page() throws Throwable {
        driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Given("^I have clicked in the Sign Up button$")
    public void iHaveClickedInTheSignUpButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signUp();
        //throw new PendingException();
    }

    @And("^I have entered \"([^\"]*)\" as a name$")
    public void iHaveEnteredAsAName(String name) {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setName(name);
    }

    @And("^I have entered a valid email address$")
    public void iHaveEnteredAValidEmailAddress() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setEmail("teste1" + System.currentTimeMillis() + "@gmail.com");
        //throw new PendingException();
    }

    @And("^I have entered \"([^\"]*)\" as a password$")
    public void iHaveEnteredAsAPassword(String validPassword) {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.setPassword(validPassword);
        //throw new PendingException();
    }

    @And("^I have entered \"([^\"]*)\" as a password confirmation$")
    public void iHaveEnteredAsAPasswordConfirmation(String validPasswordConf){
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.passwordConfirmation(validPasswordConf);
    }

    @When("^I press the Sign Up button$")
    public void iPressTheSignUpButton() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSubmit();
    }

    @Then("^I should go to the main page with the succsess message$")
    public void iShouldGoToTheMainPageWithTheSuccsessMessage()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.sucsessMessage();
    }
    @Given("^I have clicked in the Sign In button$")
    public void iHaveClickedInTheSignInButton(){
       MainPage mainPage = new MainPage(driver);
        mainPage.Header.SignIn();

    }

    @And("^I have entered \"([^\"]*)\" as a valid email address$")
    public void iHaveEnteredAsAValidEmailAddress(String email){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(email);

    }

    @And("^I have entered \"([^\"]*)\" as a valid password$")
    public void iHaveEnteredAsAValidPassword(String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setPassword(password);

    }

    @When("^I click the Sign In button$")
    public void iClickTheSignInButton(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Given("^I click the My Tasks button$")
    public void iClickTheMyTasksButton(){
       MainPage mainPage = new MainPage(driver);
        mainPage.Header.myTaskLink();
    }

    @When("^I type \"([^\"]*)\" in the task description field and press the add button$")
    public void iTypeInTheTaskDescriptionFieldAndPressTheAddButton(String description){
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTask(description);
    }

    @And("^I click in the checkbox Done$")
    public void iClickInTheCheckboxDone(){
       TaskPage taskPage = new TaskPage(driver);
        taskPage.doneTask(0);
    }

    @Then("^the background color of the task, should be green$")
    public void theBackgroundColorOfTheTaskShouldBeGreen() throws Throwable {
        TaskPage taskPage = new TaskPage(driver);
        taskPage.getDone(0);
    }

    @Given("^I am logged in the main page$")
    public void iAmLoggedInTheMainPage() {
        driver = new FirefoxDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        LoginPage loginPage = new LoginPage(driver);
        mainPage.Header.SignIn();
        loginPage.setEmail("brunomelgarejoborges@gmail.com");
        loginPage.setPassword("jbr2514201");
        loginPage.clickLoginButton();

    }

    @Then("^I should stay in the same page with the error message$")
    public void iShouldStayInTheSamePageWithTheErrorMessage() {
        SignUpPage signupPage = new SignUpPage(driver);
        signupPage.getErrorMessage();
    }

    @And("^I click in the subtasks button$")
    public void iClickInTheSubtasksButton(){
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addSubtask(0);
    }


    @Then("^The subtask modal should open correctly$")
    public void theSubtaskModalShouldOpenCorrectly(){
        ModalPage modalPage = new ModalPage(driver);
        modalPage.modalOpened();
    }

    @And("^I add \"([^\"]*)\" at the subtask description$")
    public void iAddAtTheSubtaskDescription(String subDescription){
        ModalPage modalPage = new ModalPage(driver);
        modalPage.setSubDescription(subDescription);
    }

    @And("^I add \"([^\"]*)\" as a Date$")
    public void iAddAsADate(String date){
        ModalPage modalPage = new ModalPage(driver);
        modalPage.setDueDate(date);
    }

    @And("^I click in the checkbox$")
    public void iClickInTheCheckbox(){
        ModalPage modalPage = new ModalPage(driver);
        modalPage.setDone(0);
    }

    @Then("^the background color of the subtask, should be green$")
    public void theBackgroundColorOfTheSubtaskShouldBeGreen(){
        ModalPage modalPage = new ModalPage(driver);
        modalPage.getDone(0);
    }
}