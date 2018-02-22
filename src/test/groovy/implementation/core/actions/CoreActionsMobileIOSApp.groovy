package implementation.core.actions

import implementation.ActionsWrapper
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device

/**
 * Created by FOB Solutions
 */
class CoreActionsMobileIOSApp implements ICoreActions, ActionsMobileIOSApp {

    Device device

    CoreActionsMobileIOSApp(Device device) {
        this.device = device
    }

    /**
     * Open application
     */
    @Override
    void openApplication() {
        device.openApp()
        ActionsWrapper.autoAcceptAlerts(device)
    }
}
