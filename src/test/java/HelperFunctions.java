import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


public class HelperFunctions {
    public void priceCompare(String amazonPrice, String flipkartPrice) {
        try{
            if (Integer.parseInt(flipkartPrice.split("\\.")[0].replaceAll("[^0-9]", "")) < Integer.parseInt(amazonPrice.split("\\.")[0].replaceAll("[^0-9]", ""))) {
                System.out.println("Product is cheaper on Flipkart !");
            } else if (Integer.parseInt(flipkartPrice.split("\\.")[0].replaceAll("[^0-9]", "")) > Integer.parseInt(amazonPrice.split("\\.")[0].replaceAll("[^0-9]", ""))) {
                System.out.println("Product is cheaper on Amazon !");
            } else {
                System.out.println("Product has same price on Amazon and Flipkart !");
            }
        }catch(Exception e){
            System.out.println("Error comparing Product Prices !");
        }
    }

    public WebDriver returnDriver(String url) throws IOException {
        try{
            WebDriver driver = null;
            Properties prop = returnProp();
            String browser = prop.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\msedgedriver.exe");
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
        }catch(Exception e){
            System.out.println("Error initiating Browser !");
            return null;
        }
    }

    public Properties returnProp() throws IOException {
        try{
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\test.properties");
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        }catch(Exception e){
            System.out.println("Error loading property file !");
            return null;
        }
    }

    public void closeWindow(WebDriver driver){
        try{
            driver.close();
        }catch(Exception e){
            System.out.println("Error closing Browser window !");
        }
    }

    public void quitBrowser(WebDriver driver){
        try{
            driver.quit();
        }catch(Exception e){
            System.out.println("Error while quitting Browser !");
        }
    }

    public void switchToWindow(WebDriver driver, String windowId){
        try{
            String childId = null;
            String parentId = null;
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> iteration = handles.iterator();
            parentId = iteration.next();
            if (iteration.hasNext()) {
                childId = iteration.next();
            }
            if (windowId.equalsIgnoreCase("parent")) {
                driver.switchTo().window(parentId);
            } else if (windowId.equalsIgnoreCase("child")) {
                driver.switchTo().window(childId);
            }
        }catch(Exception e){
            System.out.println("Error switching Browser tabs !");
        }
    }
}
