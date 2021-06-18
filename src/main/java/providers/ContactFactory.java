package providers;

import models.Contact;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class ContactFactory {

    public Contact getRandomDataContact(){

        return Contact.builder()
                .email(getRandomText()+"@gmail.com")
                .filePath(new File("src\\main\\resources\\file.txt"))
                .message(getRandomText())
                .build();
    }

    private String getRandomText() {
        return RandomStringUtils.random(7, true, false);
    }
}
