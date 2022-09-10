package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class homePage {
    WebDriver driver = null;

    public homePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(className = "bar-notification")
    public WebElement notificationBar;

    @FindBy(id = "small-searchterms")
    public WebElement searchElement;

    @FindBy(className = "search-box-button")
    public WebElement searchBtn;

    @FindBy(className = "product-item")
    public WebElement productItems;

    public WebElement getPageTitle() {
        By tagsPageTitle = By.cssSelector("div[class=\"page-title\"]:first-child");
        return driver.findElement(tagsPageTitle);
    }

    public  String getSelectedCurrencyValue()
    {
        Select ele = new Select(driver.findElement(By.name("customerCurrency")));
        WebElement option = ele.getFirstSelectedOption();
        return option.getText();
    }

    public void setSelectedCurrency(String value)
    {
        Select ele = new Select(driver.findElement(By.name("customerCurrency")));
        ele.selectByVisibleText(value);
    }

    public WebElement mainCategory(String categoryName) {
        By category = By.cssSelector("ul[class=\"top-menu notmobile\"] > li > [href=\"/" + categoryName + "\"]");
        return driver.findElement(category);
    }

    public WebElement subCategory(String subCategoryName) {

        return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a"));

//        By desktopsSubCategory = By.cssSelector("ul[class=\"sublist first-level\"] > li > [href=\"/" + subCategoryName + "\"]");
//        return driver.findElement.findElement(desktopsSubCategory);
    }

    public WebElement getApparelCategory() {
        By apparelCategory = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a");
        return driver.findElement(apparelCategory);
    }

    public WebElement getShoesSubCategory() {
        By shoesSubCategory = By.cssSelector("li[class=\"inactive\"] > a[href=\"/shoes\"]");
        return driver.findElement(shoesSubCategory);
    }

    public WebElement getShoesRedCheckBox() {
        By shoesRedCheckbox = By.cssSelector("li[class=\"item color-item\"] > input[id=\"attribute-option-15\"]");
        return driver.findElement(shoesRedCheckbox);
    }


    public WebElement getTag(String tagName) {
        By tagElement = By.cssSelector("a[href=\"/" + tagName + "\"]");
        return driver.findElement(tagElement);
    }

    public WebElement product1_addToCartButton() {
        By product1_addToCartButton = By.cssSelector("div:nth-child(2) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button");
        return driver.findElement(product1_addToCartButton);
    }

    public WebElement product2_addToCartButton() {
        By product2_addToCartButton = By.cssSelector("div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button");
        return driver.findElement(product2_addToCartButton);
    }

    public WebElement product1_wishListButton() {
        By product1_WishListButton = By.cssSelector("div:nth-child(2) > div > div.details > div.add-info > div.buttons > button.button-2.add-to-wishlist-button");
        return driver.findElement(product1_WishListButton);
    }

    public WebElement product2_wishListButton() {
        By product2_wishListButton = By.cssSelector("div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.add-to-wishlist-button");
        return driver.findElement(product2_wishListButton);
    }

    public WebElement product1_compareListButton() {
        By product1_compareListButton = By.cssSelector("div:nth-child(2) > div > div.details > div.add-info > div.buttons > button.button-2.add-to-compare-list-button");
        return driver.findElement(product1_compareListButton);
    }

    public WebElement product2_compareListButton() {
        By product2_compareListButton = By.cssSelector("div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.add-to-compare-list-button");
        return driver.findElement(product2_compareListButton);
    }

    public WebElement productComparison_link() {
        By productComparison_link = By.cssSelector("#bar-notification > div > p > a");
        return driver.findElement(productComparison_link);
    }

    public WebElement shoppingCart_header() {
        By shoppingCart_header =  By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a");
        return driver.findElement(shoppingCart_header);
    }

    public void closeNotification()
    {
        try
        {
            By notification =  By.xpath("/html/body/div[5]/div/span");
            driver.findElement(notification).click();
        }
        catch (Exception c)
        {

        }

    }

}
