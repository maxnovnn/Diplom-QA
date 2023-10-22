package ru.netology.qa.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.netology.qa.elements.AuthorizationScreen;

public class AuthorizationSteps {
    AuthorizationScreen Auth = new AuthorizationScreen();
    MainSteps Main = new MainSteps();

    public void isAuthorizationScreen() {
        Allure.step("Проверить, что это экно авторизации");
        Auth.authScreen.check(matches(isDisplayed()));
    }

    public void loginInputField(String login) {
        Allure.step("Заполнить поле логин");
        Auth.login.check(matches(isEnabled()));
        Auth.login.perform(replaceText(login));
    }

    public void passwordInputField(String password) {
        Allure.step("Заполнить поле пароль");
        Auth.password.check(matches(isEnabled()));
        Auth.password.perform(replaceText(password));
    }

    public void buttonClick() {
        Allure.step("Нажать на кнопку Войти");
        Auth.signInButton.perform(click());
    }

    public void validAuth(){
        Allure.step("Заполнить поле логина");
        Auth.login.check(matches(isEnabled()));
        Auth.login.perform(replaceText("login2"));
        Allure.step("Заполнить поле пароля");
        Auth.password.check(matches(isEnabled()));
        Auth.password.perform(replaceText("password2"));
        Allure.step("Нажать на кнопку ВОЙТИ");
        Auth.signInButton.perform(click());
        SystemClock.sleep(3000);
        Main.isMainScreen();
    }
}