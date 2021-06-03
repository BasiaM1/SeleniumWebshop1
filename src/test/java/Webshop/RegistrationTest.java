package Webshop;

import TestBase.TestBase;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MenuPage;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationTest extends TestBase {
    private MenuPage menuPage;
    private User user;

    @BeforeEach
    public void testSetup() {
        menuPage = new MenuPage(getDriver());
        user = new UserFactory().getRandomUser();
    }


    @Test
    public void shouldRegisterNewUser() {
        menuPage.openLoginPage()
                .openRegisterNewUserPage()
                .registerUser(user);

        assertThat(menuPage.getUserName(),
                equalTo(user.getFistName() + " " + user.getLastName()));
    }

//    @AfterEach(){
//        //usun usera z bazy, dlatego ze przy takich danych na sztywno ten test zadzialalby tylko raz
//        //testy powinny po sobie "sprzatac"
//    }
}