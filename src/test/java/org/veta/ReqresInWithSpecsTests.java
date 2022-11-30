package org.veta;

import models.lombok.*;
import models.pojo.UserUpdtateLombokResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static specs.UnsuccessLoginRequestSpec.unsuccessLoginRequestSpec;
import static specs.UnsuccessLoginResponseSpec.unsuccessLoginResponseSpec;
import static specs.UnsuccessRegRequestSpec.unsuccessRequestSpec;
import static specs.UnsuccessRegResponseSpec.unsuccessResponseSpec;
import static specs.SuccessRegRequestSpec.successRequestSpec;
import static specs.SuccessRegResponseSpec.successResponseSpec;
import static specs.UserCreationRequestSpecs.userCreationRequestSpec;
import static specs.UserCreationResponseSpecs.userCreationResponseSpec;
import static specs.UserUpdateRequestSpec.infoUpdateRequestSpec;
import static specs.UserUpdateRequestSpec.infoUpdateRequestSpec;
import static specs.UserUpdateResponseSpec.infoUpdateResponseSpec;

public class ReqresInWithSpecsTests {

    @Test
    @DisplayName("User creation")
    void createUser() {
        UserCreationLombokBodyModel body = new UserCreationLombokBodyModel();
        body.setName("morpheus");
        body.setJob("leader");

        UserCreationResponseLombokModel response = given()
                .spec(userCreationRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(userCreationResponseSpec)
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
                .spec(successRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(successResponseSpec)
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
                .spec(unsuccessRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(unsuccessResponseSpec)
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
                .spec(infoUpdateRequestSpec)
                .body(body)
                .when()
                .patch()
                .then()
                .spec(infoUpdateResponseSpec)
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
                .spec(unsuccessLoginRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(unsuccessLoginResponseSpec)
                .extract().as(LoginUnsiccessfullLombokResponseModel.class);
        assertThat(response.getError()).isEqualTo("Missing password");
    }
}

