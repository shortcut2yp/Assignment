
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonHomePage {
    WebDriver driver;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    By submitButton = By.xpath("//input[@type='submit']");
    By searchResults = By.xpath("//div[contains(@cel_widget_id,'MAIN-SEARCH_RESULTS')]");
    By productName = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By productPrice = By.xpath("//span[@class='a-price']");
    By productImage = By.xpath("//img[@class='s-image']");

    public void setSearchText(String product) {
        try{
            driver.findElement(searchBox).sendKeys(product);
        }catch(Exception e){
            System.out.println("Error entering product name in search box !");
        }
    }

    public void clickSubmitButton() {
        try{
            driver.findElement(submitButton).click();
        }catch(Exception e){
            System.out.println("Error clicking Search button !");
        }
    }

    public void clickProduct(String product) {
        try{
            List<WebElement> elements = driver.findElements(productName);
            for (WebElement ele : elements
            ) {
                if (ele.getText().contains(product)) {
                    ele.click();
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Error finding exact product in results !");
        }
    }



}


