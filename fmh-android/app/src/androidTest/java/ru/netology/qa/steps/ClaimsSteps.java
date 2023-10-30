package ru.netology.qa.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.netology.qa.elements.ClaimsScreen;

public class ClaimsSteps {
    ClaimsScreen Claims = new ClaimsScreen();

    public void isClaimsScreen() {
        Allure.step("Проверить, что это экно заявок");
        Claims.claimsScreen.check(matches(isDisplayed()));
    }

    public void filter() {
        Allure.step("Открыть фильтр");
        Claims.openFilter.perform(click());
    }

    public void open() {
        Allure.step("Открытие заявки");
        Claims.openFirstClaim.perform(click());
    }

    public void goBack() {
        Allure.step("Возврат из открытой заявки");
        Claims.closeClaim.perform(click());
    }

    public void isFilteringScreen() {
        Allure.step("Проверить, что это экно фильтрации заявок");
        Claims.filterScreen.check(matches(isDisplayed()));
    }

    public void removeCheckBoxOpen() {
        Allure.step("Снять флажок с чекбокса Открыта");
        Claims.checkBoxOpen.perform(click());
    }

    public void removeCheckBoxInProgress() {
        Allure.step("Снять флажок с чекбокса В работе");
        Claims.checkBoxInProgress.perform(click());
    }
    public void executedCheck() {
        Allure.step("Фильтрация заявок по критерию Выполнена");
        Claims.executed.perform(click());
    }
    public void cancelledCheck() {
        Allure.step("Фильтрация заявок по критерию Отмененные");
        Claims.cancelled.perform(click());
    }
    public void applyClaims() {
        Allure.step("Подтверждение фильтрации заявок");
        Claims.applyClaims.perform(click());
    }

    public void cancelClaims() {
        Allure.step("Отмена фильтрации заявок");
        Claims.cancelClaims.perform(click());
    }
    public void addNew() {
        Allure.step("Нажать кнопку добавления заявки");
        Claims.create.perform(click());
    }

    public void isCreatingScreen() {
        Allure.step("Проверить, что это окно создания заявки");
        Claims.creatingScreen.check(matches(isDisplayed()));
    }

    public void enterTitle(String text) {
        Allure.step("Ввести заголовок");
        Claims.createTitle.perform(replaceText(text));
    }

    public void enterExecutor(String text) {
        Allure.step("Выбрать из списка ФИО исполнителя");
        Claims.createExecutor.perform(replaceText(text));
    }

    public void enterDate(String text) {
        Allure.step("Ввести дату");
        Claims.createDate.perform(replaceText(text));
    }

    public void enterTime(String text) {
        Allure.step("Ввести время");
        Claims.createTime.perform(replaceText(text));
    }

    public void enterDescription(String text) {
        Allure.step("Ввести описание заявки");
        Claims.createDescription.perform(replaceText(text),closeSoftKeyboard());
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        Claims.saveButton.perform(click());

    }

    public void cancelButton() {
        Allure.step("Нажать на кнопку отменить");
        Claims.cancelButton.perform(click());
    }

    public void checkPopUpOk() {
        Allure.step("Проверить наличие всплывающей кнопки Ok");
        Claims.popUpOk.perform(click());
    }

    public void checkPopUpCancel() {
        Allure.step("Проверить наличие всплывающей кнопки Cancel");
        Claims.popUpCancel.perform(click());
    }

    public void checkEmpty() {
        Allure.step("Проверить уведомление о заполнении пустых полей");
        Claims.emptyFieldsWarning.check(matches(isDisplayed()));
    }

    public void enterEditButton() {
        Allure.step("Нажать на кнопку редактирования заявки");
        Claims.editButton.perform(click());
    }

    public void isEditingScreen() {
        Allure.step("Проверить, что это окно редактирования заявки");
        Claims.editingScreen.check(matches(isDisplayed()));
    }

    public void enterEditTitle(String title) {
        Allure.step("Ввести отредактированный текст заголовка");
        Claims.editTitle.perform(replaceText(title));
    }

    public void selectEditExecutor(String text) {
        Allure.step("Выбрать исполнителя заявки");
        Claims.editExecutor.perform(click());
        Claims.editExecutor.perform(replaceText(text));
    }

    public void enterEditDate(String text) {
        Allure.step("Ввести дату");
        Claims.editDate.perform(replaceText(text));
    }

    public void enterEditTime(String text) {
        Allure.step("Ввести время");
        Claims.editTime.perform(replaceText(text));
    }

    public void enterEditDescription(String text) {
        Allure.step("Ввести новое описание заявки");
        Claims.editDescription.perform(clearText(),(replaceText(text)),closeSoftKeyboard());
    }

    public void clickButtonSettings(){
        Allure.step("Нажать на кнопку Настройки");
        Claims.settingButton.perform(click());
    }

    public void clickButtonTakeToWork(){
        Allure.step("Изменение статуса заявки с Открыта на В работу");
        Claims.statusButtonTakeToWork.perform(click());
    }

    public void clickButtonCancel(){
        Allure.step("Изменение статуса заявки с Открыта на Отменена");
        Claims.statusButtonCancel.perform(click());
    }

    public void clickButtonToExecute(){
        Allure.step("Изменение статуса заявки с В работе на Выполнена");
        Claims.statusButtonToExecute.perform(click());
    }

    public void addCommentForExecute(){
        Allure.step("Добавить комментарий для выполненной заявки");
        Claims.commentForExecution.perform(clearText(), replaceText("Выполнена"));
    }

    public void clickButtonAddComment(){
        Allure.step("Нажать на кнопку Добавить комментарий");
        Claims.addComment.perform(click());
    }

    public void addToCommentField(){
        Allure.step("В поле Комментарий добавить комментарий");
        Claims.fieldComment.perform(clearText(), replaceText("Новый комментарий"));
    }

    public void editCommentField(){
        Allure.step("В поле Комментарий изменить комментарий");
        Claims.fieldComment.perform(clearText(), replaceText("Комментарий изменен"));
    }

    public void checkCommentField(){
        Allure.step("Проверить комментарий в поле Комментарий");
        Claims.comment.check(matches(isDisplayed()));
    }

    public void checkDescriptionField(){
        Allure.step("Проверить заголовок заявки");
        Claims.description.check(matches(isDisplayed()));
    }

    public void clickButtonEditComment(){
        Allure.step("Нажать на кнопку Редактировать комментарий");
        Claims.editComment.perform(click());
    }

    public void checkBlockComment(){
        Allure.step("Проверить наличие блока с комментариями");
        Claims.blockComment.perform(click());
    }

    public void checkClaimStatusInProgress(){
        Allure.step("Проверить статус заявки В работу");
        Claims.buttonStatus.perform(click());
        Claims.claimStatusInProgress.check(matches(isDisplayed()));
    }

    public void checkClaimStatusCanceled(){
        Allure.step("Проверить статус заявки Отменена");
        Claims.buttonStatus.perform(click());
        Claims.claimStatusCanceled.check(matches(isDisplayed()));
    }

    public void checkClaimStatusToExecute(){
        Allure.step("Проверить статус заявки Выполнена");
        Claims.claimStatusToExecute.check(matches(isDisplayed()));
    }
}