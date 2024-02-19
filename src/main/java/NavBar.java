import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class NavBar {
    WebDriver driver;
    String BASE_URL = "https://baykartech.com/tr/";
    String closeButton = "//button[@class='close']";
    String firstBar = "//div[@class='navbar-nav ml-auto']/div";
    String secondBar = "//div[@class='navbar-nav ml-auto']/a";

    public void waitElement(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void clickElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    public void setDriver() {
        driver = new ChromeDriver();
    }

    public void goPage() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public void closeWindow() {
        System.out.println(driver.findElement(By.xpath(closeButton)).isDisplayed());
        if (driver.findElement(By.xpath(closeButton)).isDisplayed()) {
            waitElement(closeButton);
            clickElement(closeButton);
        }
    }

    public void clickFirstBar() throws InterruptedException {
        long navBarObject = driver.findElements(By.xpath(firstBar)).stream().count();
        int navBarObjectCount = (int) navBarObject;
        for (int i = 1; i < navBarObjectCount + 1; i++) {
            Thread.sleep(1000);
            System.out.println(driver.getCurrentUrl());
            waitElement(firstBar);
            driver.findElement(By.xpath("//div[@class='navbar-nav ml-auto']/div[" + i + "]")).click();
            long elementObject = driver.findElements(By.xpath("//div[@class='dropdown show']/div/div/div/a")).stream().count();
            int elementObjectCount = (int) elementObject;
            for (int y = 1; y < elementObjectCount + 1; y++) {
                Thread.sleep(1000);
                driver.findElement(By.xpath("//div[@class='dropdown show']/div/div/div/a[" + y + "]")).click();
                driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                System.out.println(driver.getCurrentUrl());
                driver.navigate().back();
                closeWindow();
                waitElement(firstBar);
                driver.findElement(By.xpath("//div[@class='navbar-nav ml-auto']/div[" + i + "]")).click();
            }
        }

    }

    public void clickSecondBar() throws InterruptedException {
        long navBarObject = driver.findElements(By.xpath(secondBar)).stream().count();
        int navBarObjectCount = (int) navBarObject;
        for (int i = 1; i < navBarObjectCount + 1; i++) {
            Thread.sleep(1000);
            System.out.println(driver.getCurrentUrl());
            waitElement(secondBar);
            driver.findElement(By.xpath("//div[@class='navbar-nav ml-auto']/a[" + i + "]")).click();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.navigate().back();
            closeWindow();
        }
    }

}
