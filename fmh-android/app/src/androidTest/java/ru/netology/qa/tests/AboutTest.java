package ru.netology.qa.tests;

import static androidx.test.espresso.Espresso.pressBack;

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
import ru.netology.qa.steps.AboutSteps;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;

@RunWith(AllureAndroidJUnit4.class)

public class AboutTest {

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
    @DisplayName("ТС-74. Просмотр ссылки Политика конфиденциальности")
    public void transitionToPrivacyPolicy(){
        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonPrivacyPolicy();
        pressBack();
    }

    //  TC - 75 - Просмотр ссылки "Пользовательское соглашение" во вкладке "О приложении" мобильного приложения "Мобильный хоспис" (Позитивный).
    @Test
    @DisplayName("ТС-75. Просмотр ссылки Пользовательское соглашение")
    public void transitionToTermsOfUse() {
        ClaimsSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonTermsOfUse();
        pressBack();
    }
}