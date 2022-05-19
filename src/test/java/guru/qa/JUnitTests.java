package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class JUnitTests {
    @BeforeEach
    void openYa() {
        Selenide.open("https://ya.ru");
    }
    @AfterEach
    void closeYa() {
        Selenide.closeWindow();
    }

    @Test
    void assertTest() {
        Assertions.assertTrue(2>3);
    }
    @Test
    void assertTest2() {
        Assertions.assertTrue(2<3);
    }
}
