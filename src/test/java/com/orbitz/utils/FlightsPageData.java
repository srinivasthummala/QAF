package com.orbitz.utils;
import java.util.List;

import org.testng.Reporter;
import com.orbitz.pages.FlightstPageInfo;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.CSVUtil;

public class FlightsPageData extends WebDriverBaseTestPage<WebDriverTestPage> {

	FlightstPageInfo testpage = new FlightstPageInfo();

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {

	}

	String strFile =
			"resources\\data.csv";

	public static List<Object[]> getCsvInfo(String strFile) {

		return CSVUtil.getCSVData(strFile);
	}

	public void dataForFlightsOriginDestination() {

		List<Object[]> origindestination = getCsvInfo(strFile);
		String origin = origindestination.get(0)[0].toString();
		System.out.println(origin);
		String destination = origindestination.get(0)[1].toString();
		System.out.println(destination);

		testpage.getIdFlightsoriginFlightspage().click();
		testpage.getIdFlightsoriginFlightspage().sendKeys(origin);
		Reporter.log("Entered Origin");

		testpage.getIdFlightsdestinationFlightspage().click();
		testpage.getIdFlightsdestinationFlightspage().sendKeys(destination);
		Reporter.log("Entered Destination");
	}

	
	@QAFDataProvider(key = "location")
	public void dataForFlightsOriginDestinationXML(String origin, String destination) {

	/*	String origin = dataMap.get("origin");
		Reporter.log(origin);
		String destination = dataMap.get("destination");
		Reporter.log(destination);*/

		testpage.getIdFlightsoriginFlightspage().click();
		testpage.getIdFlightsoriginFlightspage().sendKeys(origin);
		Reporter.log("Entered Origin");

		testpage.getIdFlightsdestinationFlightspage().click();
		testpage.getIdFlightsdestinationFlightspage().sendKeys(destination);
		Reporter.log("Entered Destination");
	}

}
