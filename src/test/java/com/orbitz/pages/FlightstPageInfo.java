package com.orbitz.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FlightstPageInfo extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "id.flights.flightshomepage")
	private QAFWebElement idFlightsFlightshomepage;

	@FindBy(locator = "css.flightsonly.flightspage")
	private QAFWebElement idFlightsonlyFlightspage;

	@FindBy(locator = "css.onewaybutton.flightspage")
	private QAFWebElement idOnewaybuttonFlightspage;

	@FindBy(locator = "css.flightsorigin.flightspage")
	private QAFWebElement idFlightsoriginFlightspage;

	@FindBy(locator = "xpath.flightsdestination.flightspage")
	private QAFWebElement idFlightsdestinationFlightspage;

	@FindBy(locator = "css.flightdeparting.flightspage")
	private QAFWebElement idFlightdepartingFlightspage;

	@FindBy(locator = "css.calendarclosebutton.flightspage")
	private QAFWebElement xpathCalendarclosebuttonFlightspage;

	@FindBy(locator = "id.searchbutton.flightspage")
	private QAFWebElement idSearchbuttonFlightspage;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	public void launch() throws InterruptedException {

		driver.get("/");
		driver.manage().window().maximize();
		System.out.println("Browswer opened");
		Reporter.log("Browser Opened");
	}

	public QAFWebElement getIdFlightsFlightshomepage() {

		return idFlightsFlightshomepage;
	}

	public QAFWebElement getIdFlightsonlyFlightspage() {

		return idFlightsonlyFlightspage;
	}

	public QAFWebElement getIdOnewaybuttonFlightspage() {

		return idOnewaybuttonFlightspage;
	}

	public QAFWebElement getIdFlightsoriginFlightspage() {

		return idFlightsoriginFlightspage;
	}

	public QAFWebElement getIdFlightsdestinationFlightspage() {

		return idFlightsdestinationFlightspage;
	}

	public QAFWebElement getIdFlightdepartingFlightspage() {

		return idFlightdepartingFlightspage;
	}

	public QAFWebElement getXpathCalendarclosebuttonFlightspage() {

		return xpathCalendarclosebuttonFlightspage;
	}

	public QAFWebElement getIdSearchbuttonFlightspage() {

		return idSearchbuttonFlightspage;
	}

	public void clickOnFlightsButton() {

		idFlightsFlightshomepage.click();
		Reporter.log("Clicked on flights");
	}

	public void clickOnFlightsOnlyButton() {

		idFlightsonlyFlightspage.click();
		Reporter.log("Clicked on Flights from menu buttons");
	}

	public void clickOnOneWay() {

		idOnewaybuttonFlightspage.click();
		Reporter.log("Clicked On Oneway");
	}

	public void setFlightOrigin(String source) {
 		idFlightsoriginFlightspage.sendKeys(source);
 		Reporter.log("flight origin is set");
	}
	public void setFlightDestination(String dest) {
		idFlightsdestinationFlightspage.sendKeys(dest);
 		Reporter.log("flight destination is set");

	}
	public void selectDate() {

		/* Selecting departing date from calendar */
		System.out.println("Entering select date");
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 2);
		date = calendar.getTime();
		String strDepartingDate = format.format(date);
		idFlightdepartingFlightspage.click();
		//idFlightdepartingFlightspage.clear();
		idFlightdepartingFlightspage.sendKeys(strDepartingDate);
		xpathCalendarclosebuttonFlightspage.click();
		Reporter.log("Selected Date");
	}

	public void clickOnSearchButton() {

		idSearchbuttonFlightspage.click();
		Reporter.log("Clicked on Search");
	}

}
