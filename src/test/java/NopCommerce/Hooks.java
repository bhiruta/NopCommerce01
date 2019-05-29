package NopCommerce;

import cucumber.api.java.Before;
import org.junit.After;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks extends Utils {


    BrowserSelector browserSelector = new BrowserSelector();
    static String timestamp = new SimpleDateFormat("dd.mm.yy.HH.mm.ss").format(new Date());

    @Before
    public void setUpBrowser(){
        browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");
    }
    @After
    public void closeBrowser() {
        driver.close();

    }

}



