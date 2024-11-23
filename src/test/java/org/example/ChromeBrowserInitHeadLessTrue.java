package org.example;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChromeBrowserInitHeadLessTrue {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void StartBrowser(){
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext(new Browser.NewContextOptions());
        page = browser.newPage();

        System.out.println("Browser Version: "+browser.version());
    }

    @Test
    public void OpenBrowser() throws InterruptedException {
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);
        System.out.println(page.title());
    }

    @AfterSuite
    public void CloseBrowser(){
        page.close();
        browser.close();
        playwright.close();
    }
}
