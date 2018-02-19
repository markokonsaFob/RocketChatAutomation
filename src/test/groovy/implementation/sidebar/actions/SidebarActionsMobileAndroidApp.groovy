package implementation.sidebar.actions

import implementation.ActionsWrapper
import implementation.sidebar.pages.SidebarPage
import io.appium.java_client.MobileBy
import io.cify.framework.actions.ActionsMobileAndroidApp
import io.cify.framework.core.Device
import org.openqa.selenium.WebElement

/**
 * Created by FOB Solutions
 */
class SidebarActionsMobileAndroidApp implements ISidebarActions, ActionsMobileAndroidApp {

    Device device
    SidebarPage sidebarPage

    SidebarActionsMobileAndroidApp(Device device) {
        this.device = device
        this.sidebarPage = new SidebarPage(device)
    }

    /**
     * Checks if sidebar is visible
     * @return
     */
    @Override
    boolean isSidebarVisible() {
        if (isDisplayed(sidebarPage.getMenuButton())) {
            click(sidebarPage.getMenuButton())
            return isDisplayed(sidebarPage.getSidebar())
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

        List<WebElement> textViews = device.getDriver().findElements(MobileBy.className("android.widget.TextView"))

        click(textViews.find {
            it.getText() == username
        })
    }

    /**
     * Searches for parameter
     * @param searchParam
     */
    @Override
    void searchFor(String searchParam) {
        sendKeys(sidebarPage.getSearchBar(), searchParam)
    }

    /**
     * Clicks on result with text
     * @param text
     */
    @Override
    void clickOnResultWithText(String text) {
        click(sidebarPage.getSearchResults().find {
            it.getText() == text
        })
    }
}
