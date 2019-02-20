package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;
    public static void start(){
        //导入配置文件
        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        //设置浏览器最大化
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //启动chrome浏览器
        driver = new ChromeDriver(options);

        //在浏览器中键入网址
        driver.get(config.web.url);
        driver.manage().timeouts().implicitlyWait(config.web.wait, TimeUnit.SECONDS);
    }

    public static WebDriver getCurrentDriver(){
        return driver;
    }
}
