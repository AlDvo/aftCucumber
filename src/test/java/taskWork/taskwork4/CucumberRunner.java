package taskWork.taskwork4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"taskWork.taskwork4.util.AllureReporter"},
        glue = {"taskWork/taskwork4/steps"},
        features = {"src/test/java/resources"},
        tags = {"@Сбербанк"}
)
public class CucumberRunner {
}
