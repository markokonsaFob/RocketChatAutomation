package implementation.message.actions

import implementation.message.pages.MessagePage
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device

import static implementation.ActionsWrapper.waitForCondition

/**
 * Created by FOB Solutions
 */
class MessageActionsMobileWeb implements IMessageActions, ActionsDesktopWeb {
    Device device
    MessagePage messagePage

    MessageActionsMobileWeb(Device device) {
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
        click(messagePage.getSendMobileWebButton())
    }

    /**
     * Verifies if message is visible
     * @param message
     * @return
     */
    @Override
    boolean isMessageVisible(String message) {
        waitForCondition(device, {
            messagePage.getTextViews().last().getText() == message
        }, 60)
    }
}
