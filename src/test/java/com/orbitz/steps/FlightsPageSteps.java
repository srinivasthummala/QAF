package com.orbitz.steps;
import static com.qmetry.qaf.automation.step.CommonStep.*;


import org.testng.Reporter;

import com.orbitz.pages.FlightstPageInfo;
import com.orbitz.pages.SearchResultsFlightsPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class FlightsPageSteps extends WebDriverBaseTestPage<WebDriverTestPage> {

	FlightstPageInfo flights = new FlightstPageInfo();
	SearchResultsFlightsPage resultPage = new SearchResultsFlightsPage();
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	@QAFTestStep(description = "Given command to open broswer")
	public void launch() {

		driver.get("/");
		driver.manage().window().maximize();
		Reporter.log(" browser Opned");
	}

	@QAFTestStep(description = "user is on homepage click on flights")
	public void clickFlightsOnly() {
		click("css.flightsonly.flightspage");
		Reporter.log("Clciked On flights button from menu buttons");
	}

	@QAFTestStep(description = "user is on flights page click on one way")
	public void clickOneWay() {
		click("css.onewaybutton.flightspage");
		Reporter.log("Clicked on One Way");
	}
	
	@QAFTestStep(description = "user enter {0} and {1}")
	public void enterOriginAndDestination(String origin, String destination) {
		flights.setFlightOrigin(origin);
		flights.setFlightDestination(destination);
	}

	@QAFTestStep(description = "user enter departing date for one way booking")
	public void selectingDepartingDate() {
		flights.selectDate();
	}

	@QAFTestStep(description = "user click on Search")
	public void clickOnSearchButton() {
		click("id.searchbutton.flightspage");
		Reporter.log("Clciked On search");
	}


	@QAFTestStep(description = "user verify search results")
	public void verifySearchResults() {
		resultPage.verifyResults();
	}
}
