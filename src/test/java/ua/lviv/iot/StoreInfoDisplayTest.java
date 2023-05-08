package ua.lviv.iot;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Getter
public class StoreInfoDisplayTest {
    private final String storeName = "Epicentr, Lviv, Struyska st, working time: 10:00 - 21:30" +
            "Silpo, Zaporizhzhya, Yakas st, working time: 00:00 - 23:58" +
            "IoT Store, Lviv, Stepan Bandera st, working time: 00:00 - 00:00";

    @Test
    public void parseStoreInfoIfStoreExists() {
        String info = "Epicentr";
        StoreInfoDisplay storeInfoDisplay = new StoreInfoDisplay();
        String expectedParsedInfo = "Epicentr, working time: 10:00 - 21:30";
        String resultParsedInfo = storeInfoDisplay.parseStoreInfo(storeName, info);
        Assertions.assertEquals(expectedParsedInfo, resultParsedInfo);
    }

    @Test
    public void parseStoreInfoIfStoreNotExists() {
        String info = "Rukavychka";
        StoreInfoDisplay storeInfoDisplay = new StoreInfoDisplay();
        String expectedParsedInfo = "There is no store like that :(";
        String resultParsedInfo = storeInfoDisplay.parseStoreInfo(storeName, info);
        assertEquals(expectedParsedInfo, resultParsedInfo);
    }

    @Test
    public void parseStoreInfoIsNullOrStoreNameIsNull() {
        StoreInfoDisplay storeInfoDisplay = new StoreInfoDisplay();

        assertThrows(IllegalArgumentException.class, () -> storeInfoDisplay.parseStoreInfo("", ""));
    }
}
