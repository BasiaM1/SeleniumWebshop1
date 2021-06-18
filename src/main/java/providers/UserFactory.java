package providers;

import models.Gender;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UserFactory {
    public User getRandomUser() {
        return User.builder()
                .firstName(getRandomText())
                .lastName(getRandomText())
                .email(getRandomText() + "@wp.pl")
                .password(getRandomText())
                .gender(Gender.getRandomGender())
                .build(); //tworzy obiket usera
    }

    public User getAlreadyRegisteredUser() {
        return User.builder()
                .firstName("jan")
                .lastName("kowalski")
                .email("jqqwqweewek@wp.pl")
                .password("qweasdzxc123!@")
                .gender(Gender.Male)
                .build();//ta metoda z User ktora sprawdza password i emai
    }

    private String getRandomText() {
        return RandomStringUtils.random(7, true, false);
    }
}