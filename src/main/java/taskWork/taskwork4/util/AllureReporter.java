package taskWork.taskwork4.util;

import taskWork.taskwork4.manager.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureReporter extends AllureJunit5 implements AfterTestExecutionCallback  {

    @Override
    public void afterTestExecution(ExtensionContext context){
        if(context.getExecutionException().isPresent()){
            takeScreenshot();
        }
    }

    @Attachment(type = "image/png", value = "Screenshoot")
    public static byte[] takeScreenshot(){
        return ((TakesScreenshot) DriverManager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
