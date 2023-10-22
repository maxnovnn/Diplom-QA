package ru.netology.qa.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.netology.qa.elements.NewsControlPanelScreen;

public class NewsControlPanelSteps {
    NewsControlPanelScreen NewsControlPanel = new NewsControlPanelScreen();

    public void isControlPanelScreen() {
        Allure.step("Проверить, что это экно Панели управления новостями");
        NewsControlPanel.controlPanelScreen.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Нажать кнопку сортировки новостей");
        NewsControlPanel.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку фильтрации новостей");
        NewsControlPanel.filter.perform(click());
        NewsControlPanel.filterScreen.check(matches(isDisplayed()));
    }

    public void activeNews() {
        Allure.step("Выбор активных новостей на Панеле управлений новостями");
        NewsControlPanel.notActiveNews.perform(click());
    }

    public void notActiveNews() {
        Allure.step("Выбор неактивных новостей на Панеле управлений новостями");
        NewsControlPanel.activeNews.perform(click());
    }

    public void deleteNews() {
        Allure.step("Нажать на кнопку удалить новость");
        NewsControlPanel.deleteButton.perform(click());
    }

    public void checkPopUpOk() {
        Allure.step("Проверить наличие всплывающей кнопки Ok");
        NewsControlPanel.popUpOk.perform(click());
    }

    public void checkPopUpCancel() {
        Allure.step("Проверить наличие всплывающей кнопки Cancel");
        NewsControlPanel.popUpCancel.perform(click());
    }

    public void checkEmpty() {
        Allure.step("Проверить уведомление о заполнении пустых полей");
        NewsControlPanel.emptyFieldsWarning.check(matches(isDisplayed()));
    }
    public void checkTryAgain() {
        Allure.step("Проверить уведомление о повторении попытки позднее");
        NewsControlPanel.tryAgainFieldsWarning.check(matches(isDisplayed()));
    }
    public void createNews() {
        Allure.step("Нажать кнопку создания новости");
        NewsControlPanel.create.perform(click());
        NewsControlPanel.creatingScreen.check(matches(isDisplayed()));
    }

    public void selectCategory(String text) {
        Allure.step("Выбрать категорию для создания новости");
        NewsControlPanel.category.perform(click());
        NewsControlPanel.category.perform(replaceText(text));
    }

    public void enterTitle(String text) {
        Allure.step("Ввести заголовок");
        NewsControlPanel.createTitle.perform(replaceText(text));
    }
    public void expandNews() {
        Allure.step("Развернуть новость");
        NewsControlPanel.buttonExpand.perform(click());
    }

    public void checkExpandNews() {
        Allure.step("Проверить открывшуюся новость");
        NewsControlPanel.description.check(matches(isDisplayed()));
    }

    public void rollUpNews() {
        Allure.step("Свернуть новость");
        NewsControlPanel.title.perform(click());
    }

    public void checkRollUpNews() {
        Allure.step("Проверить, что новость свернулась");
        NewsControlPanel.description.check(matches(not(isDisplayed())));
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        NewsControlPanel.saveButton.perform(click());
        SystemClock.sleep(1500);
    }

    public void cancelButton() {
        Allure.step("Нажать на кнопку отменить");
        NewsControlPanel.cancelButton.perform(click());
    }

    public void filterButton() {
        Allure.step("Нажать на кнопку фильтровать");
        NewsControlPanel.filterButton.perform(click());
    }

    public void removeCheckBoxActive(){
        Allure.step("Снять флажок с чекбокса Активная");
        NewsControlPanel.checkboxActive.perform(click());
    }

    public void removeCheckBoxNotActive(){
        Allure.step("Снять флажок с чекбокса Не активная");
        NewsControlPanel.checkboxNotActive.perform(click());
    }

    public void editNews() {
        Allure.step("Нажать на кнопку редактировать новость");
        NewsControlPanel.editButton.perform(click());
        NewsControlPanel.editingScreen.check(matches(isDisplayed()));
    }

    public void selectEditCategory(String text) {
        Allure.step("Выбрать категорию для редактирования новости");
        NewsControlPanel.category.perform(click());
        NewsControlPanel.category.perform(replaceText(text));
    }

    public void enterEditTitle(String title) {
        Allure.step("Ввести отредактированный текст заголовка");
        NewsControlPanel.createTitle.perform(replaceText(title));
    }

    public void enterDate(String date) {
        Allure.step("Ввести дату");
        NewsControlPanel.date.perform(replaceText(date));
    }

    public void enterTime(String time) {
        Allure.step("Вести время");
        NewsControlPanel.time.perform(replaceText(time));
    }

    public void enterDescription(String description) {
        Allure.step("Ввести описание");
        NewsControlPanel.createDescription.perform(replaceText(description));
    }

    public void editStatus() {
        Allure.step("Изменить статус");
        NewsControlPanel.buttonStatus.perform(click());
    }

    public void checkStatusNotActive() {
        Allure.step("Проверить, что статус Не активный");
        NewsControlPanel.newsStatusNotActive.check(matches(isDisplayed()));
    }

    public void checkStatusActive() {
        Allure.step("Проверить, что статус Активный");
        NewsControlPanel.newsStatusActive.check(matches(isDisplayed()));
    }
}