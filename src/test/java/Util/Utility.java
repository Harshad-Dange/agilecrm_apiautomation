package Util;

import java.sql.Struct;
import java.util.*;
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

    public List<Long> setContactListForDeal(Map<String, String> data){
        List<Long> contactIdList = new ArrayList<>();
        if (Objects.nonNull(data.get("contactIds"))) {
            String[] contactIds = data.get("contactIds").split(",");
            for (String id : contactIds) {
                long contactId = Long.parseLong(id);
                contactIdList.add(contactId);
            }
        }
        return  contactIdList;
    }

    public List<Map<String, String>> setCustomDataForDeal(Map<String, String> data){
        //prepare custom data object
        List<Map<String, String>> customData = new ArrayList<>();
        Map<String, String> customDataObj = new HashMap<>();
        if (Objects.nonNull(data.get("customData"))) {
            String[] dataObject = data.get("customData").split(",");
            customDataObj.put("name", dataObject[0]);
            customDataObj.put("value", dataObject[1]);
            customData.add(customDataObj);
        }
        return customData;
    }
}
