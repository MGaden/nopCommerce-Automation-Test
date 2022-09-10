package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class recoveryPage {

    WebDriver driver = null;

    public recoveryPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(className = "password-recovery-button")
    public WebElement recoveryBtn;

    @FindBy(className = "bar-notification")
    public WebElement notificationBar;
}
