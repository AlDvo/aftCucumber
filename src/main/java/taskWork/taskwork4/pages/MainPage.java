package taskWork.taskwork4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@class = 'kitt-cookie-warning__close']")
    WebElement cookie;

    @FindBy(xpath = "//nav[contains(@class,'kitt-top-menu_icons')]")
    WebElement topMenu;

    @Step("Нажали кнопку Закрыть , в всплывающем окне куки")
    public MainPage closeCookie(){
        cookie.click();
        return this;
    }

    @Step("Выбрали пункт меню '{value}' ")
    public MainPage selectTopMenu(String value){
        topMenu.findElement(By.xpath(".//a[@aria-label = '"+value+"']")).click();
        return this;
    }

    @Step("Выбрали пункт подменю '{value}'")
    public CompleteHousePage selectSubMenu(String value){
        driverManager.getDriver().findElement(By.xpath(".//a[text() = '"+value+"']")).click();
        return new CompleteHousePage();
    }
}
