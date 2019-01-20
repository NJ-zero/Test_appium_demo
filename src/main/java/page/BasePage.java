package page;

import driver.android_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    static WebElement find(By locator){

        return android_driver.getcurrentdriver().findElement(locator);
    }

}
