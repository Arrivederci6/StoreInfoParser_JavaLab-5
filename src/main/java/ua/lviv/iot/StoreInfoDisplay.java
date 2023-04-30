package ua.lviv.iot;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoreInfoDisplay {

    public String parseStoreInfo(String info, String storeName){
        if(storeName.isEmpty() || info.isEmpty()){
            throw new IllegalArgumentException("Список магазинів пустий.");
        }
        String result = "";
        Pattern patternToDisplay = Pattern.compile(storeName + ", .*?, .*?, час роботи: (.*?)-(.*?)(\\n|$)");
        Matcher matcher = patternToDisplay.matcher(info);
        if (matcher.find()) {
            String openingTime = matcher.group(1);
            String closingTime = matcher.group(2);

            result += storeName + ", час роботи: " + openingTime + " - " + closingTime;
        } else {
            result = "Магазина з такою назвою не існує у нашому всесвіті :(";
        }
        return result;
    }

}
