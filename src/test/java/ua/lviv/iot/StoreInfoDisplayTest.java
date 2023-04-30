package ua.lviv.iot;

import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Getter
public class StoreInfoDisplayTest {

    private String info;

    @BeforeEach
    public void setUp(){
        info = """
                Епіцентр, м.Львів, вул.Стрийська, час роботи: 10:00 - 21:30
                Сільпо, м.Запоріжжя, вул.Якась Вулиця, час роботи: 00:00 - 23:58
                Магазин для хліборобів та інженерів, м.Львів, вул.Степана Бандери (ЛПНУ), час роботи: 00:00 - 00:00""";

    }

    @Test
    public void parseStoreInfoIfStoreExists(){
        String storeName = "Сільпо";

        StoreInfoDisplay storeInfoDisplay = new StoreInfoDisplay();
        String expectedParsedInfo = "Сільпо, час роботи: 00:00 - 23:58";
        String resultParsedInfo = storeInfoDisplay.parseStoreInfo(storeName, info);

        assertEquals(expectedParsedInfo, resultParsedInfo);
    }

    @Test
    public void parseStoreInfoIfStoreNotExists(){
        String storeName = "Рукавичка";

        StoreInfoDisplay storeInfoDisplay = new StoreInfoDisplay();
        String expectedParsedInfo = "Магазина з такою назвою не існує у нашому всесвіті :(";
        String resultParsedInfo = storeInfoDisplay.parseStoreInfo(storeName, info);

        assertEquals(expectedParsedInfo, resultParsedInfo);
    }

    @Test
    public void parseStoreInfoIsNullOrStoreNameIsNull(){
        StoreInfoDisplay storeInfoDisplay = new StoreInfoDisplay();

        assertThrows(IllegalArgumentException.class, () -> storeInfoDisplay.parseStoreInfo("",""));
    }
}