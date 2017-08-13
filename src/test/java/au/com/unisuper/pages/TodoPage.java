package au.com.unisuper.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by att.jacobg on 9/08/2017.
 */
public class TodoPage  extends BasePage{


    String pageUrl = "http://todomvc.com/examples/angularjs/#/";

    public void goTodo() {
        driver.get(pageUrl);
    }

    public void addToDo(String text){
        WebElement toDoElem = wait.until( ExpectedConditions.visibilityOfElementLocated( By.id("new-todo") ) );
        toDoElem.sendKeys(text);
        toDoElem.sendKeys(Keys.RETURN);
    }

    public void updateToDo(String textBefore, String textAfter) throws Exception{
        WebElement toDoElem = getToDoByText( textBefore );

        Actions action = new Actions(driver);
        action.moveToElement(toDoElem).perform();
        action.doubleClick().perform();
        WebElement toDoElemUpd = driver.findElement(By.xpath("//input[@ ng-model='todo.title']"));
        toDoElemUpd.clear();
        toDoElemUpd.sendKeys(textAfter);
        toDoElemUpd.sendKeys(Keys.RETURN);
    }

    public String getToDoText( int num){
        WebElement toDoElem = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id='todo-list']/li["+num+"]/div/label") ) );
        return toDoElem.getText();
    }

    public WebElement getToDoByText( String text){
        System.out.print("TEXT:"+text);
        WebElement toDoElem = wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id='todo-list']//li/div/label[text()='"+text+"']") ) );
        return toDoElem;
    }

    public void clickToDoCheck(int num){
        WebElement toDoElem = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id='todo-list']/li["+num+"]/div/input") ) );
        toDoElem.click();
    }

    public void clickAllToDoCheck(){
        WebElement toDoElem = wait.until( ExpectedConditions.elementToBeClickable( By.id("toggle-all") ) );
        toDoElem.click();
    }

    public boolean isDone(int num){
        WebElement toDoElem = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id='todo-list']/li["+num+"]") ) );
        return toDoElem.getAttribute("class").equals( "ng-scope completed" );
    }

    public void filterCompleted(){
        wait.until( ExpectedConditions.elementToBeClickable( By.linkText("Completed") ) ).click();
    }

    public boolean isPresented(String text){

        try {
            driver.findElement(By.xpath("//*[@id='todo-list']//li/div/label[text()='"+text+"']") );
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public void deleteTodoItem(int num){
        WebElement toDoElem = wait.until( ExpectedConditions.elementToBeClickable( By.xpath("//*[@id='todo-list']/li["+num+"]") ) );
        Actions action = new Actions(driver);
        action.moveToElement(toDoElem).perform();
        driver.findElement(By.xpath("//*[@id='todo-list']/li["+num+"]/div/button")).click();
    }

    public void deleteAllCompletedItems(){
        wait.until( ExpectedConditions.elementToBeClickable( By.id("clear-completed") ) ).click();
    }

}
