package taskWork.taskwork4.pages;

import taskWork.taskwork4.manager.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import taskWork.taskwork4.manager.PageManager;


public class BasePage {
    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 10,1000);
    protected PageManager pageManager = PageManager.getPageManager();


    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    protected void scrollToElementJs(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
