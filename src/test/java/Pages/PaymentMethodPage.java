package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage {
    public PaymentMethodPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]")
    private WebElement inputNameField;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Card Number* input field\"]")
    private WebElement inputCardNumberField;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]")
    private WebElement inputExpirationDateField;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Security Code* input field\"]")
    private WebElement inputSecurityCodeField;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"My billing address is the same as my shipping address.\"]")
    private WebElement myBillingAddressBox;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Review Order\"]")
    private WebElement reviewOrderButton;

    public void inputNameField(){
        inputNameField.sendKeys("Rebecca Winter");
    }
    public void inputCardNumberField(){
        inputCardNumberField.sendKeys("3258 1265 7568 789");
    }
    public void inputExpirationDateField(){
        inputExpirationDateField.sendKeys("01/26");
    }
    public void inputSecurityCodeField(){
        inputSecurityCodeField.sendKeys("123");
    }
    public void reviewOrderButton(){
        reviewOrderButton.click();
    }
    public void clickMyBillingAddressBox(){
        myBillingAddressBox.click();
    }
}
