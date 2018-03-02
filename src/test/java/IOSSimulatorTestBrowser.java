import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IOSSimulatorTestBrowser {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("device", "iPhone X");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("automationName", "XCUITest");

        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("browserName", "Safari");
        //capabilities.setCapability("fullReset", "true");
        //create driver object
        WebDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("test ios");
        driver.findElement(By.name("q")).submit();
        System.out.println(driver.getTitle());





    }
}
