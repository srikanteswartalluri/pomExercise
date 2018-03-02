import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobileTestsIOSAppBS {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("device", "iPhone X");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("automationName", "XCUITest");

        capabilities.setCapability("platformVersion", "11.0");
       // capabilities.setCapability("udid", "C02KG0VMDRVF");
        //capabilities.setCapability("browserName", "Safari");
        capabilities.setCapability("app","/Users/talluri/Downloads/WordPressSample.ipa");
        capabilities.setCapability("fullReset", "true");
//        capabilities.setCapability("fullReset", "true");
        WebDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement loginButton = driver.findElement(By.id("Log In"));
        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );
        loginButton.click();

        wait = new WebDriverWait(driver, 30);
        WebElement  emailTextField= driver.findElement(By.id("Email address"));
        wait.until(
                ExpectedConditions.elementToBeClickable(emailTextField));
        emailTextField.sendKeys("hello@browserstack.com");

        driver.findElement(By.id("Next")).click();
        Thread.sleep(5000);

        List<WebElement> textElements = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));
        assert(textElements.size() > 0);
        String matchedString = "";
        for(WebElement textElement : textElements) {
            String textContent = textElement.getText();
            if(textContent != null && textContent.contains("not registered")) {
                matchedString = textContent;
            }
        }

        System.out.println(matchedString);
        assert(matchedString.contains("not registered on WordPress.com"));

        driver.quit();
    }
}
