package com.github.dmacvicar.chinchilla;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Duncan Mac-Vicar P. <dmacvicar@suse.de>
 */
public class ByTagWithIdClassOrText extends By {

    private final String tag;
    private final String locator;

    public ByTagWithIdClassOrText(String tag, String locator) {
        this.tag = tag;
        this.locator = locator;
    }

    @Override
    public List<WebElement> findElements(SearchContext sc) {
        System.out.println("Hello!: '" + locator + "'");
        List<WebElement> ret = new ArrayList<WebElement>();

        List<WebElement> els = sc.findElements(id(locator));
        for (WebElement el : els) {
            if (el.getTagName().equals(locator)) {
                ret.add(el);
            }
        }

        els = sc.findElements(tagName(this.tag));
        for (WebElement el : els) {
            if (el.getText().contains(this.locator)) {
                ret.add(el);
            }
        }
        return ret;
    }

}
