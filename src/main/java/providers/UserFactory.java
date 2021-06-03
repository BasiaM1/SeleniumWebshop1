package providers;

import models.User;

public class UserFactory {

    public User getAlreadyRegisteredUser() {
        return new User("jan", "kowalski", User.Gender.Male,
                "jqqwqweewek@wp.pl", "qweasdzxc123!@");
    }

    public User getRandomUser() {
        RandomStringGenerator rnd = new RandomStringGenerator();
        return new User(rnd.getRandomString(5), rnd.getRandomString(5), User.Gender.Male,
                rnd.getRandomEmail(), "qweasdzxc123!@");
    }
}