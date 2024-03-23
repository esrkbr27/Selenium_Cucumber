package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    //Driver classında WebDriver driver Singleton pattern prensibine göre oluşturulur.Frameworkte tek bir driver kullanmak için
    //private; her yerde extend yapmadan çağırmak içide static olaral tanımlandı.

    private Driver(){
    }

    //getDriver methodu oluşturuyoruz driverı tanımlamak için
    static WebDriver driver;
    public static  WebDriver getDriver(){

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    /* notification popup kapatmak icin asagidaki kod kullanilir
                    Map<String, Object> prefs= new HashMap<String, Object>();

                    //onay vermek icin 1, reddetmek icin 2
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    ChromeOptions options=new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);
                    driver=new ChromeDriver(options);
                     */

                    //asagideki 3 satirdaki kodlar testleri Headless (Jenkins gibi) kosmak istedigimiz yerlerde aktive edilebilir
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless"); // Başsız modu etkinleştir
                    options.addArguments("--disable-gpu"); // GPU kullanımını devre dışı bırak
                    // driver = new ChromeDriver(options); bu satir yorumdan kalkarsa, alt satir yoruma alinirsa headless calisir.
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
                    break;
                case "edge":

                    driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
                    break;
                case "chrome-headless":

                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    //bu secenekte chrome acilmadan test kosulur
                    break;
                default:

                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;
    }


    //driver eğer kullanılıyorsa null değilse kapatmak için close driver metodu oluşturuldu
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
