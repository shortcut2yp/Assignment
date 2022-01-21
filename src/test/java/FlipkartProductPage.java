import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartProductPage {
    WebDriver driver;
    public FlipkartProductPage(WebDriver driver){
        this.driver = driver;
    }

    By productPrice = By.xpath("//div[contains(@class,'_30jeq3')]");
    By addToCartButton = By.xpath("//button[contains(@class,'_2KpZ6l _2U9uOA _3v1-ww')]");

    public void printProductPrice(){
        try{
            System.out.println("Price of product on Flipkart is " + driver.findElement(productPrice).getText());
        }catch(Exception e){
            System.out.println("Error printing Product Price !");
        }
    }

    public void clickAddToCartButton(){
        try{
            driver.findElement(addToCartButton).click();
        }catch(Exception e){
            System.out.println("Error clicking on Add to Cart Button !");
        }
    }

}
