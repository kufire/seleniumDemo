package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class TeamsPage extends BasePage{

    By team=By.xpath("//*[@href='/hogwarts']");

    public TeamPage gotoTeam(){
        //点击霍格沃兹测试学院
        find(team).click();
        return new TeamPage();
    }
}
