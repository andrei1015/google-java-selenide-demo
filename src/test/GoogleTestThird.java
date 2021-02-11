package main;

import com.codeborne.selenide.*;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class GoogleTestThird {
    @Test
    public void suggestionBox() {
        String value = "tes";
        open("https://www.google.com/");
        $(byName("q")).val(value);
        $(byClassName("UUbT9")).should(exist);

        ElementsCollection suggestions = $(By.className("erkvQe")).$$(".sbct");
        suggestions.shouldBe(CollectionCondition.size(10)); //this checks there are 10 suggestions appearing (considering google is large enough this will pass for most normal inputs

        for (SelenideElement el: suggestions) { //iterate through each suggestion
            el.shouldHave(matchText(value + ".*")); //check each suggestion contains and begins with the search term (value)
        }
    }
}