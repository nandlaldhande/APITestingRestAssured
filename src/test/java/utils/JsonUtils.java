package utils;

import gherkin.deps.com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class JsonUtils {

    private static Gson gson = new Gson();

    public static Map getExpectedJsonObjectForGivenFile(String fileAdsress)throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/expectedResuts/"+fileAdsress+".json"));
        return gson.fromJson(reader, Map.class);
    }

    public static Map getActualJsonObject(String response) {
        return gson.fromJson(response, Map.class);
    }

}
