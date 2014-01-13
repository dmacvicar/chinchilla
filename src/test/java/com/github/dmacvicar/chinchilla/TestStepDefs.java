package com.github.dmacvicar.chinchilla;

import com.google.inject.Inject;
import cucumber.api.java.en.When;

public class TestStepDefs {

    @Inject
    private Session session;

    @When("^I am on the \"([^\"]*)\" test page (\\d+)")
    public void I_am_on_the_test_page_N(String name, int idx) throws Throwable {
        String pageUrl = "file://" + System.getProperty("test.resources")
                + "/pages/" + name.replaceAll(" ", "-") + "-test-" + String.valueOf(idx) + ".html";
        session.visit(pageUrl);
    }

}
