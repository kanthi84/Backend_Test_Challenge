package Utilities;

import cucumber.api.Scenario;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.assertion.Assertion;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


import java.util.logging.Logger;

public class Support {
    Logger logger = Logger.getLogger( Support.class.getName());

    int id;
    String idStr ;

    Endpoints endPoints = new Utilities.Endpoints();

    Response response;

    String usersURI = endPoints.baseUrl + endPoints.users;
    String postsURI = endPoints.baseUrl + endPoints.posts;


    public void doGetRequest(String endPoint){
        response = given()
                .relaxedHTTPSValidation()
                .header("Content-Type", JSON)
                .when()
                .get(endPoint)
                .then()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .response();
    }

    public void fetchUser(){
        doGetRequest(usersURI);
    }

    public void isUserPresent(String uName){
        fetchUser();
        List<String> uNames = response.jsonPath().getList("username");
        boolean userExists = uNames.contains(uName);
        if (userExists){
            logger.info("\n User Existing in Users list:" +uName);
        }
        else
            throw new RuntimeException("\n Invalid user, please try with valid user name");

//        assertEquals(response.path("username[2]"), uName);
    }

    public void fetchIdforUser(String uName){
        id = response.path("find{it.username == 'Samantha'}.id ");
        logger.info("\n Id for user" +uName  +id );
    }

    public void fetchUserPosts(String uName){
        idStr = Integer.toString(id);
        String postsURIuId = postsURI + idStr;
        logger.info("\n User posts for" +uName);
        doGetRequest(postsURIuId);
    }

    public void retrieveUserComments(String uName) {
        idStr = Integer.toString(id);
        String commentsURIuId = postsURI + idStr + endPoints.comments;
        logger.info(" \n Comments for user" +uName);
        doGetRequest(commentsURIuId);
    }

    public void validateEmailFormat() {
        List<String> emailAddress = response.jsonPath().getList("email");
        System.out.println(emailAddress);

        for(int i = 0; i < emailAddress.size(); i++){
            String email = emailAddress.get(i);
            isVaid(email);
        }
    }

    static boolean isVaid(String email){
        String regEx = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regEx);
    }

}
