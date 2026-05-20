package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonMethods;

/**
 * BaseActions is the reusable test helper library for UI automation.
 * Extend this class in your own test classes to inherit the most common
 * Selenium interaction methods with descriptive comments.
 *
 * Example:
 *   public class LoginTest extends BaseActions {
 *       @Test
 *       public void login() {
 *           WebDriver driver = // obtain driver from setup;
 *           launchURL(driver, "https://example.com");
 *           setText(driver, By.id("username"), "user1");
 *           click(driver, By.id("loginBtn"));
 *       }
 *   }
 *
 * Available helper methods:
 *   launchURL(WebDriver, String)
 *   objecLocater(WebDriver, By)
 *   WDWait(WebDriver, By)
 *   listObjecLocater(WebDriver, By)
 *   SelectChk(WebDriver, By)
 *   setText(WebDriver, By, String)
 *   setTextinDD(WebDriver, By, String)
 *   getText(WebDriver, By)
 *   SwitchWindow(WebDriver)
 *   closeCurrentWindow(WebDriver)
 *   switchToParentwindow(WebDriver)
 *   click(WebDriver, By)
 *   JSButtonClick(WebDriver, By)
 *   submitButton(WebDriver, By)
 *   selectValue(WebDriver, By, String)
 *   selectDDValue(WebDriver, By, String)
 *   setDropdownValue(WebDriver, By, String)
 *   isElementPresent(WebDriver, By)
 *   onMouseHover(WebDriver, By)
 *   onMouseHover_withoutClick(WebDriver, By)
 *   selectCheckBox(WebDriver, By)
 *   checkElementVisibility(WebDriver, By)
 *   currentDate()
 *   elementPresence(WebDriver, By)
 *   getAttribute(WebDriver, By, String)
 *   waitUntillElementClickable(WebDriver, By, java.time.Duration)
 *   waitUntillElementVisible(WebDriver, By, java.time.Duration)
 *   waitUntillVisibilityOfElement(WebDriver, By, java.time.Duration)
 *   getSelectedOption(WebDriver, By)
 *   pageDown()
 *   getColumnIndex(WebDriver, WebElement, String)
 *
 * If you want to add more reusable methods, update CommonMethods.java and
 * then add the method name to this list for discoverability.
 */
public class BaseActions extends CommonMethods {

    public BaseActions() {
        super();
    }
}

