package implementation.sidebar.actions

/**
 * Created by FOB Solutions
 */
interface ISidebarActions {

    /**
     * Checks if sidebar is visible
     * @return
     */
    boolean isSidebarVisible()

    /**
     * Clicks on a username in sidebar
     * @param accountName
     */
    void clickOnUsername(String username)

    /**
     * Searches for parameter
     * @param searchParam
     */
    void searchFor(String searchParam)

    /**
     * Clicks on result with text
     * @param text
     */
    void clickOnResultWithText(String text)
}