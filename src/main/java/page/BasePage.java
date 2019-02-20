package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import driver.Driver;
import java.util.List;

public class BasePage {

    static WebElement find(By locator){
        return Driver.getCurrentDriver().findElement(locator);
    }

    static List<WebElement> finds(By locator){
        return Driver.getCurrentDriver().findElements(locator);
    }

    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }
    static By text(String content){
        return By.xpath("//*[@text='"+ content + "']");
    }

}
