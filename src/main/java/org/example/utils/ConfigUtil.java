package org.example.utils;

import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigUtil {
    private static String root = PackageListUtils.class.getClassLoader().getResource("").getPath();
    private static String seperator = File.separator;

    public static Map<String, Object> getConfig() {
        String filename = root + seperator + "jweb.yaml";
        File file = new File(filename);
        
        if (!file.exists()) {
            Map<String, Object> map = new HashMap<>();
            map.put("server", "jetty");
            map.put("port", 5200);
            return map;
        }

        try {
            InputStream input = new FileInputStream(file);
            Yaml yaml = new Yaml();
            if (yaml == null) {
                Map<String, Object> map = new HashMap<>();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
