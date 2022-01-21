import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage {

    WebDriver driver;

    public AmazonProductPage(WebDriver driver){
        this.driver = driver;
    }

    By addToCart = By.xpath("//input[@id='add-to-cart-button']");
    By cartButton = By.xpath("//input[contains(@aria-labelledby,'view-cart-button')]");
    By productPrice = By.xpath("//span[contains(@class,'text-price')]");

    public void clickAddToCart(){
        Assignment t = new Assignment();
        t.switchToWindow(driver,"child");
        driver.findElement(addToCart).click();
    }

    public void clickCartButton(){
        try{
            driver.findElement(cartButton).click();
        }catch(Exception e){
            System.out.println("Error clicking Cart button !");
        }
    }

    public void printProductPrice(){
        try{
            HelperFunctions help = new HelperFunctions();
            help.switchToWindow(driver,"child");
            System.out.println("Price of product on Amazon is " + driver.findElement(productPrice).getText());
        }catch(Exception e){
            System.out.println("Error printing Product Price !");
        }
    }

}
