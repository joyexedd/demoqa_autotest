package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void SetUp(){
    Configuration.holdBrowserOpen = true;
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Yago Yago");
        $("[id=currentAddress]").setValue("Moscow, MID, 12 floor");
        $("[id=userEmail]").setValue("Yago@Yago.ru");
        $("[id=permanentAddress]").setValue("Same");
        $("[id=submit]").click();
    }
}
