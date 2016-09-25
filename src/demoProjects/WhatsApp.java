package demoProjects;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;


public class WhatsApp {

    private static RemoteWebDriver driver;

    public static void main(String[] args){

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", "ZX1D22TX8F");
        capabilities.setCapability("platformVersion", "6.0.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.contacts");
        capabilities.setCapability("appActivity", "com.android.contacts.activities");

        //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), );
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

    }
}
