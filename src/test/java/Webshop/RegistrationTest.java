package Webshop;

import TestBase.TestBase;
import models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import providers.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationTest extends TestBase {

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    public void shouldRegisterNewUser() {
        User user = new UserFactory().getRandomUser();

        homePage.getMenu()
                .openLoginPage()
                .openRegisterNewUserPage()
                .registerUser(user);

        assertThat(homePage.getMenu().getUserName(),
                equalTo(user.getFirstName() + " " + user.getLastName()));
    }
}
//    @AfterEach(){
//        //usun usera z bazy, dlatego ze przy takich danych na sztywno ten test zadzialalby tylko raz
//        //testy powinny po sobie "sprzatac"
//    }
