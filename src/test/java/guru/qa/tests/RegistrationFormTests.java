package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.calendarComponents;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormTests {

    Faker faker = new Faker();

    calendarComponents calendar = new calendarComponents();

String day = "01",
        month = "July",
        year = "1989";
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress();


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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber-wrapper").$("#userNumber").setValue("8889999389");
        $("#dateOfBirthInput").click();calendar.setDate(day,month,year);



    }
}
