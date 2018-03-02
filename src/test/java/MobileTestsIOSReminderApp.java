import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileTestsIOSReminderApp {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("device", "iPhone X");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("automationName", "XCUITest");

        capabilities.setCapability("platformVersion", "11.0");
       // capabilities.setCapability("udid", "C02KG0VMDRVF");
        //capabilities.setCapability("browserName", "Safari");
        capabilities.setCapability("bundleId","com.apple.reminders");

        capabilities.setCapability("fullReset", "true");
        WebDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        //driver.get("http://www.google.com");
        driver.findElement(By.id("Add")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Reminder\"]")).click();
        driver.findElement(By.xpath("(//XCUIElementTypeTextView[@name=\"AXReminderNotesIdentifier\"])[1]")).sendKeys("new reminder");
        driver.findElement(By.id("Done")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Reminders\"]")).click();
        String result = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"new reminder\"]")).getAttribute("label");
        System.out.println("result is " + result);

        //driver.findElement(By.name("q")).sendKeys("IOS test");


    }
}
