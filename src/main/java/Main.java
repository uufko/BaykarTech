import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main {
    WebDriver driver;
    public void clickToElement(String element){
        driver.findElement(By.xpath(element)).click();
    }
}
