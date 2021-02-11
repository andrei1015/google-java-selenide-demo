package main;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTestSecond {
    @Test
    public void searchResults() {
        open("https://www.google.com/");
        $(byName("q")).val("selenide").pressEnter();
        SelenideElement element = $$("#ires .g").get(1); //the .get(1) fetches the second element of the array that is created with $$
        element.shouldBe(visible).shouldHave(text("Selenide - Wikipedia"), text("https://en.wikipedia.org/wiki/Selenide"));
        //The above condition MIGHT fail depending on a lot of Google factors
    }
}

