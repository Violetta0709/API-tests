package org.veta;

import io.restassured.RestAssured;
import models.pojo.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReqresInPojoTests {

    @BeforeAll
    static void configure() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    @DisplayName("User creation")
    void createUser() {
        UserCreationBodyModel body = new UserCreationBodyModel();
        body.setName("morpheus");
        body.setJob("leader");

        UserCreationResponseModel response = given()
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .extract().as(UserCreationResponseModel.class);
        assertThat(response.getJob()).isEqualTo("leader");
        assertThat(response.getName()).isEqualTo("morpheus");
        assertThat(response.getCreatedAt()).isNotNull();
        assertThat(response.getId()).isNotNull();

    }

    @Test
    @DisplayName("Successful registration")
    void userRegister() {
        SuccessfullRegistrationBodyModel body = new SuccessfullRegistrationBodyModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("pistol");
        SuccessfullRegistartionResponseModel response = given()
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(SuccessfullRegistartionResponseModel.class);
        assertThat(response.getToken()).isNotNull();
        assertThat(response.getId()).isNotNull();
    }

    @Test
    @DisplayName("Unsuccessful registration")
    void trytoRegister() {
        UnsuccessfullRegistrationBodyModel body = new UnsuccessfullRegistrationBodyModel();
        body.setEmail("veta@fife");
        UnsuccessfullRegistrationResponseModel response = given()
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .extract().as(UnsuccessfullRegistrationResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing password");
    }

    @Test
    @DisplayName("User information update")
    void updateInfo() {
        UserUpdateLombokBodyModel body = new UserUpdateLombokBodyModel();
        body.setJob("zion president");
        body.setName("morpheus");
        UserUpdtateLombokResponseModel response = given()
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
        LoginUnsuccessfullBodyModel body = new LoginUnsuccessfullBodyModel();
        body.setEmail("peter@klaven");
        LoginUnsiccessfullResponseModel response = given()
                .log().all()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .extract().as(LoginUnsiccessfullResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing password");
    }
}

