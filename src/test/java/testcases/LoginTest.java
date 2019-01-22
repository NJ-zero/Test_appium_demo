package testcases;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;



public class LoginTest {

    static MainPage mainPage;
    static ProfilePage profilePage;

    @BeforeAll
    public static void before(){
        mainPage=MainPage.start();
        profilePage=mainPage.getprofile();

    }

    @ParameterizedTest
    @CsvSource({
            "15122389122,111aaasdd,用户名或密码错误",
            "2189705, 1233qwwwf, 手机号码填写错误"
    })
    public void test_login1(String phone,String pwd,String res){
//        MainPage mainPage = MainPage.start();
//        ProfilePage profilePage = mainPage.getprofile();
        LoginPage loginPage = profilePage.gotologin();
        loginPage.loginfail(phone,pwd);
        assertThat(loginPage.getmsg(),equalTo(res));
        profilePage=loginPage.backtoprofile();


    }
}
