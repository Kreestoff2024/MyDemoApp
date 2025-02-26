package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
    public MyCartPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //attributs
    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]")
    private WebElement checkoutButton;

    //@CacheLookup
   // @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"remove item\"]")
    //private WebElement removeButton;


    public void clickCheckoutButton() {
        checkoutButton.click();
    }
    //public void clickRemoveButton() {
       // removeButton.click();
    }


