package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private final String fistName;
    private final String lastName;
    private final Gender gender;
    private final String email;
    private final String password;


    public static final class Builder {
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private Gender gender;


        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this; //to są settery
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

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
}