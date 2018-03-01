import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileTestsIOSApp {
    public static void main(String[] args) throws MalformedURLException {
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
        //System.out.println(driver.getTitle());
        //Click on number 2 button.
       // driver.findElement(By
             //   .xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.Button[5]"))
            //    .click();

//        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
//
////        // Click on + button.
////        driver.findElement(By
////                .xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.view.View[2]/android.widget.Button[5]"))
////                .click();
//        driver.findElement((By.id("com.android.calculator2:id/op_add"))).click();
//
//        // Click on number 5 button.
////        driver.findElement(By
////                .xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.Button[2]"))
////                .click();
//         driver.findElement(By.id("com.android.calculator2:id/digit_2")).click();
//        // Click on = button.
////        driver.findElement(By
////                .xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.Button[12]"))
////                .click();
//        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
//
//        // Get result from result text box.
////        String result = driver
////                .findElement(By
////                        .xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.EditText[1]"))
////                .getText();
//        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
//
//        System.out.println("Number sum result is : " + result);
    }
}
