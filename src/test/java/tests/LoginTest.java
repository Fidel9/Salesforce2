package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

    public class LoginTest extends BaseTest {

        @Test
        public void login() {
            boolean isHomePageOpened = loginPage
                    .open()
                    .login("llev7208-1q4u@force.com", "Bobruisk2021")
                    .isPageOpen();

            assertTrue(isHomePageOpened, "Страница HomePage не открылась ");
        }

    }

