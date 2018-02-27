package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    //webdriver
    private WebDriver driver;


    //page URL
    String url = "http://fits.qauber.com/#/page/login";
    //Locators
    //username input box
    By userName = By.name("account_email");
    //password input box
    By password = By.name("account_password");
    //login button
    By login = By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/form/button");
    //forgot password link
    By forgotPasswordLink = By.partialLinkText("Forgot");
    //register button
    By register = By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/a");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
    }

    //enter username
    public void enterUserName(String uName){
        WebElement element = driver.findElement(userName);
        element.sendKeys(uName);
    }

    //enter password
    public void enterPassword(String passwd){
        WebElement element = driver.findElement(password);
        element.sendKeys(passwd);
    }

    //submit login
    public ReportsPage submitLogin(){
        WebElement element = driver.findElement(password);
        element.submit();
        //create a new object for reports page
        ReportsPage rp = new ReportsPage(driver);
        //return the reports page object
        return rp;
    }









}
