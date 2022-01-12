package tests;

import models.AccountContact;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class AccountContactTest extends  BaseTest{

    @Test
    public void accountShouldBeCreated() {
        loginPage
                .open()
                .login("llev7208-gnwy@force.com", "Bobruisk2021");

        boolean isAccountContactModalOpen = accountContactListPage
                .open()
                .clickNew()
                .isPageOpen2();
        assertFalse(isAccountContactModalOpen, "папап не открыт");

        AccountContact accountContact = new AccountContact("Mr.", "Irvin", "Ivanov","AccountTest",
                "ivan555@mailinator.com","+375 25 544 44 44");


        boolean isDetailsContactPageOpen = accountContactModalPage
                .create(accountContact)
                .isPageOpen2();
        assertTrue(isDetailsContactPageOpen, "Не открывается");

        assertEquals(accountContactDetailsPage.getFieldValueByName2("Salutation"), accountContact.getSalutation(), "");
        assertEquals(accountContactDetailsPage.getFieldValueByName2("First Name"), accountContact.getFirstName(), "");
        assertEquals(accountContactDetailsPage.getFieldValueByName2("Last Name"), accountContact.getLastName(), "");
        assertEquals(accountContactDetailsPage.getFieldValueByName2("Account Name"), accountContact.getAccountName(), "");
        assertEquals(accountContactDetailsPage.getFieldValueByName2("Email"), accountContact.getEmailContact(), "");
        assertEquals(accountContactDetailsPage.getFieldValueByName2("Phone"), accountContact.getPhoneNumberContact(), "");
    }
}
