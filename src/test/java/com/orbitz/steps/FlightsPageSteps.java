package com.orbitz.steps;
import static com.qmetry.qaf.automation.step.CommonStep.*;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import com.orbitz.utils.FlightsPageData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

import FlightBookingComponents.FlightBookingComponentClass;

public class FlightsPageSteps extends WebDriverBaseTestPage<WebDriverTestPage> {

	int i = 0;

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	@QAFTestStep(description = "Given command to open broswer")
	public void launch() {

		driver.get("/");
		driver.manage().window().maximize();
		Reporter.log("Opned browser");
	}

	@QAFTestStep(description = "When the user is on homepage click on flights")
	public void clickOnFlights() {

		click("id.flights.flightshomepage");
		System.out.println("Cicked on Flights");
		Reporter.log("Clicked on flights");
	}

	@QAFTestStep(description = "And when the user is on flights page click on flights only")
	public void clickFlightsOnly() {

		click("id.flightsonly.flightspage");
		System.out.println("Clicked on Flights only");
		Reporter.log("Clciked On flights only");
	}

	@QAFTestStep(description = "And when the user is on flights page click on one way")
	public void clickOneWay() {

		click("id.onewaybutton.flightspage");
		System.out.println("Clicked on one way");
		Reporter.log("Clicked on One Way");
	}

	
	//@QAFDataProvider(key = "location")
	@QAFTestStep(description = "And when the user is booking one way enter {0} and {1}")
	public void enterOriginAndDestination(String origin, String destination) {

		FlightsPageData data = new FlightsPageData();
		data.dataForFlightsOriginDestinationXML(origin,destination);

	}

	@QAFTestStep(description = "And enter departing date for one way booking")
	public void selectingDepartingDate() {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 2);
		date = calendar.getTime();
		String stringDepartingDate = format.format(date);
		click("id.flightdeparting.flightspage");
		clear("id.flightdeparting.flightspage");
		sendKeys(stringDepartingDate, "id.flightdeparting.flightspage");
		click("xpath.calendarclosebutton.flightspage");
		System.out.println("Entered Date" + stringDepartingDate);
		Reporter.log("Selected Date");
	}

	@QAFTestStep(description = "And click on Search")
	public void clickOnSearchButton() {

		click("id.searchbutton.flightspage");
		System.out.println("Clicked On Search");
		Reporter.log("Clciked On search");
	}

	@FindBy(locator = "xpath.flightsearchresultpage")
	private List<FlightBookingComponentClass> xpathFlightsearchresultpage;

	public List<FlightBookingComponentClass> getXpathFlightsearchresultpage() {
		return xpathFlightsearchresultpage;
	}

	@QAFTestStep(description = "Then verify search results")
	public void verifySearchResults() {

		Validator.verifyThat(getXpathFlightsearchresultpage().size(),
				Matchers.greaterThan(0));
		int size = xpathFlightsearchresultpage.size();
		System.out.println("Total Flights shown:" + size);
		System.out.println("Validates greater then zero");
		for (FlightBookingComponentClass results : xpathFlightsearchresultpage) {

			if (i < 6) {
				Reporter.log("FlightName:" + results.getCssFlightname().getText());
				Reporter.log("Flight Origin and Destination:"
						+ results.getXpathFlightOriginDestinationFlightsPage().getText());
				Reporter.log("FlightPrice:"
						+ results.getCssFlightpriceSearchresultpage().getText());
				i++;
			} else {
				break;
			}

		}

	}
}
