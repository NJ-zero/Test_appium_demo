import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    public static void before(){
        mainPage=MainPage.start();
        searchPage=mainPage.gotosearch();

    }

    @ParameterizedTest
    @CsvSource({
            "pdd,拼多多","alibaba,阿里巴巴"
    })
    public void search(String key,String name){
        String res = searchPage.search(key).getall().get(0);
        assertThat(res,equalTo(name));
    }

    @ParameterizedTest
    @CsvFileSource(resources="/data/SearchTest.csv")
    public void searchbycsv(String en,String cn){
        System.out.println(en);
        System.out.println(cn);
        String res = searchPage.search(en).getall().get(0);
    }

}
