package objectRepository;

import org.openqa.selenium.By;

public class HomepageOR {

    public static final By LOGO = By.xpath("//div[@id='logo']//a");

    public static final By CURRENCY_DROPDOWN = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    public static final By CURRENCY_USD = By.xpath("//button[@name='USD']");

    public static final By MY_ACCOUNT = By.xpath("//a[@title='My Account']");
    public static final By REGISTER = By.xpath("//a[text()='Register']");

    public static final By FIRSTNAME = By.id("input-firstname");
    public static final By LASTNAME = By.id("input-lastname");
    public static final By EMAIL = By.id("input-email");
    public static final By TELEPHONE = By.id("input-telephone");
    public static final By PASSWORD = By.id("input-password");
    public static final By CONFIRM_PASSWORD = By.id("input-confirm");
    public static final By PRIVACY_CHECKBOX = By.xpath("//input[@name='agree']");
    public static final By CONTINUE_BTN = By.xpath("//input[@value='Continue']");

    public static final By SUCCESS_MSG = By.xpath("//h1[text()='Your Account Has Been Created!']");

    public static final By SEARCH_BOX = By.name("search");
    public static final By SEARCH_BUTTON = By.xpath("//div[@id='search']//button");

    public static final By PRODUCT_NAME = By.xpath("//div[@class='caption']/h4/a");
    public static final By PRODUCT_PRICE = By.xpath("//p[@class='price']");

    public static final By HP_PRODUCT = By.xpath("//a[text()='HP LP3065']");
    public static final By ADD_TO_CART = By.id("button-cart");
    public static final By CHECKOUT = By.xpath("(//a[contains(@href,'checkout')])[6]");

    public static final By ORDER_SUCCESS = By.xpath("//h1[text()='Your order has been placed!']");
}
