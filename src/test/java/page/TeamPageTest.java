package page;

import driver.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import driver.GlobalConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamPageTest {

    static HomePage homePage;
/*
    @BeforeAll
    public static void beforeAll(){
        homePage=HomePage.start();
    }*/

    @Test
    public void testNologin(){
        homePage=HomePage.start();
        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        String content= homePage.gotoTeams().gotoTeam().gotoLogin().getalertinfo();
        assertThat(content, equalTo(config.web.alertinfo));
        Driver.getCurrentDriver().quit();

    }
/*
    @AfterAll
    public static void afterAll(){
        Driver.getCurrentDriver().quit();
    }*/
}
