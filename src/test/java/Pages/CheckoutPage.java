package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public CheckoutPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Attributs

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]")
    private WebElement inputFullname;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")
    private WebElement inputAddressLine1;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Address Line 2 input field\"]")
    private WebElement inputAddressLine2;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"City* input field\"]")
    private WebElement inputCity;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"State/Region input field\"]")
    private WebElement inputState;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")
    private WebElement inputZip;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country* input field\"]")
    private WebElement inputCountry;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"To Payment button\"]")
    private WebElement toPaymentButton;


    //Methodes

    public void inputFullname() {
        inputFullname.sendKeys("Rebecca Winter");
    }
    public void inputAddressLine1() {
        inputAddressLine1.sendKeys("3 Rue de la Ville");
    }
    public void inputAddressLine2() {
        inputAddressLine2.sendKeys("Blalala");
    }
    public void inputCity() {
        inputCity.sendKeys("San Francisco");
    }
    public void inputState() {
        inputState.sendKeys("California");
    }
    public void inputZip() {
        inputZip.sendKeys("97890");
    }
    public void inputCountry() {
        inputCountry.sendKeys("United States");
    }
    public void toPaymentButton() {
        toPaymentButton.click();
    }
}
