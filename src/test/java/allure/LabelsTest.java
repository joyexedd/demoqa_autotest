package allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Owner("EgorKa")
    @Link(value = "Тестинг", url = "https://github.com")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Просмотр задач в репозитории")
    @DisplayName("My test")
    public void testAnnotated () {


    }




}
