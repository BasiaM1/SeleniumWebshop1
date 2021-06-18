package models;

import java.util.Random;

public enum Gender {
        Male, Female;

public static Gender getRandomGender(){
    return values()[new Random().nextInt(values().length)];
}
    }

