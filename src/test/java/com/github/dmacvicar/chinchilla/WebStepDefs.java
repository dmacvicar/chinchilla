package com.github.dmacvicar.chinchilla;

import com.google.inject.Inject;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class WebStepDefs {

    final private Session session;

    @Inject
    public WebStepDefs(Session session) {
        this.session = session;
    }

    @When("^I go to google")
    public void I_go_to_google() throws Throwable {
        session.visit("http://www.google.com");
    }

    @When("^I follow \"([^\"]*)")
    public void I_follow(String what) throws Throwable {
        session.clickLink(what);
    }

    @When("^I click on \"([^\"]*)\"$")
    public void I_click_on(String what) throws Throwable {
        session.clickButton(what);
    }

    @Then("^I should see a \"([^\"]*)\" text$")
    public void I_should_see_a_text(String what) throws Throwable {
        assertTrue(what, session.hasContent(what));
        //throw new PendingException();
    }

}
