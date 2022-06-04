package com.hybrid.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	// SingleTon
	// only one instance of class exist at a time
	private static final WebDriverFactory instance = new WebDriverFactory();

	// private constructor
	private WebDriverFactory() {

	}

	public static WebDriverFactory getInstance() {
		return instance;
	}

	// this gives each thread a seperate instance of object - when running in
	// parallel each test will have
	// a seperate thread copy by default
	private static ThreadLocal<WebDriver> threadedDriver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver(String browser) {
		WebDriver driver = null;
		if (threadedDriver.get() == null) {
			try {
				if (browser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions options = setFFOptions();
					driver = new FirefoxDriver();
					threadedDriver.set(driver);
				}

				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = setChromeOptions();
					driver =new ChromeDriver(options);
					threadedDriver.set(driver);
				}

				if (browser.equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup();
					driver =new EdgeDriver();
					threadedDriver.set(driver);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		threadedDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		threadedDriver.get().manage().window().maximize();

		return threadedDriver.get();
	}
	
	public void quitDriver() {
		threadedDriver.get().quit();
		threadedDriver.set(null);
	}
	
	
	 /***
     * Set Chrome Options
     * @return options
     */
    private ChromeOptions setChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    /***
     * Set Firefox Options
     * @return options
     */
    private FirefoxOptions setFFOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
        return options;
    }

    /***
     * Set Internet Explorer Options
     * @return options
     */
    private InternetExplorerOptions setIEOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        options.setCapability(InternetExplorerDriver.
                INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        return options;
    }
}


/*

    public WebDriver getDriver(String browser) {
        WebDriver driver = null;
        setDriver(browser);    -----------------------------------------------------this acts as System.setProperty();
        if (threadedDriver.get() == null) {
            try {
                if (browser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                    threadedDriver.set(driver);
                }
                if (browser.equalsIgnoreCase("chrome")) {
                    driver = new ChromeDriver();
                    threadedDriver.set(driver);
                }
                if (browser.equalsIgnoreCase("iexplorer")) {
                    driver = new InternetExplorerDriver();
                    threadedDriver.set(driver);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            threadedDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            threadedDriver.get().manage().window().maximize();
        }
        return threadedDriver.get();
    }

    public void quitDriver() {
        threadedDriver.get().quit();
        threadedDriver.set(null);
    }

    private void setDriver(String browser) {
        String driverPath = "";
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
        System.out.println("OS Name from system property :: " + os);
        String directory = System.getProperty("user.dir") + "//drivers//";
        String driverKey = "";
        String driverValue = "";

        if (browser.equalsIgnoreCase("firefox")) {
            driverKey = "webdriver.gecko.driver";
            driverValue = "geckodriver";
        } else if (browser.equalsIgnoreCase("chrome")) {
            driverKey = "webdriver.chrome.driver";
            driverValue = "chromedriver";
        } else if (browser.equalsIgnoreCase("ie")) {
            driverKey = "webdriver.ie.driver";
            driverValue = "IEDriverServer";
        } else {
            System.out.println("Browser type not supported");
        }

        driverPath = directory + driverValue + (os.equals("win") ? ".exe" : "");
        System.out.println("Driver Binary :: " + driverPath);
        System.setProperty(driverKey, driverPath);
    }


*/