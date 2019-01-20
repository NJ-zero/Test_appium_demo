package page;

import driver.android_driver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ZixuanPage extends BasePage {

    public SearchPage gotosearch(){
        find(By.id("action_create_cube")).click();
        return new SearchPage();
    }

    public ZixuanPage canceladd(String name){
        TouchAction action = new TouchAction(android_driver.getcurrentdriver());
        String text = String.format("//*[@text='%s']",name);
        WebElement added = android_driver.getcurrentdriver().findElement(By.xpath(text));
        action.longPress(added).release().perform();
        find(By.xpath("//*[@text='删除']")).click();
        return this;
    }

    public ArrayList<String> getall(){
        ArrayList<String> array = new ArrayList<String>();
        for(WebElement e:android_driver.getcurrentdriver().findElements(By.id("portfolio_stockName"))){
            array.add(e.getText());
        }
        return array;
    }

}
