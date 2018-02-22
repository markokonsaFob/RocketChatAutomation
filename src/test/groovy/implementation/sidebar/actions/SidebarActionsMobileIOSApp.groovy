package implementation.sidebar.actions

import implementation.ActionsWrapper
import implementation.RocketTestException
import implementation.sidebar.pages.SidebarPage
import io.appium.java_client.MobileBy
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device
import org.openqa.selenium.support.ui.ExpectedConditions

/**
 * Created by FOB Solutions
 */
class SidebarActionsMobileIOSApp implements ISidebarActions, ActionsMobileIOSApp {

    Device device
    SidebarPage mainPage

    SidebarActionsMobileIOSApp(Device device) {
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
     * Opens sidebar
     */
    @Override
    void openSidebar() {
        if (!isDisplayed(mainPage.getSidebar())) {
            try {
                click(mainPage.getMenuButton())
            } catch (ignored) {
                throw new RocketTestException("Menu button is not visible and sidebar is not opened!")
            }
        }
    }

    /**
     * Clicks on a username in sidebar
     * @param accountName
     */
    @Override
    void clickOnUsername(String username) {
        click(getElementWithAccessibility(username))
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

    private getElementWithAccessibility(String accessibility) {
        return device.getDriver().findElement(MobileBy.id(accessibility))
    }
}
