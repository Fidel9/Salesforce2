package page;

import elements.DropDown;
import elements.Input;
import models.Account;
import models.AccountAddress;
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

    public AccountDetailsPage create(Account account, AccountAddress account2) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Website").write(account.getWebSite());
        new Input(driver, "Description").writeTextarea(account.getDescription());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Employees").writeEmployees(account.getEmployees());
        new DropDown(driver, "Type").selectOption(account.getType());
        new DropDown(driver, "Industry").selectOption(account.getIndustry());

        new Input(driver, "Billing Address").writeBillingAddress(account2.getBillingAddress());
        new Input(driver, "Enter Address").writeInputEnterAddress(account2.getAddressEnter());
        new Input(driver, "Billing Street").writeBillingStreet(account2.getBillingStreet());
        new Input(driver, "Billing City").writeBillingCity(account2.getBillingCity());

        return clickSave();
    }

    public AccountDetailsPage clickSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new AccountDetailsPage(driver);
    }
}


