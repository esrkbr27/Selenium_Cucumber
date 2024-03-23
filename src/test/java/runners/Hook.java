package runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hook {

    @Before
    public void setUp() {

        System.out.println("Before run");

    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After çalıştı");

        //   Eger bir Scenario FAIL ederse, ekran goruntusunu al ve rapora ekle
        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//                       ekran goruntusu    file tipi                  ekran goruntusunun adi
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());

      //      Driver.closeDriver(); // Burasi tarayici kapatir

        }
    }
}
