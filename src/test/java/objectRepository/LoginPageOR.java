package objectRepository;

import org.openqa.selenium.By;

public class LoginPageOR {
	public By email = By.id("input-email");
	public By password = By.id("input-password");
	public By signin = By.cssSelector("input[type='submit'][value='Login']");
}
 