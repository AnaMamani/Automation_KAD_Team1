package com.jalasoft.sfdc.api;

import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.config.UsersConfigReader;
import com.jalasoft.sfdc.entities.User;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class APIManager {
    private Logger log = Logger.getLogger(getClass());
    //entity.
    private User user = UsersConfigReader.getInstance().getUser();
    private final String CURRENT_USER = user.getAlias();
    private final String GRANT_TYPE = "grant_type";
    private final String CLIENT_ID = "client_id";
    private final String CLIENT_SECRET = "client_secret";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    private final String ACCESS_TOKEN = "access_token";
    private final String AUTHORIZATION = "Authorization";
    private final String OAUTH = "OAuth ";     //It contains an space intentionally
    private final String QUERY = "q";
    private final String QUERY_ENDPOINT = "/query";
    private static final String SOBJECTS = "/sobjects/";
    private final String SLASH = "/";

    private ServersConfigReader serversConfigReader = ServersConfigReader.getInstance();
    private UsersConfigReader usersConfigReader = UsersConfigReader.getInstance();

    private static APIManager apiManager;

    private RequestSpecification requestSpecification;

    /**
     * Initialize the api connection and build the request specification to use in the requests
     */
    private APIManager() {
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(serversConfigReader.getServiceBaseUri())
                .addHeader(AUTHORIZATION, OAUTH.concat(getAccessTokenHeader()))
                .build();
    }

    /**
     * Gets the token of the post response
     *
     * @return String.
     */
    private String getAccessTokenHeader() {
        System.out.println(usersConfigReader.getUserByAlias(CURRENT_USER).getPassword());
        // System.out.println(usersConfigReader.getUserByAlias(CURRENT_USER).getUserToken());
        Response authenticationResponse = RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(serversConfigReader.getTokenBaseUri())
                .param(GRANT_TYPE, usersConfigReader.getUserByAlias(CURRENT_USER).getGrantType())
                .param(CLIENT_ID, usersConfigReader.getUserByAlias(CURRENT_USER).getClientId())
                .param(CLIENT_SECRET, usersConfigReader.getUserByAlias(CURRENT_USER).getClientSecret())
                .param(USERNAME, usersConfigReader.getUserByAlias(CURRENT_USER).getUserName())
                .param(PASSWORD, usersConfigReader.getUserByAlias(CURRENT_USER).getPassword().concat(usersConfigReader.getUserByAlias(CURRENT_USER).getUserToken()))
                .post();
        String ret = authenticationResponse.jsonPath().get(ACCESS_TOKEN);
        System.out.println(ret);
        return authenticationResponse.jsonPath().get(ACCESS_TOKEN);
    }

    public static APIManager getInstance() {
        if (apiManager == null) {
            apiManager = new APIManager();
        }
        return apiManager;
    }

    /**
     * Executes the get request
     *
     * @param endPoint service endpoint
     * @return {@link Response}
     */
    public Response get(final String endPoint) {
        try {
            return given()
                    .spec(requestSpecification)
                    .when()
                    .get(endPoint);
        } catch (Exception e) {
            log.error("The GET request failed", e);
            throw new IllegalStateException("The GET request failed");
        }
    }

    private String buildSQLQuery(String sObject, Map<String, Object> queryFields) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");

        List<String> list = new ArrayList<>();
        Iterator fieldsIterator = queryFields.keySet().iterator();

        while (fieldsIterator.hasNext()) {
            String key = (String) fieldsIterator.next();
            list.add(key);
        }
        query.append(String.join(", ", list));
        query.append(" from ");
        query.append(sObject);
        query.append(" where ");
        Iterator valuesIterator = queryFields.keySet().iterator();
        list.clear();
        while (valuesIterator.hasNext()) {
            String key = (String) valuesIterator.next();
            list.add(key + "=" + "'" + queryFields.get(key) + "'");
        }
        query.append(String.join(" and ", list));
        System.out.println("********query: " + query.toString());
        return query.toString();
    }

    /**
     * Executes the get request
     *
     * @return {@link Response}
     */
    public Response getQuery(String sObject, Map<String, Object> queryFields) {
        try {
            return given()
                    .spec(requestSpecification)
                    .param(QUERY, buildSQLQuery(sObject, queryFields))
                    .when()
                    .get(QUERY_ENDPOINT);
        } catch (Exception e) {
            log.error("The GET request failed", e);
            throw new IllegalStateException("The GET request failed");
        }
    }

    /**
     * Executes the post request given a Map as a data
     *
     * @param endPoint service endpoint
     * @param body     post body data
     * @return {@link Response}
     */
    public Response post(final String endPoint, final Map<String, Object> body) {
        try {
            return given().spec(requestSpecification)
                    .contentType(JSON)
                    .body(body)
                    .when()
                    .post(SOBJECTS + endPoint);
        } catch (Exception e) {
            log.error("The POST request failed", e);
            throw new IllegalStateException("The POST request failed");
        }
    }

    /**
     * Executes the delete request
     *
     * @param endPoint String route of the end point.
     * @return {@link Response}
     */
    public Response delete(final String endPoint, String id) {
        try {
            return given().spec(requestSpecification)
                    .when()
                    .delete(SOBJECTS + endPoint + SLASH + id);
        } catch (Exception e) {
            log.error("The DELETE request failed", e);
            throw new IllegalStateException("The DELETE request failed");
        }
    }
}

