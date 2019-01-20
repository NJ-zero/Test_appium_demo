package page;

import driver.android_driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    static WebElement find(By locator){
        try{
            return android_driver.getcurrentdriver().findElement(locator);
        }catch (Exception e){
            android_driver.getcurrentdriver().findElement(By.xpath("//*[@text='下次再说']")).click();
            return android_driver.getcurrentdriver().findElement(locator);
        }
    }

}
