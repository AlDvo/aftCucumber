package taskWork.taskwork4.manager;

import taskWork.taskwork4.pages.CompleteHousePage;
import taskWork.taskwork4.pages.MainPage;

public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private MainPage mainPage;

    /**
     * Страничка покупки вторичного жилья
     */
    private CompleteHousePage completeHousePage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link MainPage}
     *
     * @return StartPage
     */
    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    /**
     * Ленивая инициализация {@link CompleteHousePage}
     *
     * @return InsurancePage
     */
    public CompleteHousePage getCompleteHousePage() {
        if (completeHousePage == null) {
            completeHousePage = new CompleteHousePage();
        }
        return completeHousePage;
    }
}
