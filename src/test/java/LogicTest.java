import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class LogicTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void pageObject() {
        MainPageLogic mainPageLogic = new MainPageLogic(driver, wait);
        mainPageLogic.laptopsAndComputersBtnClick();
        mainPageLogic.laptopsBtnClick();
        CategoryPageLogic categoryPageLogic = new CategoryPageLogic(driver, wait);
        categoryPageLogic.firstProductClick();
        String number = categoryPageLogic.checkNumberInBasket();
        Assert.assertEquals(number, "1");
        String productTitle = categoryPageLogic.firstProductTitleText();
        categoryPageLogic.basketBtnClick();
        BasketPage basketPage = new BasketPage(driver, wait);
        String productTitleInBasket = basketPage.productTitleInBasket();
        Assert.assertEquals(productTitleInBasket, productTitle);






        /*// відкрити категорію "Ноутбуки и компьютеры"
        WebElement laptopsAndComputers = driver.findElement(
                By.xpath("/html/body/app-root/div/div/rz-main-page/div/main/rz-main-page-content/rz-app-fat-menu-tablet/nav/ul/li[1]/a"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", laptopsAndComputers);


        // відкрити категорію "Ноутбуки"
        WebElement laptops = driver.findElement(By.xpath("/html/body/app-root/rz-single-modal-window/div[3]/div[2]/fat-menu-mobile/ul[1]/li[1]/a"));
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].click();", laptops);


        // додати продукт до корзини
        WebElement firstProductBtn = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-category/div/main/rz-catalog/div/div" +
                "/section/rz-grid/ul/li[1]/rz-catalog-tile/app-goods-tile-default/div/div[2]/div[4]/div[2]/app-buy-button/button"));
        firstProductBtn.click();


        // перевірити, чи в корзину додано 1 продукт
        WebElement checkBasket = driver.findElement(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
        String count = checkBasket.getText();
        Assert.assertEquals(count, "1");

        // отримати назву першого продукту
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/rz-category/" +
                "div/main/rz-catalog/div/div/section/rz-grid/ul/li[1]/rz-" +
                "catalog-tile/app-goods-tile-default/div/div[2]/a[2]/span")));
        String firstProductTitle = firstProduct.getText();
        System.out.println(firstProductTitle);

        // перейти в корзину
        WebElement basketBtn = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-" +
                "header/rz-main-header/header/div/div/ul/li[7]/rz-cart/button"));
        basketBtn.click();


        // отримати назву продукту з корзини
        WebElement productFromBasket = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-" +
                "cart-page/div/main/rz-shopping-cart/div/ul/li/rz-cart-product/div/div[1]/div/a"));
        String productTitleFromBasket = productFromBasket.getText();
        System.out.println(productTitleFromBasket);

        // перевірити чи в корзину добавився правильний товар
        Assert.assertEquals(productTitleFromBasket, firstProductTitle);*/
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
