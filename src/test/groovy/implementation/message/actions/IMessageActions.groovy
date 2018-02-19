package implementation.message.actions

/**
 * Created by FOB Solutions
 */
interface IMessageActions {

    /**
     * Verifies if message view is visible
     * @return
     */
    boolean isMessageViewVisible()

    /**
     * Sends message
     * @param message
     */
    void sendMessage(String message)

    /**
     * Verifies if message is visible
     * @param message
     * @return
     */
    boolean isMessageVisible(String message)

}