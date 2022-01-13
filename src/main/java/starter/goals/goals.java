package starter.goals;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import starter.BaseEndpoint.baseEndpoint;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class goals {
    baseEndpoint endpoint = new baseEndpoint();
    JSONObject requestparams;
    int id;

    //define request params
    public void setRequestBody(String name, String email, String gender, String status){
        requestparams = new JSONObject();
        requestparams.put("name",name);
        requestparams.put("email",email);
        requestparams.put("gender",gender);
        requestparams.put("status",status);

        SerenityRest
                .given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer d09d63bd86c466feebbd0759ac0c811859f09cbe2aef1592eb2acec303b63fb6")
                .body(requestparams.toString());
    }
    public void hitEndpointSignup(){
        SerenityRest
                .when()
                .post(endpoint.User)
                .then()
                .statusCode(201);
    }
    public void validateEndpoint(int statuscode){
        SerenityRest
                .then()
                .statusCode(statuscode);
    }
    public void hitEndpointGetUser(){
        SerenityRest
                .given()
                .header("Authorization","Bearer d09d63bd86c466feebbd0759ac0c811859f09cbe2aef1592eb2acec303b63fb6")
                .when()
                .get(endpoint.GetUser)
                .then()
                .statusCode(200);

        id = SerenityRest
                .then()
                .extract()
                .path("data[0].id");
    }
    public void hitEndpointEditUser(){
        SerenityRest
                .when()
                .put(endpoint.User+id)
                .then()
                .statusCode(200);
    }
    public void hitEndpointDeleteUser(){
        SerenityRest
                .given()
                .header("Authorization","Bearer d09d63bd86c466feebbd0759ac0c811859f09cbe2aef1592eb2acec303b63fb6")
                .when()
                .delete(endpoint.User+id)
                .then()
                .statusCode(204);
    }
}
