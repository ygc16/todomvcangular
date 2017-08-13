package au.com.unisuper.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by att.jacobg on 9/08/2017.
 */
public class HomePage extends BasePage{

    String url = "http://todomvc.com";

    private WebElement angularJSLink;

    public void goHome() {
        driver.get(url);
    }

    public void clickAngularJSLink(){
        angularJSLink = wait.until( ExpectedConditions.elementToBeClickable( By.linkText("AngularJS") ) );
        angularJSLink.click();
    }

}
