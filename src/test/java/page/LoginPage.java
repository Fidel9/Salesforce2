package page;

import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON);
    }

    @Override
    public boolean isPageOpen2() {
        return false;
    }


    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public HomePage login(String userName, String password) {
        log.info("В элемент USERNAME_INPUT будет добавлен имя пользователя");
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        return new HomePage(driver);
    }
}
