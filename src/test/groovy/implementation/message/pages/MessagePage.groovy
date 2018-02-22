package implementation.message.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSFindBy
import io.cify.framework.PageObjects
import io.cify.framework.core.Device
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

/**
 * Created by FOB Solutions
 */
class MessagePage extends PageObjects {

    @AndroidFindBy(id = "editor")
    @FindBy(name = "msg")
    @iOSFindBy(accessibility = "sendMessageTextField")
    WebElement messageBox

    @AndroidFindBy(id = "button_send")
    @FindBy(className = "rc-message-box__send")
    @iOSFindBy(accessibility = "sendMessage")
    WebElement sendButton

    @FindBy(className = "rc-message-box__action--send")
    WebElement sendMobileWebButton

    @AndroidFindBy(className = "android.widget.TextView")
    @iOSFindBy(className = "XCUIElementTypeTextView")
    @FindBy(css = ".message .body")
    List<WebElement> textViews

    private Device device

    MessagePage(Device device) {
        super(device)
        this.device = device
    }

}
