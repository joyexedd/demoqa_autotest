package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.calendarComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {
    calendarComponents calendar = new calendarComponents();
String day = "01";
String month = "July";
String year = "1989";
    @BeforeAll
    static void SetUp(){
    Configuration.holdBrowserOpen = true;
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Yago Yago");
        $("#currentAddress").setValue("Moscow, MID, 12 floor");
        $("#userEmail").setValue("Yago@Yago.ru");
        $("#permanentAddress").setValue("Same");
        $("#submit").click();
    }

    @Test
    void registrationFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Vasily");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("vassyaivanoff");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber-wrapper").$("#userNumber").setValue("8889999389");
        $("#dateOfBirthInput").click();calendar.setDate(day,month,year);
        $("#userNumber").setValue("8999994949494");

    }
}
