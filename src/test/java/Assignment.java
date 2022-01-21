import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class Assignment extends HelperFunctions{

    @Test
    public void flipkart() throws IOException {
        Properties prop = returnProp();
        WebDriver driver = returnDriver(prop.getProperty("flipkartURL"));
        FlipkartHomePage fhp = new FlipkartHomePage(driver);
        FlipkartProductPage fpp = new FlipkartProductPage(driver);
        FlipkartCheckoutPage fcp = new FlipkartCheckoutPage(driver);
        fhp.closeLoginDialog();
        fhp.findProduct("Mi 4X 125.7 cm (50 Inches)");
        fhp.clickSearchButton();
        fhp.navigateToProductDetails();
        fpp.printProductPrice();
        fpp.clickAddToCartButton();
        fcp.clickIncreaseQuantity();
        fcp.checkQuantityIncreasedDialog();
        fcp.printTotalPrice();
        quitBrowser(driver);
    }


    @Test
    public void comparePrice() throws IOException {
        Properties prop = returnProp();
        WebDriver driver = returnDriver(prop.getProperty("flipkartURL"));
        FlipkartHomePage fhp = new FlipkartHomePage(driver);
        FlipkartProductPage fpp = new FlipkartProductPage(driver);
        FlipkartCheckoutPage fcp = new FlipkartCheckoutPage(driver);
        AmazonHomePage ahp = new AmazonHomePage(driver);
        AmazonProductPage app = new AmazonProductPage(driver);
        AmazonCheckoutPage acp = new AmazonCheckoutPage(driver);
        fhp.closeLoginDialog();
        fhp.findProduct("Mi 125.7 cm (50 Inches)");
        fhp.clickSearchButton();
        fhp.navigateToProductDetails();
        fpp.printProductPrice();
        fpp.clickAddToCartButton();
        fcp.printTotalPrice();
        String flipkartPrice = fcp.returnProductPrice();
        closeWindow(driver);
        switchToWindow(driver,"parent");
        driver.get(prop.getProperty("amazonURL"));
        ahp.setSearchText("Mi 125.7 cm (50 Inches)");
        ahp.clickSubmitButton();
        ahp.clickProduct("Mi 125.7 cm (50 Inches)");
        app.printProductPrice();
        app.clickAddToCart();
        app.clickCartButton();
        acp.printProductPrice();
        String amazonPrice= acp.getProductPrice();
        priceCompare(amazonPrice,flipkartPrice);
        quitBrowser(driver);
    }



}
