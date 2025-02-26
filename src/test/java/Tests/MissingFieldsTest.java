package Tests;

import Helpers.BasePage;
import Pages.HomePage;
import Pages.MyCartPage;
import Pages.ProductPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MissingFieldsTest extends BasePage {


        @Test
        public void secondTest() throws InterruptedException, MalformedURLException {

            //startDevice();
            startAppiumServer();
            emulatorDriver();

            HomePage homePage = new HomePage(driver);
            homePage.clickProductTitle();

            ProductPage productPage = new ProductPage(driver);
            productPage.setColorName();
            productPage.setProductQtyIncrease(3);
            productPage.setProductQtyDecrease(1);
            productPage.setAddToCart();
            productPage.clickCartBadgeButton();


            MyCartPage myCartPage = new MyCartPage(driver);
            myCartPage.clickCheckoutButton();
    }
}
