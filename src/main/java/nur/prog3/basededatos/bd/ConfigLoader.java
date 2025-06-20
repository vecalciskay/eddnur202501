package nur.prog3.basededatos.bd;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {


    private static final String CONFIG_FILE_PATH = "src/main/resources/";
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    static {
        properties = new Properties();

        File file = new File(CONFIG_FILE);
        if(!file.exists()){
            file = new File(CONFIG_FILE_PATH + CONFIG_FILE);
        }

        try (FileInputStream input = new FileInputStream(file.getAbsoluteFile())) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("❌ Error cargando el archivo de configuración: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

