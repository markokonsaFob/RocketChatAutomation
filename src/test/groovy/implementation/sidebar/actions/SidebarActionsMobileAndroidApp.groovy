package implementation.sidebar.actions

import implementation.RocketTestException
import implementation.sidebar.pages.SidebarPage
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileDriver
import io.appium.java_client.TouchAction
import io.cify.framework.actions.ActionsMobileAndroidApp
import io.cify.framework.core.Device
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

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
        return isDisplayed(sidebarPage.getSidebar())
    }

    /**
     * Opens sidebar
     */
    @Override
    void openSidebar() {
        try {
            waitForCondition(device, ExpectedConditions.visibilityOf(sidebarPage.getSidebar()), 30)
            new TouchAction(device.getDriver() as MobileDriver)
                    .press(sidebarPage.getMenuButton())
                    .moveTo(sidebarPage.getMenuButton().getSize().getWidth(), 100)
                    .release().perform()
        } catch (ignored) {
            throw new RocketTestException("Menu button is not visible and sidebar is not opened!")
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
