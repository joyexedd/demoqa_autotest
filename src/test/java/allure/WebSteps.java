package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static allure.LambdaTest.IssueNumber;
import static allure.LambdaTest.Repository;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public void openMainPage () {
        open("https://github.com");
    }
    @Step ("ищем репозиторий {repo}")
    public void searchForRepository (String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }
    @Step ("Переходим по ссылке репозитория {repo}")
    public void clickForRepositoryLink (String repo) {
        $(linkText(repo)).click();
    }
    @Step ("Кликаем на Issues")
    public void openIssueTab () {
        $(partialLinkText("Issues")).click();
    }
    @Step ("Проверка наличия Issue с номером {number}")
    public void shouldSeeIssueWithNumber (int number) {
        $(withText("#" + number)).should(Condition.visible);
    }
}
