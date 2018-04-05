package com.orbitz.tests;


import java.util.Map;

import org.testng.annotations.Test;
import com.orbitz.pages.FlightstPageInfo;
import com.orbitz.pages.SearchResultsFlightsPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FlightsPageTestCase_101 extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "resources/data.csv")
	@Test
	public void executionFlightsPage(Map<String, String> data) throws Exception {

		FlightstPageInfo flights = new FlightstPageInfo();
		flights.launch();
		flights.clickOnFlightsOnlyButton();
		flights.clickOnOneWay();
		flights.setFlightOrigin(data.get("source"));
		flights.setFlightDestination(data.get("destination"));
		flights.selectDate();
		flights.clickOnSearchButton();
		SearchResultsFlightsPage resultPage = new SearchResultsFlightsPage();
		resultPage.waitForPageToLoad();
		resultPage.selectFlightByIndex(0);

	}

}
