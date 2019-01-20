package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class android_driver {

    private static AndroidDriver<WebElement> driver;

    public static void start(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".common.MainActivity");
        desiredCapabilities.setCapability("deviceName", "192.168.56.101:5555");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability("noReset", "true");
        URL remoteUrl = null;
        try{
            remoteUrl = new URL("http://localhost:4723/wd/hub");

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public static AppiumDriver<WebElement> getcurrentdriver(){
        return driver;
    }


}
