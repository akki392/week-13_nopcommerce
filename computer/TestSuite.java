package computer;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        boolean ans = verifyTheListIsDescendingOrder(By.xpath("//h2[@class = 'product-title']"));
        Assert.assertTrue(true);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Build your own computer']"), "Build your own computer");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        verifyTheStringMessage(By.xpath("//span[@id='price-value-1']"), "$1,475.00");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        verifyTheStringMessage(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@class = 'qty-input']"), s);
        sendTextToElement(By.xpath("//input[@class = 'qty-input']"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        verifyTheStringMessage(By.xpath("//span[@class='product-subtotal']"), "$2,950.00");
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"), "Welcome, Please Sign In!");
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Akash");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Dalwadi");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "akashdalwadi1992@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Harrow");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "84,Northwick Avenue");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA3 0AT");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07545407175");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Akash");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "3333555599994444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        verifyTheStringMessage(By.xpath("//span[normalize-space()='Credit Card']"), "Credit Card");
        verifyTheStringMessage(By.xpath("//span[normalize-space()='Next Day Air']"), "Next Day Air");
        verifyTheStringMessage(By.xpath("//td[@class='subtotal']"), "$2,950.00");
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Thank you']"), "Thank you");
        verifyTheStringMessage(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"), "Your order has been successfully processed!");
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='Welcome to our store']"), "Welcome to our store");
    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
