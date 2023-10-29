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
import ru.netology.qa.elements.ClaimsScreen;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;


@RunWith(AllureAndroidJUnit4.class)

public class ClaimsTest {

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
    @DisplayName("1ТС-14. Фильтрация заявок по критерию Открыта")
    public void applicationFilteringOpen() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickButtonOk();
    }

    @Test
    @DisplayName("ТС-15. Фильтрация заявок по критерию В работе")
    public void applicationFilteringInProgress() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
    }

    @Test
    @DisplayName("ТС-16. Фильтрация заявок по критерию Выполнена")
    public void applicationFilteringExecuted() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxExecuted();
        ClaimsSteps.clickButtonOk();
    }


    @Test
    @DisplayName("ТС-17. Фильтрация заявок по критерию Отмененные")
    public void applicationFilteringCancelled() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxCancelled();
        ClaimsSteps.clickButtonOk();
    }

    @Test
    @DisplayName("ТС-18. Создание заявки во вкладке Заявки")
    public void creatingNewClaim() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-19. Поле Тема пустое, при создании заявки")
    public void creatingNewClaimWithoutTitle() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
        ClaimsSteps.clickButtonOkError();
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    @Test
    @DisplayName("ТС-20. Ввод одного символа в поле Тема  при создании заявки")
    public void titleFieldWithOneCharacter() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldOneCharacter();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-21. Ввод максимально-допустимого количества символов в поле Тема при создании заявки")
    public void titleFieldWithMaxCharacter() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleFieldMaximumCharacters();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-22. Поле Исполнитель пустое, при создании заявки")
    public void creatingNewClaimWithoutExecutor() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-23. Ввод невалидных данных в поле Исполнитель при создании заявки")
    public void titleFieldWithInvalidInDataCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldOtherData();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-24. Ввод букв и цифр в поле Исполнитель при создании заявки")
    public void executorFieldWithLettersNumbersCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldConsistsLettersAndNumbers();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-25. Ввод специсимволов в поле Исполнитель при создании заявки")
    public void executorFieldWithSpecialCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickExecutorFieldSpecialCharacters();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-26. Ввод невалидной даты в поле  Дата при создании заявки")
    public void creatingNewClaimWithInvalidDate() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateFieldNextYear();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-29. Поле Описание пустое, при создании заявки")
    public void creatingNewClaimWithoutDescription() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField();
        ClaimsSteps.clickCheckBoxExecutorField();
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickButtonSave();
        ClaimsSteps.clickButtonOkError();
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    @Test
    @DisplayName("ТС-30. Редактирование заявки, находящаяся в статусе Открыта")
    public void editClaimIfStatusOpen() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickEditClaim();
        ClaimsSteps.clickEditClaimStatusOpen();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-31. Добавление комментария к заявке")
    public void addComment() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonAddComment();
        ClaimsSteps.clickCommentField();
        ClaimsSteps.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-32. Редактирование комментария к заявке")
    public void editComment() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonEditComment();
        ClaimsSteps.clickCommentField();
        ClaimsScreen.clickButtonSave();
    }

    @Test
    @DisplayName("ТС-33. Смена статуса заявки, находящаяся в статусе Открыта на статус В работе")
    public void changeStatusOpenToTakeToWork() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        ClaimsSteps.clickButtonTakeToWork();
    }

    @Test
    @DisplayName("ТС-34. Смена статуса заявки, находящаяся в статусе Открыта на статус Отменена")
    public void changeStatusOpenToCancel() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        ClaimsSteps.clickOpenClaim();
        ClaimsSteps.clickButtonSettings();
        ClaimsSteps.clickButtonCancel();
    }
}