package taskWork.taskwork4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import taskWork.taskwork4.util.AllureReporter;


@ExtendWith(AllureReporter.class)
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"taskWork/taskwork4/steps"},
        features = {"src/test/java/resources"},
        tags = {"@Сбербанк"}
)
public class CucumberRunner {
}
