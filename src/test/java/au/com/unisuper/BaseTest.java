package au.com.unisuper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by att.jacobg on 11/08/2017.
 */
public class BaseTest {

//    public final String BROWSER_NAME = "FireFox";
    public final String BROWSER_NAME = "Chrome";

    protected static WebDriver driver = null;
    protected static WebDriverWait wait = null;

}
