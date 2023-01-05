package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Utility {

    public void verifyEmail(String email) {
        //@##@!!!!@gmail.com   ---> ['#', '@','#','@', '!', '!, '!', '!' , '@', 'g', 'm', 'a', 'i', 'l', '.', 'c', 'o', 'm' ]
        if (email != null && !email.isEmpty()) {  //  if(Objects.isNull(email))
            char[] array = email.toCharArray();
            List<Character> duplicateChar = new ArrayList<>();
            for (char c : array) {
//                    System.out.println("Missing Email Id for Contact : " + contactName);
                if (c == '@') {
                    duplicateChar.add(c);
                }
            }
            if (duplicateChar.size() > 1) {
                System.out.println("Invalid Email Id: " + email);
            }
        }
    }

    public String generateRandomEmail(int num) { // num=10  --> 19846984949
        StringBuilder randomNum = new StringBuilder();
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            int number = random.nextInt(10);
            randomNum.append(number);
        }
        String randomEmail= randomNum+ "@yopmail.com";
        System.out.println(randomNum);
        return randomEmail;
    }

}
