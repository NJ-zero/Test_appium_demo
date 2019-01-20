package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;

public class Config {

    public String username ;
    public String password ;
    public String url;
    public HashMap<String, Object> capabilitilies = new HashMap<String, Object>();

    public static Config load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            Config conf = mapper.readValue(Config.class.getResource(path), Config.class);
            return conf;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
}


}
