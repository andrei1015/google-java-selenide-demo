package main;

import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class GoogleTestFourth {
    @Test
    public void pagination() {
        open("https://www.google.com/");
        $(byName("q")).val("test").pressEnter();
        ElementsCollection element = $$("a.pn");
        ElementsCollection nav = $(By.id("nav")).$$("td");
        element.get(0).click(); // this one clicks Next cause the 0 index corresponds to it
        nav.get(2).shouldHave(cssClass("cur")); //and here I check the above has actually worked

        element.get(0).click(); // it now clicks Previous as it has the 0 index now
        nav.get(1).shouldHave(cssClass("cur")); //and check the above has worked, basically changing the current page

    }
}
