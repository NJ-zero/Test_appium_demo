package page;

import org.openqa.selenium.By;

import driver.android_driver;

public class MainPage extends BasePage {
    By profile= By.id("user_profile_icon");
    By search= By.id("home_search");

    public static MainPage start(){
        android_driver.start();
        return  new MainPage();
    }

    public ProfilePage getprofile(){
        android_driver.getcurrentdriver().findElement(profile).click();
        return new ProfilePage();
    }

    public SearchPage gotosearch(){
        find(search).click();
        return new SearchPage();
    }

    public ZixuanPage gotozixuan(){
        android_driver.getcurrentdriver().findElement(By.xpath("//*[@text='自选']")).click();
        return new ZixuanPage();
    }
}
