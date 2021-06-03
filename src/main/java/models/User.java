package models;

public class User {
    private String fistName;
    private String lastName;
    private Gender gender;
    private String email;
    private String password;

    public User(String fistName, String lastName, Gender gender, String email, String password) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public enum Gender{
        Male, Female
    }
}