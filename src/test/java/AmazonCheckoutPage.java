import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCheckoutPage {

    WebDriver driver;

    public AmazonCheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    By productPriceInCart = By.xpath("//span[contains(@class,'product-price')]");

    public void printProductPrice(){
        try{
            System.out.println("Price of Product in Amazon cart is "+driver.findElement(productPriceInCart).getText());
        }catch(Exception e){
            System.out.println("Error capturing Product Price !");
        }
    }

    public String getProductPrice(){
        try{
            return driver.findElement(productPriceInCart).getText();
        }catch(Exception e){
            System.out.println("Error fetching Product Price !");
            return null;
        }
    }
}
