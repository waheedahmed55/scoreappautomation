package com.app.tests.smokesuite;

import com.app.base.BaseDriver;
import com.app.data.TestDataProvider;
import com.app.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class ScoreSmokeTest extends BaseDriver {

    WelcomePage welcomePage;
    PreferenceSelectionPage preferenceSelectionPage;
    PermissionsPage permissionsPage;
    TeamHomePage teamHomePage;
    AppHomePage appHomePage;
    TeamSelectionPage teamSelectionPage;
    CommonActionsPage commonActionsPage;

    public ScoreSmokeTest() {
        super();
    }

    /*
    * Server is initialized over here along with
    * desired capabilities and all the pages are
    * instantiated over here
    * */
    @BeforeClass
    public void setup() {
        service = initializeServer();
        driver = capabilities();
        welcomePage = new WelcomePage(driver);
        preferenceSelectionPage = new PreferenceSelectionPage(driver);
        permissionsPage = new PermissionsPage(driver);
        teamHomePage = new TeamHomePage(driver);
        appHomePage = new AppHomePage(driver);
        teamSelectionPage = new TeamSelectionPage(driver);
        commonActionsPage = new CommonActionsPage(driver);
    }
    /*
    * This is used to setup the basic application
    * so the required test case can be executed
    * */
    @Test(priority = 1, dataProvider = "selectTeamData", dataProviderClass = TestDataProvider.class)
    public void InitializeApplication(String selectTeam){
        welcomePage.clickOnGetStarted();
        commonActionsPage.clickOnSelectionDone();
        //permissionsPage.clickOnAllowLocation();
        permissionsPage.clickOnLocationMaybeLater();
        //permissionsPage.clickOnAllowWhileUsingApp();
        teamSelectionPage.clickOnTeamSearchBox();
        commonActionsPage.typeInSearchBoxText(selectTeam);
        commonActionsPage.clickOnTeamSelect();
        teamSelectionPage.clickOnTeamSelectContinue();
        commonActionsPage.clickHeaderText();
        commonActionsPage.clickOnSelectionDone();
        commonActionsPage.clickOnClosePopup();
    }

    /*
     * This is used to search and verify the
     * team screen is opening and user is able
     * to navigate to team stats and back to
     * home screen
     * */
    @Test(priority = 2, dataProvider = "searchData", dataProviderClass = TestDataProvider.class)
    public void ScoreTest(String searchTeam){
        appHomePage.clickOnSearchTextView();
        commonActionsPage.typeInSearchBoxText(searchTeam);
        teamHomePage.clickOnTeamSearchSelect();
        Assert.assertTrue(teamHomePage.isTeamNameDisplayed());
        teamHomePage.clickOnTeamStatsTab();
        Assert.assertTrue(teamHomePage.isTeamStatsHeaderTextDisplayed());
        commonActionsPage.clickOnNavigateBack();
        commonActionsPage.clickOnNavigateBack();
        Assert.assertTrue(appHomePage.verifyTeamViewDisplayed());
    }

    @AfterClass
    public void tearDown() {
        service.stop();
    }

}
