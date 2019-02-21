package page;

import driver.Driver;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import driver.GlobalConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic("社区功能测试")
@Feature("社区话题接口测试")
public class TeamPageTest {

    static HomePage homePage;
    static TeamsPage teamsPage;
    static TeamPage teamPage;
    static LoginPage loginPage;

    @BeforeAll()
    public static void before(){
        homePage=HomePage.start();
    }


    @Story("查看话题测试")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("测试未登录点击话题")
    //@Issue("AG-Issue")
    //@Link("http://testerhome.com")
    //@TmsLink("AG-TmsLink")
    @Description("测试一个流程，用户未登录点击社团话题会跳转登录界面，并提示：用户没有登录")
    @Test
    public void testNologin(){

        GlobalConfig config= GlobalConfig.load("/data/globalConfig.yaml");
        //String content= homePage.gotoTeams().gotoTeam().gotoLogin().getalertinfo();

        String content=gotoLoginPage(gotoTeamPage(gotoTeamsPage(homePage))).getalertinfo();
        assertThat(content, equalTo(config.web.alertinfo));
    }

    @Step("进入 TOP 活跃团队 界面")
    private TeamsPage gotoTeamsPage(HomePage homepage) {
        return homepage.gotoTeams();
    }

    @Step("进入 霍格沃兹测试学院社团 界面 ")
    private TeamPage gotoTeamPage(TeamsPage teamspage) {
        return teamspage.gotoTeam();
    }
    @Step("点击 话题")
    private LoginPage gotoLoginPage(TeamPage teampage) {
        return teampage.gotoLogin();
    }
    @AfterAll()
    public static void after(){
        Driver.getCurrentDriver().quit();
    }
}
