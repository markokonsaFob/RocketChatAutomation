package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import implementation.ActionsImpl
import implementation.RocketTestException
import implementation.TestDataManager
import io.cify.framework.core.DeviceCategory

/**
 * Created by FOB Solutions
 */
this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Given(~/^sidebar is visible on (.+) device$/) { DeviceCategory category ->
    int maxTries = 3
    int currentCount = 0
    boolean isVisible = false

    while (!isVisible && currentCount < maxTries) {
        isVisible = ActionsImpl.getSidebarActions(category).isSidebarVisible()
        currentCount++
    }
    if (!isVisible) {
        throw new RocketTestException("Sidebar should be visible on " + category)
    }
}

When(~/^user opens direct messenger with (.+) account on (.+) device$/) { DeviceCategory account, DeviceCategory category ->
    String username = TestDataManager.getAccount(account.toString()).getUsername()
    ActionsImpl.getSidebarActions(category).clickOnUsername(username)
}
Then(~/^direct messenger view should be visible on (.+) device$/) { DeviceCategory category ->
    if (!ActionsImpl.getMessageActions(category).isMessageViewVisible()) {
        throw new RocketTestException("Message view should be visible on " + category)
    }
}
When(~/^user send message from (.+) device$/) { DeviceCategory category ->
    TestDataManager.setTestData("message", new Date().toString())
    ActionsImpl.getMessageActions(category).sendMessage(TestDataManager.getValue("message"))
}
Then(~/^message should be visible on (.+) device$/) { DeviceCategory category ->
    if (!ActionsImpl.getMessageActions(category).isMessageVisible(TestDataManager.getValue("message"))) {
        throw new RocketTestException("Message with text: " + TestDataManager.getValue("message") + " should be visible")
    }
}
When(~/^user open "([^"]*)" channel on (.+) device$/) { String channelName, DeviceCategory category ->
    ActionsImpl.getSidebarActions(category).clickOnUsername(channelName)
}
Then(~/^(.+) and (.+) are having a conversation with each other$/) {DeviceCategory category1, DeviceCategory category2 ->
    TestDataManager.getConversation().each {

        String question = it.getValue()[category1.toString()]
        String answer = it.getValue()[category2.toString()]

        ActionsImpl.getMessageActions(category1).sendMessage(question)

        if (!ActionsImpl.getMessageActions(category2).isMessageVisible(question)) {
            throw new RocketTestException("Message with text: " + question + " should be visible")
        }

        ActionsImpl.getMessageActions(category2).sendMessage(answer)

        if (!ActionsImpl.getMessageActions(category1).isMessageVisible(answer)) {
            throw new RocketTestException("Message with text: " + answer + " should be visible")
        }

    }

}
Given(~/^user opens sidebar on (.+) device$/) { DeviceCategory category ->
   ActionsImpl.getSidebarActions(category).openSidebar()
}