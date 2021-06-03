package Webshop;

import TestBase.TestBase;
import models.User;
import org.junit.jupiter.api.Test;
import providers.UserFactory;

public class LoginTest extends TestBase {

    @Test
    public void shouldLoginWithExistingUser(){
        User user = new UserFactory().getAlreadyRegisteredUser();

        // dalsza część testu logowania
    }
}