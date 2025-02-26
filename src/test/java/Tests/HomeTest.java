package Tests;


import Helpers.BasePage;
import Pages.*;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HomeTest extends BasePage {


    @Test
    public void firstTest() throws InterruptedException, MalformedURLException {

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
        //myCartPage.clickRemoveButton();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsernameField();
        loginPage.inputPasswordField();
        loginPage.clickLoginButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputFullname();
        checkoutPage.inputAddressLine1();
        checkoutPage.inputAddressLine2();
        checkoutPage.inputCity();
        checkoutPage.inputState();
        checkoutPage.inputZip();
        checkoutPage.inputCountry();
        checkoutPage.toPaymentButton();

        PaymentMethodPage paymentMethodPage = new PaymentMethodPage(driver);
        paymentMethodPage.inputNameField();
        paymentMethodPage.inputCardNumberField();
        paymentMethodPage.inputExpirationDateField();
        paymentMethodPage.inputSecurityCodeField();
        paymentMethodPage.reviewOrderButton();
        paymentMethodPage.clickMyBillingAddressBox();

        ReviewPage reviewPage = new ReviewPage(driver);
        reviewPage.clickPlaceOrderButton();



    }
}
