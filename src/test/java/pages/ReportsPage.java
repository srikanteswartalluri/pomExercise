package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportsPage {
    //webdriver
    private WebDriver driver;

    //Locators
    By header = By.xpath("/html/body/div[2]/section/div/h3");

    public ReportsPage(WebDriver driver) {
        this.driver = driver;
    }


    //get the text of the header
    public String getHeaderText(){
        String headerText;
        //find the header which has 'reports' text
        WebElement element = driver.findElement(header);
        //get the header text and store it in the string
        headerText = element.getText();
        //return the header text
        return headerText;
    }


}
