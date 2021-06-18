package Webshop;

import TestBase.TestBase;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends TestBase{
    private User user;
    private String expectedSignInText;

    @BeforeEach
    public void testSetup() {
        user = new UserFactory().getAlreadyRegisteredUser();
        expectedSignInText = user.getFistName() + " " + user.getLastName();
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    public void shouldLoginUser() {
        homePage.getMenu()
                .openLoginPage()
               .login(user);
        String actualSignInText = homePage.getMenu().getUserName();
        assertThat(actualSignInText,
                equalTo(expectedSignInText));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    public void shouldLoginAlternative() {
        assertThat(homePage
                        .getMenu()
                        .openLoginPage()
                        .login(user)
                        .getMenu()
                        .getUserName(),
                equalTo(expectedSignInText));
    }
}
        // dalsza część testu logowania
        //rest api, dev tworza endpoint w backendzie,
        // że nie musi sie logowac przez UI aplikacji tylko uderza do backendu do endpointu login,
        // w backendzie wysyla sie tlko login uzytkownika i ten endpoint odsyla cookies
        //i wstrzykuje sie te cookies do przegladarki otwiera strone i jest zalogowany
        //getDriver().manage.addCookie("")
        //getDriver().navigate().refresh(); i jest już zalogowany
