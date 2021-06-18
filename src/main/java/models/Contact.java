package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.File;

@Getter
@AllArgsConstructor
@Builder
public class Contact {

    private String subject;
    private String email;
    private File filePath;
    private String message;


    public Contact build() {
        if (email.isEmpty()) {
            throw new IllegalStateException("email cannot be empty");
        }
        if (subject.isEmpty()) {
            throw new IllegalStateException("subject cannot be empty");
        }
        if(message.isEmpty()){
            throw new IllegalStateException("Message cannot be empty");
        }
        return new Contact(subject,email, filePath, message);
    }

}
