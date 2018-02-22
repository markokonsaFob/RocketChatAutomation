package implementation.sidebar.actions

import implementation.sidebar.pages.SidebarPage
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.core.Device

/**
 * Created by FOB Solutions
 */
class SidebarActionsDesktopWeb implements ISidebarActions, ActionsDesktopWeb {

    Device device
    SidebarPage sidebarPage

    SidebarActionsDesktopWeb(Device device) {
        this.device = device
        this.sidebarPage = new SidebarPage(device)
    }

    /**
     * Checks if sidebar is visible
     * @return
     */
    @Override
    boolean isSidebarVisible() {
        return isDisplayed(sidebarPage.getSidebar())
    }

    /**
     * Opens sidebar
     */
    @Override
    void openSidebar() {

    }

    /**
     * Clicks on a username in sidebar
     * @param accountName
     */
    @Override
    void clickOnUsername(String username) {
        click(sidebarPage.getSidebarItems().find {
            it.getText() == username
        })
    }

    /**
     * Searches for parameter
     * @param searchParam
     */
    @Override
    void searchFor(String searchParam) {

    }

    /**
     * Clicks on result with text
     * @param text
     */
    @Override
    void clickOnResultWithText(String text) {

    }
}
