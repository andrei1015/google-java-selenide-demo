package main;

import org.junit.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTestFirst {
    @Test
    public void properHome() {
        open("https://www.google.com/");
        $(byName("q")).should(exist); //make sure the search input is present
        $(byName("btnK")).should(exist); //make sure the search button is present
        $(byName("btnI")).should(exist); //make sure the I'm Feeling Lucky button is present
    }
}