package askomdch.utils;

import askomdch.dependencyinjection.UtilClass;
import org.openqa.selenium.WebDriver;


public class WebsiteStateManager {
    private final WebDriver driver;
    public WebsiteStateManager(WebDriver driver){
        this.driver = driver;
    }
    public void loadPage(String endPoint) {
        driver.get(UtilClass.SITEURL + endPoint);
        driver.manage().window().maximize();
    }
}
