import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartCheckoutPage {

    WebDriver driver;
    public FlipkartCheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    By increaseQuantityButton = By.xpath("//button[text()='+']");
    By quantityIncreasedDialog = By.xpath("//div[@class='_2sKwjB']");
    By totalPrice = By.xpath("//div[@class='Ob17DV _3X7Jj1']/span");


    public void clickIncreaseQuantity(){
        try{
            driver.findElement(increaseQuantityButton).click();
        }catch(Exception e){
            System.out.println("Error clicking on increase quantity button !");
        }
    }

    public void checkQuantityIncreasedDialog(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(quantityIncreasedDialog)));
        }catch(Exception e){
            System.out.println("Error increasing product quantity !");
        }
    }

    public void printTotalPrice(){
        try{
            System.out.println("Total cart value is " + driver.findElement(totalPrice).getText());
        }catch(Exception e){
            System.out.println("Error printing total Product Price !");
        }
    }

    public String returnProductPrice(){
        try{
            return driver.findElement(totalPrice).getText();
        }catch(Exception e){
            System.out.println("Error capturing Product Price on Flipkart !");
            return  null;
        }
    }

}
