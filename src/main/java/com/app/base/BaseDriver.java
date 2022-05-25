package com.app.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
    public static AndroidDriver<AndroidElement> driver;
    public static AppiumDriverLocalService service;

    /*
    * This is used to initialize the appium server
    * when the test execution starts
    * */
    public AppiumDriverLocalService initializeServer() {
        try {
            if (!verifyAppiumServerState(4723)) {
                service = AppiumDriverLocalService.buildDefaultService();
                service.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

    /*
    * This is base engine where all the desired capabilities are set
    * and properties are loaded from global.properties file
    * */
    public static AndroidDriver<AndroidElement> capabilities() {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/conf/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            //triggerEmulator();
            File appPath = new File(String.valueOf(prop.get("applicationPath")));
            File appName = new File(appPath, String.valueOf(prop.get("application")));
            DesiredCapabilities cap = new DesiredCapabilities();
            if (System.getProperty("deviceName") != null) {
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, System.getProperty("deviceName"));
            } else {
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, String.valueOf(prop.get("device")));
            }
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.APP, appName.getAbsolutePath());
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
            driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;
    }

    /*
    * This is used to check if appium server is in a running state
    * */
    public static boolean verifyAppiumServerState(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    /*
    * This can be used to trigger the emulator but this is not currently
    * used in the framework
    * */
    public static void triggerEmulator() {
        try {
            Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/resources/TriggerEmulator.bat");
            Thread.sleep(30000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    * This is used to take the screenshot of the application while
    * execution is further integrated with the listeners
    * */
    public static void getScreenshot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + name + "_" + System.currentTimeMillis() + ".png"));
    }
}
