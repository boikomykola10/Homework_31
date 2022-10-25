
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {
    By laptopsAndComputers = By.xpath("/html/body/app-root/div/div/rz-main-page/div/main/rz-main-page-content/rz-app-fat-menu-tablet/nav/ul/li[1]/a");

    By laptops = By.xpath("/html/body/app-root/rz-single-modal-window/div[3]/div[2]/fat-" +
            "menu-mobile/ul[1]/li[1]/a");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void laptopsAndComputersBtnClick() {
        driver.findElement(laptopsAndComputers).click();
    }

    public CategoryPageLogic laptopsBtnClick() {
        driver.findElement(laptops).click();
        return new CategoryPageLogic(driver, wait);
    }
}
