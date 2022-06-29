package guru.qa.tests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import guru.qa.domain.MenuItem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
public class JUnitTests {
        @Test
        void yaSearch(){
            Selenide.open("https://ya.ru");
            $("#text").setValue("Search");
            $("button[type='submit']").click();
        }
        @ParameterizedTest(name = "Тесты Яндекса {0}")
        @ValueSource (strings = {
                "Search",
                "Lalaland"
        })
    void yaSearchParametrized(String testData){
        Selenide.open("https://ya.ru");
        $("#text").setValue("Search");
        $("button[type='submit']").click();
    }
    @CsvSource(value = {
        "Search, translate.yandex.ru",
            "Lalaland, ru.wikipedia.org"
    }
//    ,
//    delimiter = '|' изменение разделителя в CsvSource
    )
    @ParameterizedTest(name = "Тесты Яндекса {0}, в выдаче ожидаем {1}")
    void yaSearchParametrizedComplex(String testData,String expectedResult) {
        Selenide.open("https://ya.ru");
        $("#text").setValue("Search");
        $("button[type='submit']").click();
        $$(".serp-item")
                .find(Condition.text(expectedResult))
                .shouldBe(visible);
    }
    static Stream<Arguments> methodSourceExampleTest (){
            return Stream.of(
                    Arguments.of("first string", List.of(13, 42)),
                    Arguments.of("second string", List.of(1, 2))
            );
    }
    @MethodSource ("methodSourceExampleTest")
    @ParameterizedTest
    void methodSourceExampleTest(String first, List<Integer> second){
    }
    @EnumSource(MenuItem.class)
    @ParameterizedTest()
    void yaSearchParametrizedMenuEnum(MenuItem testData){
        Selenide.open("https://ya.ru");
        $("#text").setValue("allure");
        $("button[type='submit']").click();
        $$(".navigation__item")
                .find(Condition.text(testData.rusName))
                .click();
        Assertions.assertEquals(
                2,
                WebDriverRunner.getWebDriver().getWindowHandles().size()
        );
    }
    @AfterEach
    void close(){
        Selenide.closeWebDriver();
    }


}
