package config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {
    @Test
    void test(){
        Config conf = Config.load("/data/basic.yaml");
        System.out.println(conf.username);
        System.out.println(conf.capabilitilies);


    }

}