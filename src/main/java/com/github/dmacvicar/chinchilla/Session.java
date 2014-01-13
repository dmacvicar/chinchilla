package com.github.dmacvicar.chinchilla;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.tagName;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class Session implements WebDriver {

    //private final WebDriver driver;
    private final static WebDriver driver = new FirefoxDriver();

    public Session() {
        System.out.println("Initialized session");
      //this.driver = new FirefoxDriver();
        //this.driver = new ChromeDriver();
    }

    public void visit(String path) {
        Session.driver.get(path);
    }

    /**
     * Clicks on a link
     *
     * @param what id or text of the link
     */
    public void clickLink(String what) {
        driver.findElement(By.partialLinkText(what)).click();
    }

    /**
     * Clicks on a button
     *
     * @param what id or text of the button
     */
    public void clickButton(String what) {
        WebElement el = findElementBySomething("button", what);
        if (el != null) {
            el.click();
        }
    }

    private WebElement findElementBySomething(String tag, String what) {
        //System.out.println(getPageSource());
        try {
            WebElement el = findElement(By.id(what));
            if (el != null && el.getTagName().equals(tag)) {
                return el;
            }
        } catch (NoSuchElementException e) {
        }

        List<WebElement> els = findElements(tagName(tag));
        for (WebElement el : els) {
            System.out.println("'" + el.getText() + "'");
            if (el.getText().contains(what)) {
                return el;
            }
        }
        throw new NoSuchElementException("Can't find " + getPageSource());
    }

    private WebElement findFormElementByLabel(String what) {
        WebElement label = driver.findElement(By.linkText(what));
        String formElementId = label.getAttribute("for");
        WebElement select = driver.findElement(By.id(formElementId));
        return select;
    }

    // Implemented from WebDriver
    public boolean hasContent(String what) {
        return driver.getPageSource().contains(what);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void get(String string) {
        driver.get(string);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * @inheritDoc
     */
    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void close() {
        driver.close();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void quit() {
        driver.quit();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Set<String> getWindowHandles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    /**
     * @inheritDoc
     */
    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Options manage() {
        return driver.manage();
    }

}
