package taskWork.taskwork4.manager;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import taskWork.taskwork4.util.TestPropertis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    /**
     * Переменна для хранения объекта веб-драйвера
     *
     * @see WebDriver
     */
    private WebDriver driver;


    /**
     * Переменна для хранения объекта DriverManager
     */
    private static DriverManager INSTANCE = null;


    /**
     * Менеджер properties
     *
     * @see TestPropertis#getTestPropertis()
     */
    private final TestPropertis testPropertis = TestPropertis.getTestPropertis();


    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see DriverManager#getDriverManager()
     */
    private DriverManager() {
    }

    /**
     * Метод ленивой инициализации DriverManager
     *
     * @return DriverManager - возвращает DriverManager
     */
    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    /**
     * Метод ленивой инициализации веб драйвера
     *
     * @return WebDriver - возвращает веб драйвер
     */
    public WebDriver getDriver() {
        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver",testPropertis.getProperty("webdriver.chrome.driver"));
//            driver = new ChromeDriver();
//            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
            switch (testPropertis.getProperty("browser")) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", testPropertis.getProperty("webdriver.gecko.driver"));
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("incognito");
                    options.addArguments("--disable-notifications");
                    System.setProperty("webdriver.chrome.driver", testPropertis.getProperty("webdriver.chrome.driver.windows"));
                    driver = new ChromeDriver(options);
                    break;
                case "remote":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    capabilities.setVersion("73.0");
                    capabilities.setCapability("enableVNC", true);
                    capabilities.setCapability("enableVideo", false);
                    try {
                        driver = new RemoteWebDriver(
                                URI.create("http://selenoid.appline.ru:4445/wd/hub/").toURL(),
                                capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    Assertions.fail("Типа браузера '" + testPropertis.getProperty("browser") + "' не существует во фреймворке");
            }
        }

        return driver;
    }

    /**
     * Метод для закрытия сессии драйвера и браузера
     *
     * @see WebDriver#quit()
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
