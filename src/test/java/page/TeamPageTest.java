package page;

import driver.Driver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import driver.GlobalConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamPageTest {

    static HomePage homePage;


    @BeforeAll()
    public static void before(){
        homePage=HomePage.start();
    }

    @Test
    public void testNologin(){

        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        String content= homePage.gotoTeams().gotoTeam().gotoLogin().getalertinfo();
        assertThat(content, equalTo(config.web.alertinfo));

    }

    @AfterAll()
    public static void after(){
        Driver.getCurrentDriver().quit();
    }
}
