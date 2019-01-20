import driver.android_driver;
import io.appium.java_client.TouchAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import page.MainPage;
import page.SearchPage;
import page.ZixuanPage;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZixuanTest {

    static MainPage mainPage;
    static SearchPage searchPage;
    static ZixuanPage zixuanpage;

    @BeforeAll
    public static void before(){
        mainPage=MainPage.start();
        zixuanpage=mainPage.gotozixuan();

    }

    @ParameterizedTest
    @CsvSource({"alibaba,阿里巴巴",
                "qtt,趣头条",
                "pdd,拼多多"
    })
    public void add(String stockname,String cn_name) {
        SearchPage searchPage = zixuanpage.gotosearch();
        searchPage.add(stockname);
        zixuanpage = searchPage.cancletozixuan();
        ArrayList<String> stocks=new ArrayList<String>();
        stocks =zixuanpage.getall();
        assertTrue(stocks.contains(cn_name));

    }

    @ParameterizedTest
    @CsvSource({"阿里巴巴",
            "趣头条",
            "拼多多"})
    public void cancel(String name){
        zixuanpage.canceladd(name);
    }
}
