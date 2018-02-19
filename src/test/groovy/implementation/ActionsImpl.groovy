package implementation

import implementation.core.actions.ICoreActions
import implementation.hostname.actions.IHostnameActions
import implementation.login.actions.ILoginActions
import implementation.message.actions.IMessageActions
import implementation.sidebar.actions.ISidebarActions
import io.cify.framework.Actions
import io.cify.framework.core.Device
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

/**
 * Created by FOB Solutions
 */
class ActionsImpl {

    private static final String IMPLEMENTATION_PACKAGE = "implementation."

    /**
     * Gets core actions for current device
     * @return
     */
    static ICoreActions getCoreActions() {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice()
        return (ICoreActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "core.actions.CoreActions")
    }

    /**
     * Gets core actions for category
     * @return
     */
    static ICoreActions getCoreActions(DeviceCategory category) {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice(category)
        return (ICoreActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "core.actions.CoreActions")
    }

    /**
     * Get Hostname actions for current device
     * @return
     */
    static IHostnameActions getHostActions() {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice()
        return (IHostnameActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "hostname.actions.HostnameActions")
    }

    /**
     * Get Hostname actions for category
     * @return
     */
    static IHostnameActions getHostActions(DeviceCategory category) {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice(category)
        return (IHostnameActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "hostname.actions.HostnameActions")
    }

    /**
     * Get login actions for current device
     * @return
     */
    static ILoginActions getLoginActions() {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice()
        return (ILoginActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "login.actions.LoginActions")
    }

    /**
     * Get login actions for category
     * @return
     */
    static ILoginActions getLoginActions(DeviceCategory category) {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice(category)
        return (ILoginActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "login.actions.LoginActions")
    }

    /**
     * Get sidebar actions for current device
     * @return
     */
    static ISidebarActions getSidebarActions() {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice()
        return (ISidebarActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "sidebar.actions.SidebarActions")
    }

    /**
     * Get sidebar actions for category
     * @param category
     * @return
     */
    static ISidebarActions getSidebarActions(DeviceCategory category) {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice(category)
        return (ISidebarActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "sidebar.actions.SidebarActions")
    }

    /**
     * Get message actions for current device
     * @return
     */
    static IMessageActions getMessageActions() {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice()
        return (IMessageActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "message.actions.MessageActions")
    }

    /**
     * Get message actions for category
     * @param category
     * @return
     */
    static IMessageActions getMessageActions(DeviceCategory category) {
        Device currentDevice = DeviceManager.getInstance().getActiveDevice(category)
        return (IMessageActions) Actions.getCustomActions(currentDevice, IMPLEMENTATION_PACKAGE + "message.actions.MessageActions")
    }

}
