package com.orbitz.pages;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import com.orbitz.bean.FlightsBean;
import com.orbitz.utils.FlightBookingWindowHandle;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

import FlightBookingComponents.FlightBookingComponentClass;

public class SearchResultsFlightsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	int i = 0;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	@FindBy(locator = "css.flightname.searchedflight")
	private QAFWebElement cssFlightNameSearchedFlight;

	public QAFWebElement getCssFlightNameSearchedFlight() {
		return cssFlightNameSearchedFlight;
	}

	@FindBy(locator = "css.selectbutton.resultspage")
	private QAFWebElement cssSelectButtonResultsPage;

	public QAFWebElement getCssSelectButton() {
		return cssSelectButtonResultsPage;
	}
	@FindBy(locator = "id.continuebutton.selectedflightpage")
	private QAFWebElement idContinueButtonResultsPage;

	public QAFWebElement getIdContinueButton() {
		return idContinueButtonResultsPage;
	}

	@FindBy(locator = "css.flightsearchresultpage")
	private List<FlightBookingComponentClass> xpathFlightsearchresultpage;

	public List<FlightBookingComponentClass> getXpathFlightsearchresultpage() {
		return xpathFlightsearchresultpage;
	}

	public void verifyResults() {
		Validator.verifyThat(getXpathFlightsearchresultpage().size(),Matchers.greaterThan(0));
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

	

	public void selectFlightByIndex(int index) {
		Reporter.log("verifying flight based on index");
		FlightsBean bean = new FlightsBean();
		bean.setFlightName(getXpathFlightsearchresultpage().get(index).getCssFlightname().getText());
		bean.setOriDes(getXpathFlightsearchresultpage().get(index).getXpathFlightOriginDestinationFlightsPage().getText());
		bean.setPrice(getXpathFlightsearchresultpage().get(index).getCssFlightpriceSearchresultpage().getText());
		bean.info();
		cssSelectButtonResultsPage.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FlightBookingWindowHandle.windowHandle();
		Validator.verifyThat(bean.getFlightName(), Matchers.containsString(getCssFlightNameSearchedFlight().getText()));
		idContinueButtonResultsPage.click();

	}

}
