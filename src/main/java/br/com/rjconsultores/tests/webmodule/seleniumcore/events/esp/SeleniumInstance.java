package br.com.rjconsultores.tests.webmodule.seleniumcore.events.esp;

import java.util.Iterator;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

class SeleniumInstance {
	static WebDriver DRIVER;

	static String openSession() {
		openSessionForChrome();
		return SeleniumInstance.DRIVER.manage().getCookieNamed("JSESSIONID").getValue();
	}
	
	private static void openSessionForChrome() {
		if (SeleniumInstance.DRIVER == null) {
			System.setProperty("webdriver.chrome.driver", "C:/Ambiente/app/bin/chromedriver.exe");

			DesiredCapabilities d = DesiredCapabilities.chrome();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);
			d.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

			SeleniumInstance.DRIVER = new ChromeDriver(d);

			SeleniumInstance.DRIVER.get("http://127.0.0.1:8080/ventaboletosadm/");
			SeleniumInstance.DRIVER.manage().window().maximize();
		}
	}

	/**
	 * Fecha a sessão do selenium via webdriver
	 */
	static void closeSession() {
		SeleniumInstance.DRIVER.quit();
		SeleniumInstance.DRIVER = null;
	}

	static boolean isSameSession(String session) {
		LogEntries les = SeleniumInstance.DRIVER.manage().logs().get(LogType.BROWSER);
		Iterator<LogEntry> it = les.iterator();

		while (it.hasNext()) {
			LogEntry log = it.next();
			System.out.println(log.getMessage());
		}

		les.getAll();
		return session.equals(SeleniumInstance.DRIVER.manage().getCookieNamed("JSESSIONID").getValue());
	}
}
