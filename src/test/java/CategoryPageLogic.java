import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CategoryPageLogic {

    By firstProductBtn = By.xpath("//span[@class='goods-tile__title']");
    By checkBasket = By.xpath("//span[@class='counter counter--green ng-star-inserted']");

    By basketBtn = By.xpath("//button[@class='header__button ng-star-inserted']");
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CategoryPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String firstProductTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductBtn));
        return driver.findElement(firstProductBtn).getText();
    }

    public ProductPageLogic firstProductClick() {
        driver.findElement(firstProductBtn).click();
        return new ProductPageLogic(driver);
    }

    public String checkNumberInBasket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBasket));
        return driver.findElement(checkBasket).getText();
    }

    public BasketPage basketBtnClick() {
        driver.findElement(basketBtn).click();
        return new BasketPage(driver, wait);

    }

}
