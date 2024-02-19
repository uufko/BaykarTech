import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LanguageTest extends Language {
    @BeforeClass
    public void setDriverTest() {
        setDriver();
    }

    @Test(priority = 1)
    public void goPageTest() throws InterruptedException {
        goPage();
    }

    @Test(priority = 2)
    public void closeWindowTest() {
        closeWindow();
    }
    @Test(priority = 3)
    public void changeLanguageENTest() {
        setEN();
        closeWindow();
    }
    @Test (priority = 4)
    public void isPageENTest(){
        isPageEN();
    }
    @Test (priority = 5)
    public void changeLanguageTRTest(){
        setTR();
        closeWindow();
    }
    @Test (priority = 6)
    public void isPageTRTest(){
        isPageTR();
    }
}
