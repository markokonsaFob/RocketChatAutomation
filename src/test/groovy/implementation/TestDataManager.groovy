package implementation

import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
import io.cify.framework.core.DeviceCategory

class TestDataManager {

    private static final String DATA_FILE_NAME = "data.json"
    private static final String CONVO_FILE_NAME = "conversation.json"

    private static ThreadLocal<LazyMap> testData = new ThreadLocal<>([:])
    private static ThreadLocal<DeviceCategory> activeDevice = new ThreadLocal<DeviceCategory>()

    /**
     * Return WEB application URL based on the test data file content
     * @return String - URL
     */
    static String getWebURL() {
        getTestDataFileContent().environment.URL
    }

    /**
     * Gets account from data file
     * @param name
     * @return
     */
    static Account getAccount(String name) {
        LazyMap accounts = getTestDataFileContent().accounts as LazyMap
        new Account(accounts.get(name) as LazyMap)
    }

    /**
     * Returns all test data from file
     * @return LazyMap of test data
     */
    static LazyMap getTestDataFileContent() {
        File dataFile = new File(DATA_FILE_NAME)
        if (!dataFile.exists()) throw new RocketTestException("Data file is missing from project root. Please add $DATA_FILE_NAME into project root")
        new JsonSlurper().parse(new File(DATA_FILE_NAME)) as LazyMap
    }

    /**
     * Returns all test data from file
     * @return LazyMap of test data
     */
    static LazyMap getConversation() {
        File dataFile = new File(CONVO_FILE_NAME)
        if (!dataFile.exists()) throw new RocketTestException("Conversation file is missing from project root. Please add $CONVO_FILE_NAME into project root")
        new JsonSlurper().parse(new File(CONVO_FILE_NAME)) as LazyMap
    }

    /**
     * Saves a key-value pair to map for given device
     * @param key Key for the value
     * @param value value to be saved
     */
    static void setTestData(String key, String value) {
        getTestData().put(key, value)
    }

    /**
     * Returns value from device specific map
     * @param key Key for the value
     * @return String value from map
     */
    static String getValue(String key) {
        getTestData().get(key)
    }

    private static LazyMap getTestData() {
        if (testData.get() == null) {
            testData.set([:] as LazyMap)
        }
        testData.get() as LazyMap
    }
}

class Account {
    String username
    String password
}