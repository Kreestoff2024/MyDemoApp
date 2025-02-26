package Helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import Utils.Config;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
//import utils.Config;

public abstract class BasePage {

    AppiumDriverLocalService service;
    protected AndroidDriver driver;

    //lancer automatiquement le serveur appium
    public AppiumDriverLocalService startAppiumServer() {
        System.out.println("BeforeSuite");
        boolean running = isServerRunning(Config.appiumPort);
        if (!running) {
            service = new AppiumServiceBuilder()
                    .withAppiumJS(new File(Config.appiumJSExecutor))
                    .withIPAddress(Config.appiumServer)
                    .withLogFile(new File(Config.appiumLog))
                    .withTimeout(Duration.ofSeconds(Config.appiumServerTimeOut))
                    .usingPort(Config.appiumPort).build();
            service.start();
        }
        return service;
    }

    public boolean isServerRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSock;
        try {
            serverSock = new ServerSocket(port);
            serverSock.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSock = null;
        }
        return isServerRunning;
    }

    @SuppressWarnings("deprecation")
    public void emulatorDriver() throws MalformedURLException, InterruptedException {
        System.out.println("BeforeMethod");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
        options.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "15");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:deviceName", "emulator-5554");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //démarer automatiquement le device
    public void startDevice() throws InterruptedException{
        System.out.println("BeforeClass");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "C:\\Users\\Krees\\AppData\\Local\\Android\\Sdk\\emulator\\emulator.exe -avd Pixel_9_Pro_XL_API_35 -netdelay none -netspeed full");

        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void stop(){
        driver.quit();
    }
}
