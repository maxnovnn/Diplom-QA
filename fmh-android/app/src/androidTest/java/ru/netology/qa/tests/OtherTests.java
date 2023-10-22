package ru.netology.qa.tests;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
import ru.netology.qa.steps.AboutSteps;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;
import ru.netology.qa.steps.MainSteps;
import ru.netology.qa.steps.NewsControlPanelSteps;
import ru.netology.qa.steps.NewsSteps;
import ru.netology.qa.steps.QuotesSteps;

@RunWith(AllureAndroidJUnit4.class)

public class OtherTests {
    AuthorizationSteps Auth = new AuthorizationSteps();
    AboutSteps About = new AboutSteps();
    ClaimsSteps Claims = new ClaimsSteps();
    MainSteps Main = new MainSteps();
    NewsControlPanelSteps NewsControlPanel = new NewsControlPanelSteps();
    NewsSteps News = new NewsSteps();
    QuotesSteps Quotes = new QuotesSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            Main.isMainScreen();
        } catch (NoMatchingViewException e) {
            Auth.validAuth();
        }
        SystemClock.sleep(2000);
    }
    @Test
    @DisplayName("ТС-12. Переход во вкладку Все Новости")
    public void openAllNews(){
        Main.clickButtonAllNews();
    }

    @Test
    @DisplayName("ТС-13. Переход во вкладку Все Заявки")
    public void openAllClaims(){
        Main.clickButtonAllClaims();
    }

    @Test
    @DisplayName("1ТС-14. Фильтрация заявок по критерию Открыта")
    public void applicationFilteringOpen(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("ТС-15. Фильтрация заявок по критерию В работе")
    public void applicationFilteringInProgress(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxOpen();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("ТС-16. Фильтрация заявок по критерию Выполнена")
    public void applicationFilteringExecuted(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.executedCheck();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("ТС-17. Фильтрация заявок по критерию Отмененные")
    public void applicationFilteringCancelled(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.cancelledCheck();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("ТС-18. Создание заявки во вкладке Заявки")
    public void creatingNewClaim(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.isClaimsScreen();
    }

    @Test
    @DisplayName("ТС-19. Поле Тема пустое, при создании заявки")
    public void creatingNewClaimWithoutTitle(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle(" ");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("ТС-20. Ввод одного символа в поле Тема  при создании заявки")
    public void titleFieldWithOneCharacter(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("5");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.isClaimsScreen();
    }

    @Test
    @DisplayName("ТС-21. Ввод максимально-допустимого количества символов в поле Тема при создании заявки")
    public void titleFieldWithMaxCharacter(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("12345678900147258369qwertyuiopasdfghjklzxcvbnm9874");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.isClaimsScreen();
    }

    @Test
    @DisplayName("ТС-22. Поле Исполнитель пустое, при создании заявки")
    public void creatingNewClaimWithoutExecutor(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor(" ");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkBlockComment();
    }

    @Test
    @DisplayName("ТС-23. Ввод невалидных данных в поле Исполнитель при создании заявки")
    public void titleFieldWithInvalidInDataCharacters(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("йййййййййййййййййййй");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.isClaimsScreen();
    }

    @Test
    @DisplayName("ТС-24. Ввод букв и цифр в поле Исполнитель при создании заявки")
    public void executorFieldWithLettersNumbersCharacters(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("Иванов1973");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkBlockComment();
    }

    @Test
    @DisplayName("ТС-25. Ввод специсимволов в поле Исполнитель при создании заявки")
    public void executorFieldWithSpecialCharacters(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor(")(*&^%$#");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkBlockComment();
    }

    @Test
    @DisplayName("ТС-26. Ввод невалидной даты в поле  Дата при создании заявки")
    public void creatingNewClaimWithInvalidDate(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("12.09.2035 ");
        Claims.enterTime("09:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkEmpty();
    }

        @Test
    @DisplayName("ТС-27. Ввод валидного времени в поле Время, при создании заявки")
    public void creatingNewClaimWithValidTime(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("09.10.2023 ");
        Claims.enterTime("00:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("ТС-28. Ввод невалидного времени в поле Время, при создании заявки")
    public void creatingNewClaimWithInvalidTime(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("09.10.2023 ");
        Claims.enterTime("00:30");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("ТС-29. Поле Описание пустое, при создании заявки")
    public void creatingNewClaimWithoutDescription(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("Петров Василий Иванович");
        Claims.enterDate("09.10.2023");
        Claims.enterTime("09:30");
        Claims.enterDescription(" ");
        Claims.saveButton();
        SystemClock.sleep(1000);
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("ТС-30. Редактирование заявки, находящаяся в статусе Открыта")
    public void editClaimIfStatusOpen(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
        SystemClock.sleep(1000);
        Claims.open();
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(2000);
        Claims.enterEditButton();
        Claims.enterEditTitle("Отредактированный текст заголовка");
        Claims.selectEditExecutor("Иванов Петр Сергеевич");
        Claims.enterEditDate("11.10.2023");
        Claims.enterEditTime("13:30");
        Claims.enterEditDescription("Отредактированное описание");
        closeSoftKeyboard();
        Claims.saveButton();
        SystemClock.sleep(1000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        Claims.goBack();
        Claims.checkBlockComment();
    }

    @Test
    @DisplayName("ТС-31. Добавление комментария к заявке")
    public void addComment(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
        SystemClock.sleep(1000);
        Claims.open();
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(2000);
        Claims.clickButtonAddComment();
        Claims.addToCommentField();
        Claims.saveButton();
        onView(withId(android.R.id.content)).perform(swipeUp());
        Claims.checkCommentField();
    }

    @Test
    @DisplayName("ТС-32. Редактирование комментария к заявке")
    public void editComment(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
        SystemClock.sleep(1000);
        Claims.open();
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(2000);
        Claims.clickButtonAddComment();
        Claims.addToCommentField();
        Claims.saveButton();
        Claims.clickButtonAddComment();
        Claims.addToCommentField();
        Claims.saveButton();
        Claims.clickButtonEditComment();
        Claims.editCommentField();
        Claims.saveButton();
        SystemClock.sleep(1000);
        onView(withId(android.R.id.content)).perform(swipeUp());
        Claims.checkCommentField();
    }

    @Test
    @DisplayName("ТС-33. Смена статуса заявки, находящаяся в статусе Открыта на статус В работе")
    public void changeStatusOpenToTakeToWork(){
        Main.openClaims();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
        Claims.open();
        onView(withId(android.R.id.content)).perform(swipeUp());
        SystemClock.sleep(2000);
        Claims.clickButtonSettings();
        Claims.clickButtonTakeToWork();
        onView(withId(android.R.id.content)).perform(swipeDown());
        Claims.checkClaimStatusInProgress();
    }
    @Test
    @DisplayName("ТС-34. Смена статуса заявки, находящаяся в статусе Открыта на статус Отменена")
    public void changeStatusOpenToCancel(){
        Main.openClaims();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
        Claims.open();
        onView(withId(android.R.id.content)).perform(swipeUp());
        Claims.clickButtonSettings();
        Claims.clickButtonCancel();
        Claims.checkClaimStatusCanceled();
    }

    @Test
    @DisplayName("ТС-40. Просмотр новостей во вкладке Новости")
    public void openNews() {
        Main.openNews();
        News.newsExpand();
        News.checkExpandNews();
    }

    @Test
    @DisplayName("ТС-41. Сортировка новостей во вкладке Новости")
    public void sortNews() {
        Main.openNews();
        News.sortNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-42. Фильтрация новостей по категории Объявление")
    public void filterNewsAdd() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Объявление");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-43. Фильтрация новостей по категории День рождения")
    public void filterNewsBirthday() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("День рождения");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-44. Фильтрация новостей по категории Зарплата")
    public void filterNewsSalary() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Зарплата");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-45. Фильтрация новостей по категории Профсоюз")
    public void filterNewsUnion() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Профсоюз");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-46. Фильтрация новостей по категории Праздник")
    public void filterNewsHoliday() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Праздник");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-47. Фильтрация новостей по категории Массаж")
    public void filterNewsMassage() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Массаж");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-48. Фильтрация новостей по категории Благодарность")
    public void filterNewsGratitude() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Благодарность");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-49. Фильтрация новостей по категории Нужна помощь")
    public void filterNewsHelp() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Нужна помощь");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-50. Фильтрация новостей без указания категории")
    public void filterNews() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory(" ");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-52. Фильтрация новостей, без указания категории, в определенный период времени")
    public void filterNewsWithTimesPeriod() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory(" ");
        News.dateStart("02.10.2023");
        News.dateEnd("20.10.2023");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("ТС-54. Сортировка новостей во вкладке Панели управления")
    public void sortNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.sortNews();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-55. Просмотр новостей во вкладке Панели управления")
    public void viewNewsInControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.expandNews();
        NewsControlPanel.checkExpandNews();
    }

    @Test
    @DisplayName("ТС-56. Удаление активной новости во вкладке Панель управления")
    public void deleteNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.deleteNews();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-57. Редактирование новости во вкладке Панель управления")
    public void editNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.editNews();
        NewsControlPanel.enterEditTitle("Новый заголовок");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-58. Смена статуса новости, находящаяся в статусе Активна на статус Не активна")
    public void changeStatusNewsFromActiveToNotActive() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.filterNews();
        NewsControlPanel.activeNews();
        NewsControlPanel.filterButton();
        NewsControlPanel.editNews();
        NewsControlPanel.editStatus();
        NewsControlPanel.checkStatusNotActive();
        NewsControlPanel.saveButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-59. Фильтрация новостей по критерию Активна")
    public void filterNewsByActiveCriteria() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.filterNews();
        NewsControlPanel.activeNews();
        NewsControlPanel.filterButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-60. Фильтрация новостей по критерию Не активна")
    public void filterNewsByNotActiveCriteria() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.filterNews();
        NewsControlPanel.notActiveNews();
        NewsControlPanel.filterButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-61. Создание новости  во вкладке Панеле Управления")
    public void createNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Праздник");
        NewsControlPanel.enterTitle("Не забыть отметить!");
        NewsControlPanel.enterDate("13.10.2023");
        NewsControlPanel.enterTime("17:45");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-62. Поле Категория пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithEmptyCategory() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory(" ");
        NewsControlPanel.enterTitle("Заголовок");
        NewsControlPanel.enterDate("17.10.2023");
        NewsControlPanel.enterTime("14:00");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
    }

    @Test
    @DisplayName("ТС-63. Поле Заголовок пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithoutTitle() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Премия");
        NewsControlPanel.enterEditTitle(" ");
        NewsControlPanel.enterDate("17.10.2023");
        NewsControlPanel.enterTime("14:00");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-64. Поле Дата публикации пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithoutDate() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.isControlPanelScreen();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Премия");
        NewsControlPanel.enterDate(" ");
        NewsControlPanel.enterTime("14:00");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-65. Поле Время пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithoutTime() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.isControlPanelScreen();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Премия");
        NewsControlPanel.enterDate("17.10.2023 ");
        NewsControlPanel.enterTime(" ");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-66. Поле Описание пустое, при создании новости во вкладке Панель управления")
    public void createNewsWithoutDescription() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.isControlPanelScreen();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Премия");
        NewsControlPanel.enterDate("17.10.2023 ");
        NewsControlPanel.enterTime("14:00 ");
        NewsControlPanel.enterDescription(" ");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("ТС-67. Ввод собственного названия категории в поле Категория при создании новости во вкладке Панель управления")
    public void createNewsWithOwnCategory() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Категория");
        NewsControlPanel.enterTitle("Заголовок");
        NewsControlPanel.enterDate("17.10.2023");
        NewsControlPanel.enterTime("14:00");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Saving failed. Try again later"), isDisplayed()));
    }

    @Test
    @DisplayName("ТС-73. Развернуть/свернуть тематическую цитату, во вкладке Главное - жить любя")
    public void expandThematicQuote(){
        Quotes.openQuotes();
        Quotes.quotesExpand();
        SystemClock.sleep(1000);
        Quotes.quotesRollUp();
    }

    @Test
    @DisplayName("74 - Просмотр ссылки Политика конфиденциальности")
    public void transitionToPrivacyPolicy(){
        Main.openAbout();
        About.isAboutScreen();
        About.checkPrivacy();
        About.backButton();
    }

    @Test
    @DisplayName("75 - Просмотр ссылки Пользовательское соглашение")
    public void transitionToTermsOfUse(){
        Main.openAbout();
        About.isAboutScreen();
        About.checkTerms();
        About.backButton();
    }
}
