package providers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {

    public String getRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String getRandomEmail(){
        return getRandomString(10)+"@wp.pl";
    }
}