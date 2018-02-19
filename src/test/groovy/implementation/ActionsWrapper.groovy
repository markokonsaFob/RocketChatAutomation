package implementation

import io.cify.framework.core.Device
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

}