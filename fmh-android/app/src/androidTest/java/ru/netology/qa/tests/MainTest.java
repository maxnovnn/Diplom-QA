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
import ru.netology.qa.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)

public class MainTest {

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
    @DisplayName("ТС-12. Переход во вкладку Все Новости")
    public void openAllNews() {
        MainSteps.clickButtonAllNews();
    }

    @Test
    @DisplayName("ТС-13. Переход во вкладку Все Заявки")
    public void openAllClaims() {
        MainSteps.clickButtonClaims();
    }
}