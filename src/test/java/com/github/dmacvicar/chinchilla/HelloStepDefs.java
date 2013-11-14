package com.github.dmacvicar.chinchilla;

import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloStepDefs {

    @Inject
    private Session session;

    @When("^I go to google")
    public void I_go_to_google() throws Throwable {
        session.visit("http://www.google.com");
    }

    @When("^I follow \"([^\"]*)")
    public void I_follow(String what) throws Throwable {
        session.clickLink(what);
    }

    @Then("^I should see a \"([^\"]*)\" text$")
    public void I_should_see_a_text(String what) throws Throwable {
        assertTrue(what, session.hasContent(what));
        //throw new PendingException();
    }

}