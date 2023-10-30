package ru.netology.qa.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTests {
    AuthorizationSteps Auth = new AuthorizationSteps();
    MainSteps Main = new MainSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            Auth.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            Main.logOut();
        }
    }

    @Test
    @DisplayName("ТС-1. Авторизация валидными данными")
    public void validAuth(){
        Auth.isAuthorizationScreen();
        Auth.validAuth();
        Main.logOut();
    }

    @Test
    @DisplayName("ТС-2. Поле Логин пустое, при авторизации")
    public void emptyLogin(){
        Auth.isAuthorizationScreen();
        Auth.loginInputField(" ");
        Auth.passwordInputField("password2");
        Auth.buttonClick();
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    @DisplayName("ТС-7. Поле Пароль пустое, при авторизации")
    public void emptyPassword(){
        Auth.isAuthorizationScreen();
        Auth.loginInputField("login2");
        Auth.passwordInputField(" ");
        Auth.buttonClick();
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    @DisplayName("ТС-4. Ввод спецсимволов в поле Логин")
    public void loginWithSpecialCharacters(){
        Auth.isAuthorizationScreen();
        Auth.loginInputField("!@#$%%^");
        Auth.passwordInputField("password2");
        Auth.buttonClick();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @DisplayName("ТС-9. Ввод спецсимволов в поле Пароль")
    public void passwordWithSpecialCharacters(){
        Auth.isAuthorizationScreen();
        Auth.loginInputField("login2");
        Auth.passwordInputField("$%#^&*");
        Auth.buttonClick();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @DisplayName("ТС-6. Ввод букв разного регистра в поле Логин")
    public void invalidLogin(){
        Auth.isAuthorizationScreen();
        Auth.loginInputField("LoGiN2");
        Auth.passwordInputField("password2");
        Auth.buttonClick();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    @DisplayName("ТС-11. Ввод букв разного регистра в поле Пароль")
    public void invalidPassword(){
        Auth.isAuthorizationScreen();
        Auth.loginInputField("login2");
        Auth.passwordInputField("PasSWorD2");
        Auth.buttonClick();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }
}