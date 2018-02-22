package implementation.sidebar.actions

import implementation.sidebar.pages.SidebarPage
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.core.Device

/**
 * Created by FOB Solutions
 */
class SidebarActionsMobileWeb implements ISidebarActions, ActionsDesktopWeb {

    Device device
    SidebarPage mainPage

    SidebarActionsMobileWeb(Device device) {
        this.device = device
        this.mainPage = new SidebarPage(device)
    }

    /**
     * Checks if sidebar is visible
     * @return
     */
    @Override
    boolean isSidebarVisible() {
        if (isDisplayed(mainPage.getMenuButton())) {
            click(mainPage.getMenuButton())
            return isDisplayed(mainPage.getSidebar())
        } else {
            return false
        }
    }

    /**
     * Clicks on a username in sidebar
     * @param accountName
     */
    @Override
    void clickOnUsername(String username) {
        click(mainPage.getSidebarItems().find {
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
