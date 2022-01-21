import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class FlipkartHomePage {
    WebDriver driver;
    public FlipkartHomePage(WebDriver driver){
        this.driver = driver;
    }

    private By closeLoginDialog = By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]");
    private By searchBox = By.xpath("//input[contains(@title,'products')]");
    private By searchSubmit = By.xpath("//button[contains(@class,'L0Z3Pu')]");
    private By searchResults = By.xpath("//div[contains(@class,'_13oc-S')]");

    public void closeLoginDialog(){
        try{
            driver.findElement(closeLoginDialog).click();
        }catch(Exception e){
            System.out.println("Error closing Home Page dialog box !");
        }
    }

    public void findProduct(String product){
        try{
            driver.findElement(searchBox).sendKeys(product);
        }catch(Exception e){
            System.out.println("Error entering product name in search box !");
        }
    }

    public void clickSearchButton(){
        try{
            driver.findElement(searchSubmit).click();
        }catch(Exception e){
            System.out.println("Error clicking search Button !");
        }
    }

    public void navigateToProductDetails(){
        try{
            List<WebElement> lists = driver.findElements(searchResults);
            lists.get(0).click();
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> iter = handles.iterator();
            String parentId = iter.next();
            String childId = iter.next();
            driver.switchTo().window(childId);
        }catch(Exception e){
            System.out.println("Error navigating to Product details page !");
        }
    }
}
