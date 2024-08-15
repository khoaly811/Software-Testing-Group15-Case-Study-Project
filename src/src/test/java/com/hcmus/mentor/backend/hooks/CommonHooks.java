package com.hcmus.mentor.backend.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonHooks {
    public static WebDriver driver;
    public static WebDriverWait wait;



    @Before
    public void setUp() {
        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            driver.get("http://localhost:3000");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
    }

    @After
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
