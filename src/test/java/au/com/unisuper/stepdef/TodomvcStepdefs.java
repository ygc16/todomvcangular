package au.com.unisuper.stepdef;

import au.com.unisuper.BaseTest;
import au.com.unisuper.pages.HomePage;
import au.com.unisuper.pages.TodoPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

/**
 * Created by att.jacobg on 11/08/2017.
 */
public class TodomvcStepdefs extends BaseTest {

    HomePage homeP = new HomePage();
    TodoPage todoP = new TodoPage();

    @Before
    public void beforeTest() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Given("^I navigate to todomvc.com$")
    public void iNavigateToTodomvccom() {
        homeP.goHome();
    }

    @When("^I click AngularJS link$")
    public void iClickAngularJSLink() throws Throwable {
        homeP.clickAngularJSLink();
    }

    @Then("^I am on AngularJS page$")
    public void iAmOnAngularJSPage() throws Throwable {
        String expectedTitle = "AngularJS • TodoMVC";
        wait.until(ExpectedConditions.titleContains("AngularJS • TodoMVC"));
        assertEquals( "Page Title", driver.getTitle(), expectedTitle );
    }

    @Given("^I navigate to AngularJS page$")
    public void iNavigateToAngularJSPage() throws Throwable {
        todoP.goTodo();
    }

    @When("^I add a To-do item (.*)$")
    public void iAddAToDoItem(String item) throws Throwable {
        todoP.addToDo(item);
    }

    @Then("^Item (.*) is added. Seq:([0-9]+)$")
    public void itemIsAdded(String item, int num) throws Throwable {
        assertEquals ( "Item is not added", item, todoP.getToDoText(num) );
    }

    @When("^update the content of (.*) To-do item to (.*)$")
    public void editTheContentOfAnExistingToDoItem(String textBefore, String textAfter) throws Throwable {
        todoP.updateToDo(textBefore, textAfter);
    }

    @Then("^Todo item (\\d+) has value (.*)$")
    public void todoItemHasValue(int num, String text) throws Throwable {
        assertEquals( "Todo text is wrong", text, todoP.getToDoText(num) );
    }


    @When("^I click the item (\\d+) done$")
    public void iClickTheItemDone(int num) throws Throwable {
        todoP.clickToDoCheck(num);
    }

    @Then("^Item (\\d+) is done$")
    public void itemIsDone(int num) throws Throwable {
        assertTrue("Item should be done, but it is not", todoP.isDone(num));
    }

    @Then("^Item (\\d+) is not done$")
    public void itemIsNotDone(int num) throws Throwable {
        assertFalse("Item should not be done, but it is", todoP.isDone(num));
    }

    @And("^I click all items done$")
    public void iClickAllItemsDone() throws Throwable {
        todoP.clickAllToDoCheck();
    }

    @And("^I click on completed filter$")
    public void iClickOnCompletedFilter() throws Throwable {
        todoP.filterCompleted();
    }

    @Then("^Todo (.*) is presented on the screen$")
    public void todoItemPresentedOnTheScreen(String text) throws Throwable {
        assertTrue( "The Item should be presented on the screen, but it is not", todoP.isPresented(text));
    }

    @Then("^Todo (.*) is not presented on the screen$")
    public void todoItemIsNotPresentedOnTheScreen(String text) throws Throwable {
        assertFalse("The Item should not be presented on the screen, but it is", todoP.isPresented(text));
    }

    @And("^I click remove item (\\d+)$")
    public void iClickCloseItem(int num) throws Throwable {
        todoP.deleteTodoItem(num);
    }

    @And("^I click Clear All Completed Button$")
    public void iClickClearAllCompletedButton() throws Throwable {
        todoP.deleteAllCompletedItems();
    }
}


