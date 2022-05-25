package com.app.data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    /*
    * This data is used to send the team name
    * so user can navigate to the team home page
    * */
    @DataProvider(name = "searchData")
    public Object[][] getSearchData() {
        Object[][] obj = new Object[][]{
                {"Arsenal"},{"New York Knicks"}
        };
        return obj;
    }

    /*
    * This is used to setup the base team when user
    * starts the application
    * */
    @DataProvider(name = "selectTeamData")
    public Object[][] getSelectTeam() {
        Object[][] obj = new Object[][]{
                {"Arsenal"}
        };
        return obj;
    }
}
