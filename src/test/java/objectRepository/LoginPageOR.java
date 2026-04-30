package objectRepository;

import org.openqa.selenium.By;

public class LoginPageOR {
	public By email =  By.xpath("//input[@id='name']");
	public By password= By.xpath("//input[@id='email']");
	public By EnterPhone = By.xpath("//input[@id='phone' and @placeholder='Enter Phone']");
	public By signin = By.xpath("//button[@type='submit']");
	
}
 