package testcases;

import config.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;
import page.SearchPage;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @ParameterizedTest
    @MethodSource("Getyaml")
    public void searchbyyaml(String en,String cn){
        System.out.println(en);
        System.out.println(en);
        String res = searchPage.search(en).getall().get(0);

    }

    static Stream<Arguments> Getyaml() {
        Config conf = Config.load("/data/testdata.yaml");
        return Stream.of(arguments(conf.input.get(0),conf.exp.get(0)),
                        arguments(conf.input.get(1),conf.exp.get(1)));
    }

}
