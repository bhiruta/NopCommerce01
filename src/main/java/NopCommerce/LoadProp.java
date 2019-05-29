package NopCommerce;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProp {

        static Properties prop;
        static FileInputStream input;
        static String fileName = "TestDataConfig.properties";
        static String fileLocation = "src\\test\\TestData\\";


        public String getProperty(String key) {
            prop = new Properties();
            try {
                input = new FileInputStream(fileLocation + fileName);
                prop.load(input);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prop.getProperty(key);
        }

    }
