package steps

import cucumber.api.groovy.EN
import groovyx.gpars.GParsPool
import implementation.Account
import implementation.ActionsImpl
import implementation.ActionsWrapper
import implementation.RocketTestException
import implementation.TestDataManager
import implementation.hostname.actions.IHostnameActions
import implementation.login.actions.ILoginActions
import io.cify.framework.core.Device
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(EN)

Before("@LoggedInUsers") {

    GParsPool.withPool {
        GParsPool.executeAsyncAndWait(
                { loginWithMobileDevice(DeviceCategory.ANDROID) },
                { loginWithMobileDevice(DeviceCategory.IOS) },
                { loginWithMobileDevice(DeviceCategory.BROWSER) }
        )
    }
}

After {
    DeviceManager.getInstance().quitAllDevices()
}

private static loginWithMobileDevice(DeviceCategory category) {
   DeviceManager.getInstance().createDevice(category)

    ActionsImpl.getCoreActions(category).openApplication()

    if (category == DeviceCategory.BROWSER) {
        DeviceManager.getInstance().getActiveDevice(category).getDriver().get(TestDataManager.getWebURL())
        ActionsWrapper.autoAcceptAlerts(DeviceManager.getInstance().getActiveDevice(category))
    } else {
        IHostnameActions hostActions = ActionsImpl.getHostActions(category)
        if (!hostActions.isHostViewVisible()) {
            throw new RocketTestException("Host view should be visible!")
        }
        hostActions.enterHostname(TestDataManager.getWebURL())
        hostActions.submit()
    }

    ILoginActions loginActions = ActionsImpl.getLoginActions(category)
    if (!loginActions.isLoginPageVisible()) {
        throw new RocketTestException("Login page should be visible")
    }

    Account account = TestDataManager.getAccount(category.toString())
    loginActions.enterUsername(account.getUsername())
    loginActions.enterPassword(account.getPassword())
    loginActions.clickLogin()
}
