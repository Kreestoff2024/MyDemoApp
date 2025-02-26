package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]")
    private WebElement loginUsername;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
    private WebElement loginPassword;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]")
    private WebElement loginButton;


    public void inputUsernameField() {
        loginUsername.sendKeys("bob@example.com");
    }
    public void inputPasswordField() {
        loginPassword.sendKeys("10203040");
    }
    public void clickLoginButton() {
        loginButton.click();
    }



}
