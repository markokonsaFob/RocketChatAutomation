package implementation.sidebar.pages

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSFindBy
import io.cify.framework.PageObjects
import io.cify.framework.core.Device
import org.aspectj.weaver.ast.And
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

/**
 * Created by FOB Solutions
 */
class SidebarPage extends PageObjects{

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Rocket.Chat+\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    @AndroidFindBy(id = "chat.rocket.android:id/sidebar_fragment_container")
    @FindBy(className = "sidebar")
    WebElement sidebar

    @iOSFindBy(accessibility = "Menu")
    @AndroidFindBy(id = "chat.rocket.android:id/drawee_server_button")
    @FindBy(className = "burger")
    WebElement menuButton

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Rocket.Chat+\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField/XCUIElementTypeTextField")
    @AndroidFindBy(id = "chat.rocket.android:id/search_src_text")
    @FindBy(css = ".toolbar__search .rc-input__element")
    WebElement searchBar

    @AndroidFindBy(id = "chat.rocket.android:id/name")
    List<WebElement> searchResults

    @FindBy(className = "sidebar-item__name")
    List<WebElement> sidebarItems

    SidebarPage(Device device) {
        super(device)
    }

}
