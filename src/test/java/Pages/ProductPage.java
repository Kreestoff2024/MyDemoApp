package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Attributs
    @CacheLookup
    @AndroidFindBy(xpath = "//*[@content-desc=\"gray circle\"]")
    private WebElement productPage;

    @CacheLookup
    @AndroidFindBy(xpath = "//*[@content-desc=\"counter plus button\"]")
    private WebElement productQtyIncrease;

    @CacheLookup
    @AndroidFindBy(xpath = "//*[@content-desc=\"Add To Cart button\"]")
    private WebElement productAddToCart;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter minus button\"]")
    private WebElement productQtyDecrease;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]")
    private WebElement productCartBadge;

    //Méthodes
    public void setProductQtyIncrease(int qty){
        for (int i = 0; i < qty; i++){
            productQtyIncrease.click();
        }

    }
    public void setProductQtyDecrease(int qty) {
        for (int i = 3; i > qty; i--) {
            productQtyDecrease.click();
        }
    }
    public void setColorName(){
        productPage.click();

    }

    public void setAddToCart(){
        productAddToCart.click();
    }

    public void clickCartBadgeButton(){
        productCartBadge.click();


    }

}
