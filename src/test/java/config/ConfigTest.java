package config;

import org.junit.jupiter.api.Test;

class ConfigTest {
    @Test
    void test(){
        Config conf = Config.load("/data/basic.yaml");
        System.out.println(conf.username);
        System.out.println(conf.capabilitilies);

        Config search = Config.load("/data/testdata.yaml");
        System.out.println(search.input);


    }

}