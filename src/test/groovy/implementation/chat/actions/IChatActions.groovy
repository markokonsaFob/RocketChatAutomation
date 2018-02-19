package implementation.chat.actions

/**
 * Created by FOB Solutions
 */
interface IChatActions {

    /**
     * Verifies if chatbar is visible
     * @return
     */
    boolean isChatBarVisible()

    /**
     * Sends message
     * @param message
     */
    void sendMessage(String message)

    /**
     * Gets last message
     * @return
     */
    String getLastMessage()

}