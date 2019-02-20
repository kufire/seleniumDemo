package page;

import org.openqa.selenium.By;

public class TeamPage extends BasePage{

    By topics=By.xpath("//*[@class='page-users']//*[@class='title media-heading']/a");


    public LoginPage gotoLogin(){
        //点击话题列表中的第一个
        finds(topics).get(0).click();
        return new LoginPage();
    }
}
