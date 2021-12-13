package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test
    public void accountShouldBeCreated() {
        loginPage
                .open()
                .login("llev7208-1q4u@force.com", "Bobruisk2021");

        boolean isAccountModalOpen = accountListPage
                .open()
                .clickNew()
                .isPageOpen();
        assertTrue(isAccountModalOpen, "папап не открыт");

        Account account = new Account("TestAccountName", "www.onliner.by", "Investor",
                "new account description.", "123-456", "1", "Apparel");

        AccountAddress account2 = new AccountAddress("","","Chapton Street",
                "My address");

        boolean isDetailsPaigeOpen = accountModalPage
                .create(account,account2)
                .isPageOpen();
        assertTrue(isDetailsPaigeOpen, "Не открывается");

        assertEquals(accountDetailsPage.getFieldValueByName("Account Name"), account.getAccountName(), "");
        assertEquals(accountDetailsPage.getFieldValueByName("Website"), account.getWebSite(), "");
        assertEquals(accountDetailsPage.getFieldValueByName("Type"), account.getType(), "");
        assertEquals(accountDetailsPage.getFieldValueByName("Description"), account.getDescription(), "");
        assertEquals(accountDetailsPage.getFieldValueByName("Phone"), account.getPhone(), "");
        assertEquals(accountDetailsPage.getFieldValueByName("Employees"), account.getEmployees(), "");
        assertEquals(accountDetailsPage.getFieldValueByName("Industry"), account.getIndustry(), "");

        System.out.println("!");
    }
}
