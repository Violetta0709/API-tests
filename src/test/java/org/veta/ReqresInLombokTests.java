package org.veta;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import models.lombok.*;
import models.lombok.UserUpdateLombokBodyModel;
import models.pojo.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReqresInLombokTests {

    @BeforeAll
    static void configure() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    @DisplayName("User creation")
    void createUser() {
        UserCreationLombokBodyModel body = new UserCreationLombokBodyModel();
        body.setName("morpheus");
        body.setJob("leader");

        UserCreationResponseLombokModel response = given()
                .filter(withCustomTemplates())
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .extract().as(UserCreationResponseLombokModel.class);
        assertThat(response.getJob()).isEqualTo("leader");
        assertThat(response.getName()).isEqualTo("morpheus");
        assertThat(response.getCreatedAt()).isNotNull();
        assertThat(response.getId()).isNotNull();

    }

    @Test
    @DisplayName("Successful registration")
    void userRegister() {
        SuccessfullRegistrationLombokBodyModel body = new SuccessfullRegistrationLombokBodyModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("pistol");
        SuccessfullRegistartionLombokResponseModel response = given()
                .filter(withCustomTemplates())
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(SuccessfullRegistartionLombokResponseModel.class);
        assertThat(response.getToken()).isNotNull();
        assertThat(response.getId()).isNotNull();
    }

    @Test
    @DisplayName("Unsuccessful registration")
    void trytoRegister() {
        UnsuccessfullRegistrationLombokBodyModel body = new UnsuccessfullRegistrationLombokBodyModel();
        body.setEmail("veta@fife");
        UnsuccessfullRegistrationLombokResponseModel response = given()
                .filter(withCustomTemplates())
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .extract().as(UnsuccessfullRegistrationLombokResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing password");
    }

    @Test
    @DisplayName("User information update")
    void updateInfo() {
        UserUpdateLombokBodyModel body = new UserUpdateLombokBodyModel();
        body.setJob("zion president");
        body.setName("morpheus");
        UserUpdtateLombokResponseModel response = given()
                .filter(withCustomTemplates())
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .patch("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(UserUpdtateLombokResponseModel.class);
        assertThat(response.getJob()).isEqualTo("zion president");
        assertThat(response.getName()).isEqualTo("morpheus");
        assertThat(response.getUpdatedAt()).isNotNull();
    }

    @Test
    @DisplayName("Login unsuccessful")
    void tryLogin() {
        LoginUnsuccessfullLombokBodyModel body = new LoginUnsuccessfullLombokBodyModel();
        body.setEmail("peter@klaven");
        LoginUnsiccessfullLombokResponseModel response = given()
                .filter(withCustomTemplates())
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .extract().as(LoginUnsiccessfullLombokResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing password");
    }
}

