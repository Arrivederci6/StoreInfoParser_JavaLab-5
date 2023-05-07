package ua.lviv.iot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoreInfoDisplay {
    public String parseStoreInfo(String info, String storeName) {
        if (storeName == null || info == null || storeName.isEmpty() || info.isEmpty())  {
            throw new IllegalArgumentException("List is empty");
        }

        Pattern patternToDisplay = Pattern.compile((storeName) + ",.*?,.*? working time: (\\d{2}:\\d{2} - \\d{2}:\\d{2})");
        Matcher matcher = patternToDisplay.matcher(info);
        if (matcher.find()) {

            String closingTime = matcher.group(1);

            return storeName + ", working time: "  + closingTime;
        }

        return "There is no store like that :(";
    }

}