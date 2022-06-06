package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.calendarComponents;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormTests {

    Faker faker = new Faker();

    calendarComponents calendar = new calendarComponents();

String day = "01";
String month = "July";
String year = "1989";
    @BeforeAll
    static void SetUp(){
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    }

    @Test
    void registrationFormTest(){

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        open("/automation-practice-form");
        $("#firstName").setValue("Vasily");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("vassyaivanoff");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber-wrapper").$("#userNumber").setValue("8889999389");
        $("#dateOfBirthInput").click();calendar.setDate(day,month,year);



    }
}
