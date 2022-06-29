package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {
    static final String Repository = "eroshenkoam/allure-example";
    static final int IssueNumber = 76;
    @BeforeAll
    static void SetUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    @DisplayName("SimpleTest")
    public void allureExampleTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step ("Открываем главную страницу", () ->
        {open("https://github.com");});
        step("ищем репозиторий" + Repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(Repository);
            $(".header-search-input").submit();
        });
        step("Переходим по ссылке репозитория" + Repository, () -> {
            $(linkText(Repository)).click();
        });
        step("Кликаем на Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверка наличия Issue с номером " + IssueNumber, () -> {
            $(withText("#76"));
            Allure.getLifecycle().addAttachment(
                    "Исходники сраницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
