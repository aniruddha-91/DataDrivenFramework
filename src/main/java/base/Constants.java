package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constants {
    public Constants() {

    }

    Properties prop = new Properties();


    public void setProperty() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        prop.load(fis);
    }

    public String getUrl() throws IOException {
        setProperty();
        String baseUrl = prop.getProperty("URL");
        return baseUrl;
    }

    public String getBrowser() throws IOException {
        setProperty();
        String browser = prop.getProperty("Browser");
        return browser;
    }

}
