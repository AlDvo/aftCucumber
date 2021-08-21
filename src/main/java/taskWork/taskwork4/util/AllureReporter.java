package taskWork.taskwork4.util;

import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm;
import taskWork.taskwork4.manager.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureReporter extends AllureCucumber5Jvm {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        EventHandler<TestStepFinished> eventHandler = new EventHandler<TestStepFinished>() {
            @Override
            public void receive(TestStepFinished testStepFinished) {
                if (testStepFinished.getResult().getStatus().equals(Status.FAILED)) {
                    Allure.getLifecycle().addAttachment("scrinshoot","image/png",null,takeScreenshot());
                }
            }
        };
        publisher.registerHandlerFor(TestStepFinished.class, eventHandler);
        super.setEventPublisher(publisher);
    }



    public static byte[] takeScreenshot() {
        return ( (TakesScreenshot) DriverManager.getDriverManager().getDriver() ).getScreenshotAs(OutputType.BYTES);
    }
}
