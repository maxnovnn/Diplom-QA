package ru.netology.qa.tests;

import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elements.AuthorizationScreen;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;
import ru.netology.qa.steps.NewsSteps;


@RunWith(AllureAndroidJUnit4.class)

public class NewsTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorizationCheck() {
        AuthorizationSteps.authorization();
    }

    @AfterClass
    public static void exit() {
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @DisplayName("ТС-40. Просмотр новостей во вкладке Новости")
    public void openNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickExpandNews();
    }

    @Test
    @DisplayName("ТС-41. Сортировка новостей во вкладке Новости")
    public void sortNews() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonSorting();
    }

    @Test
    @DisplayName("ТС-42. Фильтрация новостей по категории Объявление")
    public void filterNewsAdd() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonCategoryFilter();
    }

    @Test
    @DisplayName("ТС-52. Фильтрация новостей, без указания категории, в определенный период времени")
    public void filterNewsWithTimesPeriod() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
    }

    @Test
    @DisplayName("ТС-53. Фильтрация новостей, без указания категории, в определенный период времени")
    public void filteringNewsCertainPeriodTimeNegative() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonCategoryFilter();
        NewsSteps.clickButtonOkWrongMessage();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDateStart();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCategoryFilter();
    }
}