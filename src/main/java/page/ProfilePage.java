package page;

import driver.android_driver;
import org.openqa.selenium.By;

public class ProfilePage {
    By login = By.xpath("//*[@text='登录雪球']");

    public LoginPage gotologin(){
        android_driver.getcurrentdriver().findElement(login).click();
        return new LoginPage();
    }

}
