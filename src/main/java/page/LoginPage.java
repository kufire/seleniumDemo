package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    By alertinfo=By.cssSelector(".alert");

    public String getalertinfo(){
        //获取警告字符串
        String content = find(alertinfo).getText();
        return content;
    }
}
