package org.example;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FirefoxBrowserInitHeadLessTrue {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void StartBrowser(){
        playwright = Playwright.create();
        browserType = playwright.firefox();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext(new Browser.NewContextOptions());
        page = browser.newPage();

        System.out.println("Browser Version: "+browser.version());

    }

    @Test
    public void OpenUrl() throws InterruptedException {
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(5000);
        System.out.println(page.title());
    }

    @AfterSuite
    public void CloseBrowser(){
        page.close();
        browser.close();
        playwright.close();
    }
}
