package com.orbitz.tests;


import org.testng.annotations.Test;
import com.orbitz.pages.FlightstPageInfo;
import com.orbitz.pages.SearchResultsFlightsPage;
import com.orbitz.utils.FlightsPageData;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FlightsPageTestCase_101 extends WebDriverTestCase {

	@Test
	public void executionFlightsPage() throws Exception {

		FlightstPageInfo flights = new FlightstPageInfo();
		flights.launch();
		flights.clickOnFlightsButton();
		flights.clickOnFlightsOnlyButton();
		flights.clickOnOneWay();
		// flights.clickOnFlightOrigin();
		// flights.clickOnFlightDestination();
		FlightsPageData data = new FlightsPageData();
		data.dataForFlightsOriginDestination();
		flights.selectDate();
		flights.clickOnSearchButton();
		SearchResultsFlightsPage resultPage = new SearchResultsFlightsPage();
		// resultPage.verifyResults();
		resultPage.selectFlightByIndex(0);

	}

}
