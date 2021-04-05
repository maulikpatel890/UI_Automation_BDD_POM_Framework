package com.ipl.steps.pointTable;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.PointTablePage;
import util.Log;
import util.TestUtils;

import static pages.PointTablePage.*;

public class PointTableSteps extends BaseClass {
    PointTablePage pointTablePage = new PointTablePage();

    TestUtils testUtils = new TestUtils();

    @When("User visits the ipl season 2020 men's point table page")
    public void openTestUrl() {
        driver.get(testUrl);
        Assert.assertTrue(testUtils.isElementPresent("tagName",pointTable_tagName));
    }

    @Then("User should see the point of every team and able to sum the points of all teams")
    public void verifyPointsOfTeamAndTotalPoints() {
        String fullNameOfTeam;
        int pointsOfTeam;
        int totalPoints = 0;

        pointTablePage.getTableBody = pointTablePage.pointTable.findElement(By.tagName(pointTableBody_tagName));
        pointTablePage.totalRowsList = pointTablePage.getTableBody.findElements(By.tagName(pointTableRow_tagName));

        //Skipping Header row of the table - rowNumber starts with 1
        for(int rowNumber=1; rowNumber<pointTablePage.totalRowsList.size();rowNumber++){
            //Get Total Columns of the table
            pointTablePage.totalColumnsList = pointTablePage.totalRowsList.get(rowNumber)
                    .findElements(By.tagName(pointTableColumn_tagName));

            //Get Team Name - Column # is 1
            pointTablePage.teamName = pointTablePage.totalColumnsList.get(1)
                    .findElement(By.tagName("a")).findElement(By.tagName("span"));
            fullNameOfTeam = pointTablePage.teamName.getAttribute("innerText");

            //Get Point of the team -  Column # is 10
            pointsOfTeam = Integer.parseInt(pointTablePage.totalColumnsList.get(10).getText());
            Log.info("The points of '"+fullNameOfTeam+"' in the table is : " + pointsOfTeam);

            //Summing up the points of team
            totalPoints+= pointsOfTeam;
        }

        Log.info("The Total points of all teams are : "+ totalPoints);
    }
}
