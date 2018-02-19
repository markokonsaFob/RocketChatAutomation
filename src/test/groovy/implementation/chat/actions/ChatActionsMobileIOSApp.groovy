package implementation.chat.actions

import implementation.hostname.actions.IHostnameActions
import implementation.hostname.pages.HostnamePage
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device

/**
 * Created by FOB Solutions
 */
class ChatActionsMobileIOSApp implements IChatActions, ActionsMobileIOSApp {

    Device device
    HostnamePage hostnamePage

    ChatActionsMobileIOSApp(Device device) {
        this.device = device
        this.hostnamePage = new HostnamePage(device)
    }

    /**
     * Verifies if chatbar is visible
     * @return
     */
    @Override
    boolean isChatBarVisible() {
        return false
    }

    /**
     * Sends message
     * @param message
     */
    @Override
    void sendMessage(String message) {

    }

    /**
     * Gets last message
     * @return
     */
    @Override
    String getLastMessage() {
        return null
    }
}
