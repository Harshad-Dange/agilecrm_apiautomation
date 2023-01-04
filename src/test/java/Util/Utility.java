package Util;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public  void verifyEmail(String email){
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
            if(duplicateChar.size()>1){
                System.out.println("Invalid Email Id: " + email);
            }
        }
    }

}
