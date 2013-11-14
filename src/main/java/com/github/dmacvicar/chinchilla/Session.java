package com.github.dmacvicar.chinchilla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class Session {

    private final WebDriver driver;

    public Session() {
      this.driver = new FirefoxDriver();
      //this.driver = new ChromeDriver();
    }

    public void visit(String path) {
      this.driver.get(path);
    }

    public void clickLink(String what) {
      driver.findElement(By.partialLinkText(what)).click();
    }

    public boolean hasContent(String what) {
      return true;
    }

}