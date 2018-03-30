package com.orbitz.utils;

import com.qmetry.qaf.automation.ui.WebDriverTestBase;

public class FlightBookingWindowHandle {

	public static void windowHandle() {
		String parentWindow = new WebDriverTestBase().getDriver().getWindowHandle();

		for (String window : new WebDriverTestBase().getDriver().getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				new WebDriverTestBase().getDriver().switchTo().window(window);
			}
		}

	}

}
