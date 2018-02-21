package implementation.message.actions

import implementation.message.pages.MessagePage
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder
import io.cify.framework.actions.ActionsMobileAndroidApp
import io.cify.framework.core.Device

import java.time.Duration

import static implementation.ActionsWrapper.waitForCondition

/**
 * Created by FOB Solutions
 */
class MessageActionsMobileAndroidApp implements IMessageActions, ActionsMobileAndroidApp {
    Device device
    MessagePage messagePage

    MessageActionsMobileAndroidApp(Device device) {
        this.device = device
        this.messagePage = new MessagePage(device)
    }

    /**
     * Verifies if message view is visible
     * @return
     */
    @Override
    boolean isMessageViewVisible() {
        return isDisplayed(messagePage.getMessageBox())
    }

    /**
     * Sends message
     * @param message
     */
    @Override
    void sendMessage(String message) {

        sendKeys(messagePage.getMessageBox(), message)
        click(messagePage.getSendButton())
    }

    /**
     * Verifies if message is visible
     * @param message
     * @return
     */
    @Override
    boolean isMessageVisible(String message) {
        waitForCondition(device, {
            messagePage.getTextViews().find {
                it.getText().contains(message)
            }
        }, 60)
    }
}
