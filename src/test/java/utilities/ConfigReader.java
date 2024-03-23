package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //property objesi oluşturuldu javadan configuration dosyasındaki dataları okumak için

    private static Properties properties;

    //statik blok classta ilk çalışır.
    static {
        //configuration dosyasının yolunu aldık
        String path="configuration.properties";

        //dosyayı akışa alıyoruz.sonra properties objesi ile   yüklüyoruz.
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    //key verip value alacağımız metod oluşturalım
    public static String getProperty(String key){

        return properties.getProperty(key);
    }

    public static void main(String[] args) {

        System.out.println(properties.getProperty("url_test_digiturk"));
    }
}
