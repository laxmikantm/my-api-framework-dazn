package Utils;
/**************************
 *  (C) L Somni            *
 ***************************/

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Helper {

    public static final String URL = "https://fierce-gorge-81903.herokuapp.com";
    public static final String LOCAL_URL = "TBD";
    public static final String API = "/api";

    public static class ConfigurationException extends RuntimeException {

        public ConfigurationException(final String message) {
            super(message);
        }
    }

}


