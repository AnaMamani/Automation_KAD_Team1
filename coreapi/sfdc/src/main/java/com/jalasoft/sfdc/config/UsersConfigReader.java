package com.jalasoft.sfdc.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jalasoft.sfdc.entities.User;
import com.jalasoft.utils.JsonReader;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * user config reader class.
 *
 * @author Silvia Valencia
 * @since 6/14/2018
 */
public final class UsersConfigReader {
    private Logger log = Logger.getLogger(getClass());
    private static final String USER_NAME = "user name";
    private static final String USER_PASSWORD = "user password";
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String USER_TOKEN = "user token";
    private static final String GRANT_TYPE = "grant type";
    private static final String CLIENT_ID = "client id";
    private static final String CLIENT_SECRET = "client secret";

    private static HashMap<String, User> users;
    private JsonReader usersReader;

    private User user = new User();

    private static UsersConfigReader instance;

    /**
     * Gets instance of UsersConfigReader.
     *
     * @return the current instance.
     */
    public static UsersConfigReader getInstance() {
        if (instance == null) {
            instance = new UsersConfigReader();
        }
        return instance;
    }

    /**
     * Reads values from json file.
     *
     * @param UsersConfigFileName - User file of configuration.
     */
    public void initialize(final String UsersConfigFileName) {
        log.info("UsersConfigReader initialize: Read the users settings from " + UsersConfigFileName);
        usersReader = new JsonReader(UsersConfigFileName);

        JsonParser parser = new JsonParser();
        FileReader fr = null;
        try {
            fr = new FileReader(UsersConfigFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonElement dataUsers = parser.parse(fr);

        String[] data = dataUsers.toString().replace("{", "").
                replace("}", "").split(",");
        users = new HashMap<>();
        for (String key : data) {
            if (key.contains(USER_NAME)) {
                String[] alias = key.split(":");
                user = new User();
                user.setUserName(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), USER_NAME));
                user.setPassword(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), USER_PASSWORD));
                user.setGrantType(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), GRANT_TYPE));
                user.setUserToken(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), USER_TOKEN));
                user.setClientId(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), CLIENT_ID));
                user.setClientSecret(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), CLIENT_SECRET));
                user.setFirstName(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), FIRST_NAME));
                user.setLastName(usersReader.getKeyValue(alias[0].substring(1, alias[0].length() - 1), LAST_NAME));
                user.setAlias(alias[0].substring(1, alias[0].length() - 1));

                users.put(alias[0].substring(1, alias[0].length() - 1), user);
            }
        }

        // Get User credentials

        // ToDo update the following 2 lines
        /* review how to read the all the users from the SFDCUsers.json, and manage in a List or a Map or whenever
        you want to be able later to get the user according the alias
         */
    }

    /**
     * Gets the user given the alias.
     *
     * @param userAlias - The alias of the user.
     * @return User.
     */
    public User getUserByAlias(String userAlias) {
        user = users.get(userAlias);
        return user;
    }

    /**
     * Gets the user given the alias.
     *
     * @return User.
     */
    public User getUser() {
        return user;
    }
}
