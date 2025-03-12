package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static utils.PropertyReader.getConfigValue;

public class Constants {
    public static final String CHROME = "CHROME";
    public static final boolean HEADLESS = Boolean.parseBoolean(getConfigValue("headless","config.properties"));

    public static final String URL = getConfigValue("url","testdata.properties");
    public static final String PROFILE_URL = getConfigValue("profileUrl","testdata.properties");

    public static final int WAIT_IMPLICIT = Integer.parseInt(getConfigValue("wait_implicit","config.properties"));
    public static final int WAIT_EXPLICIT = Integer.parseInt(getConfigValue("wait_explicit","config.properties"));

    public static final String USER = getConfigValue("username","testdata.properties");
    public static final String PASSWORD = getConfigValue("password","testdata.properties");

    public static final String BLANK_EMAIL = getConfigValue("blank_email","testdata.properties");
    public static final String INVALID_EMAIL = getConfigValue("invalid_email","testdata.properties");
    public static final String INVALID_PASS = getConfigValue("invalid_password","testdata.properties");
    public static final String WRONG_CREDENTIALS = getConfigValue("wrong_credentials","testdata.properties");

    public static final String CONTACT_EMAIL = getConfigValue("contacts_email","testdata.properties");
    public static final String PHONE_1 = getConfigValue("contacts_phone_1","testdata.properties");
    public static final String PHONE_2 = getConfigValue("contacts_phone_2","testdata.properties");
    public static final String CONTACT_ADDRESS_1 = getConfigValue("contacts_address_1","testdata.properties");
    public static final String CONTACT_ADDRESS_2 = getConfigValue("contacts_address_2","testdata.properties");

    public static final String LOGIN = "LOGIN";
    public static final String REGISTER = "REGISTER";
    public static final String CONTACTS = "CONTACTS";

    private final static Logger logger = LogManager.getLogger();
    public static final String BROWSER = getBrowserName();

    private static String getBrowserName() {
        String platformNameFromPomXml = System.getProperty("platform");
        String platformName;
        if (platformNameFromPomXml != null)
            platformName = platformNameFromPomXml;
        else {
            logger.warn("The Maven Profile is missing the platform configuration.");
            logger.warn("The default platform '{}' will be enabled for this run.", CHROME);
            platformName = CHROME;
        }

        return platformName.toLowerCase();
    }
}
