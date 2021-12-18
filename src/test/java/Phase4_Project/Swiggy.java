package Phase4_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Swiggy {
	
	static AndroidDriver<MobileElement> driver;	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Output");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		//		Desired Capability
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("appPackage", "in.swiggy.delivery");
		cap.setCapability("appActivity", "in.swiggy.delivery.activities.MainActivity");
		
		//        AndroidDriver
		driver = new AndroidDriver<MobileElement>(url, cap);
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SessionId sessionId = driver.getSessionId();
		System.out.println("\nsessionId :"+sessionId);
		System.out.println("\nWait for Sleep\n");
		Thread.sleep(1000);
		String locValue = "//android.widget.Button[@text='Enter Your DE ID']";
		checkAndClick(locValue);
		Thread.sleep(1000);
		//android.widget.Button[@text='Continue']

		locValue = "//android.widget.Button[@text='1']";
		checkAndClick(locValue);
		Thread.sleep(1000);
		locValue = "//android.widget.TextView[@text='2']";
		checkAndClick(locValue);
		Thread.sleep(1000);
		locValue = "//android.widget.TextView[@text='3']";
		checkAndClick(locValue);
		Thread.sleep(5000);
		locValue = "//android.widget.TextView[@text='4']";
		checkAndClick(locValue);
		Thread.sleep(4000);
		locValue = "//android.widget.TextView[@text='SUBMIT']";
		checkAndClick(locValue);
		Thread.sleep(4000);
		clickView("Controls");
		clickView("01. Light Theme");
	}
	private static void checkAndClick(String locValue) {
		List<MobileElement> lstElems = driver.findElements(By.xpath(locValue));
		if (lstElems.size()>0) {
			lstElems.get(0).click();
		}
	}
		private static void clickView(String elemClick){
			MobileElement parent = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"));
			List<MobileElement> lstViews = parent.findElements(By.xpath("//android.widget.TextView"));
			for (MobileElement view : lstViews) {
				System.out.println(view.getAttribute("text"));
				if (view.getAttribute("text").equals(elemClick)) {
					view.click();
					break;
				}
			}
		}
	
}
