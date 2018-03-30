package FlightBookingComponents;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FlightBookingComponentClass extends QAFWebComponent {

	public FlightBookingComponentClass(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "xpath.flightname")
	private QAFWebElement cssFlightname;

	@FindBy(locator = "xpath.flightprice.flightsearchpage")
	private QAFWebElement cssFlightpriceSearchresultpage;

	@FindBy(locator = "xpath.flightoriginanddestination.flightspage")
	private QAFWebElement xpathFlightOriginDestinationFlightsPage;

	public QAFWebElement getCssFlightname() {
		return cssFlightname;
	}

	public QAFWebElement getCssFlightpriceSearchresultpage() {
		return cssFlightpriceSearchresultpage;
	}

	public QAFWebElement getXpathFlightOriginDestinationFlightsPage() {
		return xpathFlightOriginDestinationFlightsPage;
	}

}
