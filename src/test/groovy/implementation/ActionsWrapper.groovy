package implementation

import io.appium.java_client.MobileDriver
import io.cify.framework.core.Device
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

class ActionsWrapper {

    /**
     * Waits for condition
     * @param condition closure that returns true, false
     * @param timeOut in ms
     * @return True if condition is met
     */
    static boolean waitForCondition(Device device, Closure condition, long timeOut) {
        try {
            WebDriverWait w = new WebDriverWait(device.getDriver(), timeOut)
            w.until(new ExpectedCondition<Boolean>() {
                Boolean apply(WebDriver d) {
                    try {
                        return condition()
                    } catch (ignore) {
                        false
                    }
                }
            })
        } catch (all) {
            throw new RocketTestException("Waiting for condition failed! " + "CONDITION: " + condition + " cause " + all.message)
        }
    }

    /**
     * Automatically dismiss alerts
     * */
    static void autoAcceptAlerts(Device device) {
        boolean accept = true

        while (accept) {
            try {
                waitForCondition(device, {
                    if (device.getCapabilities().getCapability("capability") == "android") {
                        autoAcceptAndroidBrowser(device)
                    } else {
                        try {
                            (device.getDriver() as MobileDriver).switchTo().alert().accept()
                            return true
                        } catch (ignored) {
                            return false
                        }
                    }
                }, 10)
            } catch (ignored) {
                accept = false
            }
        }
    }

    private static boolean autoAcceptAndroidBrowser(Device device) {
        try {
            (device.getDriver() as MobileDriver).context("NATIVE_APP").findElement(By.id("button1")).click()
            device.getDriver().findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click()
            return true
        } catch (ignored) {
            (device.getDriver() as MobileDriver).context("CHROMIUM")
            return false
        }
    }
}