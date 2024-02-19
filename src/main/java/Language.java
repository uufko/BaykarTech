import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Language {
    WebDriver driver;
    String BASE_URL = "https://baykartech.com/tr/";
    String languageButton = "//div[@class='lang']/a";
    String closeButton = "//button[@class='close']";
    String EN_Page = "//html[@lang='en']";
    String TR_Page = "//html[@lang='tr']";

    public void clickToElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    public void waitToElement(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void setDriver() {
        driver = new ChromeDriver();
    }

    public void goPage() throws InterruptedException {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        Thread.sleep(10000);
    }

    public void closeWindow() {
        if (driver.findElement(By.xpath(closeButton)).isDisplayed()) {
            waitToElement(closeButton);
            clickToElement(closeButton);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }
    }

    public void setEN() {
        boolean isDisplayed = driver.findElement(By.xpath(TR_Page)).isDisplayed();
        if (isDisplayed){
            waitToElement(languageButton);
            clickToElement(languageButton);
        }
    }

    public void setTR(){
        boolean isDisplayed = driver.findElement(By.xpath(EN_Page)).isDisplayed();
        if (isDisplayed){
            waitToElement(languageButton);
            clickToElement(languageButton);
        }
    }

    public void isPageEN(){
        if (driver.getCurrentUrl().contains("/en/"));
        waitToElement(EN_Page);
    }
    public void isPageTR(){
        if (driver.getCurrentUrl().contains("/tr/"));
        waitToElement(TR_Page);
    }

}


