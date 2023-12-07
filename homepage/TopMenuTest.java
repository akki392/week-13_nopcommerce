package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
        for (WebElement element: topMenuList) {
            if(element.getText().trim().equalsIgnoreCase(menu)){
                clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='"+menu+"']"));
                break;
            }
        }

    }
    @Test
    public void verifyPageNavigation() {
        String menu = "Computers";
        selectMenu(menu);
        String expectedTitle = getTextFromElement(By.xpath("//h1[normalize-space()='"+menu+"']"));
        String axpectedTitle = menu;
        Assert.assertEquals(expectedTitle, axpectedTitle);
    }

    @After
    public void endTest() {
        closeBrowser();
    }
}
