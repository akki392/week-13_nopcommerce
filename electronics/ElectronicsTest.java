package electronics;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHoverOnElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"), "Nokia Lumia 1020");
        verifyTheStringMessage(By.xpath("//span[@id='price-value-20']"), "$349.00");
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), s);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        verifyTheStringMessage(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        String expectedValue = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        String actualValue = "2";
        Assert.assertEquals(expectedValue, actualValue);
        verifyTheStringMessage(By.xpath("//span[@class='product-subtotal']"), "$698.00");
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"), "Welcome, Please Sign In!");
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Register']"), "Register");
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Akash");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Dalwadi");
        sendTextToElement(By.xpath("//input[@id='Email']"), "akashdalwadi1992@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"), "akash123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "akash123");
        clickOnElement(By.xpath("//button[@id='register-button']"));
        verifyTheStringMessage(By.xpath("//div[@class='result']"), "Your registration completed");
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));

    }


    @After
    public void tearDown() {
          closeBrowser();
    }
}
