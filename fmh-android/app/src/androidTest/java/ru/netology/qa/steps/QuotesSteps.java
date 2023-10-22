package ru.netology.qa.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNot.not;

import io.qameta.allure.kotlin.Allure;
import ru.netology.qa.elements.QuotesScreen;

public class QuotesSteps {
    QuotesScreen Quotes = new QuotesScreen();

    public void openQuotes() {
        Allure.step("Открыть раздел цитат");
        Quotes.quotes.perform(click());
        Quotes.quotesScreen.check(matches(isDisplayed()));
    }

    public void quotesExpand() {
        Allure.step("Развернуть цитату");
        Quotes.title.perform(click());
        Quotes.description.check(matches(isDisplayed()));
    }

    public void quotesRollUp() {
        Allure.step("Свернуть цитату");
        Quotes.titleRollUp.perform(click());
        Quotes.descriptionRollUp.check(matches(not(isDisplayed())));
    }
}