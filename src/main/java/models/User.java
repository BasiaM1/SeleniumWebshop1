package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String password;


    public User build() {  //mamy metode build która nam sprawdza warunki kotre sa wymagane
        if (email.isEmpty()) {
            throw new IllegalStateException("Name cannot be empty");
        }

        if (password.isEmpty()) {
            throw new IllegalStateException("Password cannot be empty");
        }
        return new User(firstName, lastName, gender, email, password);
    }

}
