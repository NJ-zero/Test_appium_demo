package page;

import driver.android_driver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By other = By.xpath("//*[@text='手机及其他登录']");
    By loginbypwd = By.xpath("//*[@text='邮箱手机号密码登录']");
    By phone = By.id("login_account");
    By pwd = By.id("login_password");
    By login = By.id("button_next");
    By msg = By.id("md_content");


    String message;
    public LoginPage loginfail(String phone,String pwd){
        find(other).click();
        find(loginbypwd).click();
        find(this.phone).sendKeys(phone);
        find(this.pwd).sendKeys(pwd);
        find(By.id("button_next")).click();

        message=android_driver.getcurrentdriver().findElement(msg).getText();
        find(By.id("md_buttonDefaultPositive")).click();

        return this;
    }

    public String getmsg(){
        return message;
    }

    public MainPage loginpass(String phone,String pwd){
        android_driver.getcurrentdriver().findElement(other).click();
        android_driver.getcurrentdriver().findElement(loginbypwd).click();
        android_driver.getcurrentdriver().findElement(this.phone).sendKeys(phone);
        android_driver.getcurrentdriver().findElement(this.pwd).sendKeys(pwd);
        android_driver.getcurrentdriver().findElement(login).click();

        return new MainPage();
    }


    public ProfilePage backtoprofile(){
        find(By.xpath("//*[contains(@resource-id, 'iv_close') or contains(@resource-id, 'iv_action_back')]")).click();
        return new ProfilePage();

    }
}
