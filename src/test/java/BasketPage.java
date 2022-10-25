import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage {

    By productFromBasket = By.xpath("/html/body/app-root/div/div/rz-cart-page/div/main/rz-shopping-" +
            "cart/div/ul/li/rz-cart-product/div/div[1]/div/a");

    private final WebDriver driver;

    private final WebDriverWait wait;

    public BasketPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String productTitleInBasket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productFromBasket));
        return driver.findElement(productFromBasket).getText();
    }

}
