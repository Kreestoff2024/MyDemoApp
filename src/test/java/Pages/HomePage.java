package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }


    @CacheLookup
    @AndroidFindBy(xpath = "//*[@text=\"Sauce Labs Backpack\"]")
    private WebElement productTitle;


    public void clickProductTitle(){
        productTitle.click();

    }
}
