package main;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class GoogleTestFifth {
    @Test
    public void searchboxScroll() {
        open("https://www.google.com/");
        $(byName("q")).val("test").pressEnter();
        $("#searchform").shouldBe(visible); //make sure the search input is present
        $(byId("navcnt")).scrollTo();
        $("#searchform").shouldHave(cssValue("position", "fixed"));
    }
}