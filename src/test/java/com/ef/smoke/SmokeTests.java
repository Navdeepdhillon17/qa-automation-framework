package com.ef.smoke;

import com.ef.smoke.base.BaseTest;
import com.ef.smoke.components.FooterComponent;
import com.ef.smoke.pages.HomePage;
import com.ef.smoke.pages.ResearchPage;
import com.ef.smoke.pages.ServicesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest {
    @Test(groups = {"smoke"})
    public void verifyPrivacyPolicy() {
        FooterComponent footer = new FooterComponent(driver);
        Assert.assertTrue(footer.goToPrivacyPolicy().isLoaded(), "Privacy Policy page did not load properly");
    }

    @Test(groups = {"smoke"})
    public void verifyTermsPage() {
        FooterComponent footer = new FooterComponent(driver);
        Assert.assertTrue(footer.goToTermsPage().isLoaded(), "Terms of Service page did not load properly");
    }

    @Test(groups = {"smoke"})
    public void verifyAboutPage() {
        FooterComponent footer = new FooterComponent(driver);
        Assert.assertTrue(footer.goToAboutPage().isLoaded(), "About Us page did not load properly");
    }

    @Test(groups = {"smoke"})
    public void isHomePageLoaded() {
        driver.get(config.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoaded(), "Home Page is not loaded properly");
    }
    @Test(groups = {"smoke"})
    public void isMainPageLoaded() {
        driver.get(config.getProperty("url"));
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue( homePage.isMainCTAVisible(), "Main CTA is not visible on Home Page");

    }
    @Test(groups = {"smoke"})
    public void navigateToServicesPage() {
        driver.get(config.getProperty("url"));
        ServicesPage servicesPage = new ServicesPage(driver);
        Assert.assertTrue(servicesPage.isLoaded(), "Services Page is not loaded properly");
    }
    @Test(groups = {"smoke"})
    public void navigateToResearchPage() {
        driver.get(config.getProperty("url"));
        ResearchPage researchPage = new ResearchPage(driver);
        Assert.assertTrue(researchPage.isLoaded(), "Research Page is not loaded properly");
    }
}
