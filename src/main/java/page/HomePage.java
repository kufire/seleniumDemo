package page;

import driver.Driver;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    By teams = By.linkText("社团");

    public static HomePage start(){

        Driver.start();
        return new HomePage();
    }

    public TeamsPage gotoTeams(){
        //点击社团
        find(teams).click();
        return new TeamsPage();
    }
}
