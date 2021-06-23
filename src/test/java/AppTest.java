import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {

    private URL url;
    private DesiredCapabilities capabilities;
    private IOSDriver<IOSElement> driver;

    @BeforeSuite
    public void setup() throws MalformedURLException {
        String urlStr = "http://127.0.0.1:4723/wd/hub";
        url = new URL(urlStr);

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/marcelo/Documents/Repos/ios/test-appium-ios/build/Release-iphonesimulator/test-appium-ios.app");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

        driver = new IOSDriver<IOSElement>(url, capabilities);
    }

    @AfterSuite
    public void uninstallApp() throws InterruptedException {
//        driver.removeApp("cit.test-appium-ios");
    }

    @Test
    public void execTest() throws InterruptedException{
        driver.findElement(By.name("textFieldValue1")).setValue("2");
        driver.findElement(By.name("textFieldValue2")).setValue("2");
        driver.findElement(By.name("buttonCalc")).click();
    }

}
