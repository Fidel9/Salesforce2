package page;

import elements.DropDown;
import elements.Input;
import models.Account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountModalPage extends BasePage {
    public static final By MODAL_TITLE = By.xpath("//*[contains(@class, 'inlineTitle')]");

    public AccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MODAL_TITLE);
    }

    @Override
    public boolean isPageOpen2() {
        return false;
    }



    public AccountDetailsPage create(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Website").write(account.getWebSite());
        new Input(driver, "Description").writeTextarea(account.getDescription());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Employees").writeEmployees(account.getEmployees());
        new DropDown(driver, "Type").selectOption(account.getType());
        new DropDown(driver, "Industry").selectOption(account.getIndustry());


        return clickSave();
    }

    public AccountDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
}


