import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWebDriverManagerTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.findElement(By.cssSelector("[id='firstName']")).sendKeys("Petr");
        driver.findElement(By.cssSelector("[id='lastName']")).sendKeys("Petrov");
        driver.findElement(By.cssSelector("[id='userNumber']")).sendKeys("1234567898");
        driver.findElement(By.cssSelector("[for='gender-radio-1']")).click();
        driver.findElement(By.cssSelector("[id='submit']")).click();

        Assertions.assertTrue(driver.findElement(By.cssSelector("[id='example-modal-sizes-title-lg']")).isDisplayed());

        Thread.sleep(3000);

    }

    @Test
    public void secondTest() throws InterruptedException {
        driver.findElement(By.cssSelector("[id='firstName']")).sendKeys("Elena");
        driver.findElement(By.cssSelector("[id='lastName']")).sendKeys("Nikihporova");
        driver.findElement(By.cssSelector("[id='userNumber']")).sendKeys("1234567898");
        driver.findElement(By.cssSelector("[for='gender-radio-2']")).click();
        driver.findElement(By.cssSelector("[id='submit']")).click();

        Assertions.assertTrue(driver.findElement(By.cssSelector("[id='example-modal-sizes-title-lg']")).isDisplayed());

        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown(){
      driver.quit();
    }
}
