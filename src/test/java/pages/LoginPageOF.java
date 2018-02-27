package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOF {
    //create a variable to store driver obj
    private WebDriver driver;


    //page URL
    String url = "http://fits.qauber.com/#/page/login";

    //Locators
    @FindBy(name = "account_email")
    WebElement userNameTextBox;



    @FindBy(name = "account_password")
    WebElement passwordTextBox;

    public LoginPageOF(WebDriver d) {
        this.driver = d;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public LoginPageOF(){

    }


    //enter userName
    public void enterUserName(String uName){
        userNameTextBox.sendKeys(uName);
    }

    //enter password
    public void enterPassword(String passwd){
        passwordTextBox.sendKeys(passwd);
    }

    //submit
    public ReportsPage submitLogin(){
        passwordTextBox.submit();
        ReportsPage rp = new ReportsPage(driver);
        return rp;
    }




}
