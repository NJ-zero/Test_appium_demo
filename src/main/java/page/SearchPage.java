package page;

import driver.android_driver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage{

    public SearchPage search(String key){
        find(By.className("android.widget.EditText")).sendKeys(key);
        return this;
    }


    public MainPage cancle(){
        android_driver.getcurrentdriver().findElement(By.id("action_close")).click();
        return new MainPage();
    }

    public ArrayList<String> getall(){
        ArrayList<String> array = new ArrayList<String>();
        for(WebElement e:android_driver.getcurrentdriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;
    }

    public ZixuanPage cancletozixuan(){
        /*
        返回自选页
         */
        find(By.id("action_close")).click();
        return new ZixuanPage();

    }

    public SearchPage add(String key){
        find(By.className("android.widget.EditText")).sendKeys(key);
        android_driver.getcurrentdriver().findElements(By.id("follow_btn")).get(0).click();
        return this;
    }



}
