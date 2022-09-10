package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void opeBrowser() throws InterruptedException {
        String chromeDriverPath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public  void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public static int generateRandomInt(int upperbound)
    {
        Random rand = new Random();
        return rand.nextInt(upperbound);
    }
}
