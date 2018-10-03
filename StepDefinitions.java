package stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;


public class StepDefinitions {
	
	private static WindowsDriver driver = null;
	
	@Given("^I have opened the Notepad application$")
	public void i_have_opened_the_Notepad_application() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Windows\\System32\\Notepad.exe");
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName ", "WindowsPC");           
        driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);      
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);       
        driver.findElementByName("Text Editor").sendKeys("This is a WinAppDriver test");
        Assert.assertEquals("This is a WinAppDriver test",driver.findElementByName("Text Editor").getText());
        driver.findElementByName("File").click();
        //driver.findElementByName("Save As...").click();
        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("1001").sendKeys("Test File.txt");
        driver.findElementByName("Save").click();
        driver.findElementByName("Yes").click();
        driver.findElementByName("Close").click(); 
	}

}
