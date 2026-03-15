package com.ef.smoke.pages;

import com.ef.smoke.base.BasePage;
import com.ef.smoke.components.FooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //locators
    private By heroAnchor  = By.cssSelector("h1[class*='animate-fade-in-up']");
    //call-to-action button
    private By mainCTA     = By.cssSelector("a[href='https://cal.com/exploitfrontier/30min']");
    private By webServicesNav = By.xpath("//a[@href='/services/web-pentest/']");
    private By researchNav = By.xpath("//a[@href='/research/']");

    //actions

//    Home is ready	isLoaded()
//    CTA exists	isMainCTAVisible()
//    User can reach services	goToWebServices()
//    User can reach research	goToResearch()


    public boolean isLoaded() {
       waitForElementVisible(heroAnchor);
        return driver.findElement(heroAnchor).isDisplayed();
    }
    public boolean isMainCTAVisible() {
        waitForElementVisible(mainCTA);
        return driver.findElement(mainCTA).isDisplayed();
    }
    public ServicesPage goToWebService() {
        waitForElementClickable(webServicesNav);
        driver.findElement(webServicesNav).click();
        return new ServicesPage(driver);
    }
    public ResearchPage goToResearch() {
        waitForElementClickable(researchNav);
        driver.findElement(researchNav).click();
        return new ResearchPage(driver);
    }
    public FooterComponent goToFooter() {
        return new FooterComponent(driver);
    }

}
