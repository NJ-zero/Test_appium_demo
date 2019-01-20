import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class test {

    @ParameterizedTest
    @CsvSource({"拼多多","阿里巴巴"})
    public void test(String name){
        System.out.println(11);
        String s = String.format("//*[@text='%s']",name);
        System.out.println(s);
    }
}
