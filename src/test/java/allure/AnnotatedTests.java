package allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static allure.LambdaTest.IssueNumber;
import static allure.LambdaTest.Repository;

public class AnnotatedTests {

    @Test
    @DisplayName("SimpleTest")
    public void allureExampleTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(Repository);
        steps.clickForRepositoryLink(Repository);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(IssueNumber);
        attachScreenshot();
    }
    @Attachment (value = "Скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
