package utils;

import io.cucumber.datatable.DataTable;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {
    private static Map<String, String> configMap = new HashMap<>();

    public static void setConfig(DataTable table) {
        configMap = table.asMap(String.class, String.class);
    }

    public static String get(String key) {
        return configMap.get(key);
    }
}
