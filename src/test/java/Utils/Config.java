package Utils;

public class Config {
    public static String appiumJSExecutor = "C:\\Users\\Krees\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
    public static String appiumServer = "127.0.0.1";
    public static int appiumPort = 4723;
    public static String appiumLog = "appium.log";
    public static long appiumServerTimeOut = 200;
    public String appiumURL() {
        return String.format("http://%s:%d", appiumServer, appiumPort);
    }

}
