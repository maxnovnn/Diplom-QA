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
import ru.netology.qa.elements.NewsControlPanelScreen;
import ru.netology.qa.steps.AuthorizationSteps;
import ru.netology.qa.steps.ClaimsSteps;
import ru.netology.qa.steps.NewsControlPanelSteps;
import ru.netology.qa.steps.NewsSteps;


@RunWith(AllureAndroidJUnit4.class)


public class NewsControlPanelTest {

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
    @DisplayName("ТС-54. Сортировка новостей во вкладке Панели управления")
    public void sortNewsOnControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelScreen.clickButtonControlPanel();
        NewsControlPanelScreen.clickButtonSorting();
    }

    @Test
    @DisplayName("ТС-55. Просмотр новостей во вкладке Панели управления")
    public void viewNewsInControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
    }

    @Test
    @DisplayName("ТС-56. Удаление активной новости во вкладке Панель управления")
    public void deleteNewsOnControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonDeleteNews();
        NewsControlPanelSteps.clickOkDeleteNews();
    }

    @Test
    @DisplayName("ТС-57. Редактирование новости во вкладке Панель управления")
    public void editNewsOnControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        NewsControlPanelSteps.clickButtonTitleNewsControlPanel();
        NewsControlPanelSteps.clickButtonSaveEditingNews();
    }

    @Test
    @DisplayName("ТС-58. Смена статуса новости, находящаяся в статусе Активна на статус Не активна")
    public void changeStatusNewsFromActiveToNotActive() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickClickNews();
        NewsControlPanelSteps.clickButtonEditNews();
        NewsControlPanelSteps.clickButtonSwitcher();
        NewsControlPanelSteps.clickButtonSaveEditingNews();
    }

    @Test
    @DisplayName("ТС-59. Фильтрация новостей по критерию Активна")
    public void filterNewsByActiveCriteria() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
    }

    @Test
    @DisplayName("ТС-60. Фильтрация новостей по критерию Не активна")
    public void filterNewsByNotActiveCriteria() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickFilterNewsControlPanel();
        NewsControlPanelSteps.clickRemoveCheckBoxNotActive();
        NewsControlPanelSteps.clickButtonFilterNewsControlPanel();
    }


    @Test
    @DisplayName("ТС-61. Создание новости  во вкладке Панель Управления")
    public void createNewsOnControlPanel() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
    }

    @Test
    @DisplayName("ТС-62. Поле Категория пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithEmptyCategory() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @DisplayName("ТС-63. Поле Заголовок пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithoutTitle() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNew();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @DisplayName("ТС-64. Поле Дата публикации пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithoutDate() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @DisplayName("ТС-65. Поле Время пустое, при создании новости, во вкладке Панель управления")
    public void createNewsWithoutTime() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @DisplayName("ТС-66. Поле Описание пустое, при создании новости во вкладке Панель управления")
    public void createNewsWithoutDescription() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNews();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }

    @Test
    @DisplayName("ТС-67. Ввод собственного названия категории в поле Категория при создании новости во вкладке Панель управления")
    public void createNewsWithOwnCategory() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsEmpty();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();

    }

    @Test
    @DisplayName("ТС-68. Поле Категория состоит из цифр, при создании новости, во вкладке Панель управления")
    public void fieldCategoryConsistsOfNumbers() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingNewsNumbers();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();

    }

    @Test
    @DisplayName("ТС-69. Поле Категория состоит из спецсимволов, при создании новости, во вкладке Панель управления мобильного приложения Мобильный хоспис (Негативный)")
    public void fieldCategoryConsistsOfSpecialCharacters() {
        ClaimsSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsControlPanelSteps.clickButtonControlPanel();
        NewsControlPanelSteps.clickAddNews();
        NewsControlPanelSteps.clickButtonCategoryCreatingCharacters();
        NewsControlPanelSteps.clickButtonTitleCreatingNews();
        NewsControlPanelSteps.clickButtonDateCreatingNews();
        NewsControlPanelSteps.clickButtonOkDateCreatingNews();
        NewsControlPanelSteps.clickButtonTimeCreatingNews();
        NewsControlPanelSteps.clickButtonOkTimeCreatingNews();
        NewsControlPanelSteps.clickDescriptionCreatingNews();
        NewsControlPanelSteps.clickButtonSaveCreatingNews();
        pressBack();
    }
}