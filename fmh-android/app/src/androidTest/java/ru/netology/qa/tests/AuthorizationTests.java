package ru.netology.qa.tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qa.elements.AuthorizationScreen;
import ru.netology.qa.steps.AuthorizationSteps;

@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorizationVerification() {
        try {
            AuthorizationScreen.textAuthorization();
        } catch (NoMatchingViewException e) {
            AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
            AuthorizationSteps.clickButtonLogOut();
        }
    }

    @Test
    @DisplayName("ТС-1. Авторизация валидными данными")
    public void validAuth(){
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
        AuthorizationScreen.clickButtonExit(AuthorizationScreen.getAuthorizationElementsButtonExit());
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @DisplayName("ТС-2. Поле Логин пустое, при авторизации")
    public void emptyLogin(){
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginEmpty();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-3. Поле Логин заполнено данными незарегистрированного пользователя")
    public void loginFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldUnregisteredUser();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-4. Поле Логин состоит из спецсимволов")
    public void loginFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldWithSpecialCharacters();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }


    @Test
    @DisplayName("ТС-5. Поле Логин состоит из одного символа")
    public void loginFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldOneLetter();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-6. Поле Логин состоит из букв разного регистра")
    public void loginFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginFieldLettersOfDifferentCase();
        AuthorizationSteps.clickPasswordField();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-7. Поле Пароль пустое")
    public void passwordFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldIsEmpty();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-8. Поле Пароль заполнено данными незарегистрированного пользователя")
    public void passwordFieldUnregisteredUser() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldUnregisteredUser();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-9. Поле Пароль состоит из спецсимволов")
    public void passwordFieldWithSpecialCharacters() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldWithSpecialCharacters();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-10. Поле Пароль состоит из одного символа")
    public void passwordFieldOneLetter() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldOneLetter();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }

    @Test
    @DisplayName("ТС-11. Поле Пароль состоит из букв разного регистра")
    public void passwordFieldLettersOfDifferentCase() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField();
        AuthorizationSteps.clickPasswordFieldLettersOfDifferentCase();
        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
    }
}