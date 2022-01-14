package page;

import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.log4testng.Logger;

@Log4j2
public abstract class BasePage {
    public static final String BASE_URL = "https://d5j000005rjqqeae.lightning.force.com";
    public static final By NEW_BUTTON = By.xpath("//a[@title='New']");
    public static final By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public static final By SAVE_CONTACT_BUTTON = By.xpath("//button[@name='SaveEdit']");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean isPageOpen();
    public abstract boolean isPageOpen2();

    private static final Logger logger = (Logger) LoggerFactory.getLogger(BasePage.class);

    public boolean isExist(By locator) {
        logger.debug("process Locator " + locator.getClass());
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
           // System.out.println(">>> !!! " + ex.getMessage());
            logger.error(">>> >>>Unknown error", ex);
            return false;
        }
    }

}
