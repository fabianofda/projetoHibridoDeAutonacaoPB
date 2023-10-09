package projetoHibridoDeAutonacaoPB.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import projetoHibridoDeAutonacaoPB.api.data.Usuario;

import org.junit.Test;

import static io.restassured.RestAssured.*;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class UsuarioTest extends BaseService{
    Usuario usuario = new Usuario();

    @Test
    public void deveBuscarTodosUsariosCadastrados() {

        Response response = RestAssured
                .given()
                    .header("content-type", "application/json; charset=utf-8")
                .when()
                    .get();

        response.then()
                .statusCode(200);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void deveBuscarUmUsuarioPorId() {

        Response response = RestAssured
                .given()
                .header("content-type", "application/json; charset=utf-8")
                .when()
                .get("/10");

        response.then()
                .statusCode(200);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void deveCadastrarUmNovoUsuario() throws IOException {
        String jsonSchemaPath = "src/test/resources/jsonSchema.json";
        String jsonSchema = new String(Files.readAllBytes(Paths.get(jsonSchemaPath)));

        JsonSchemaValidatorSettings settings =
                JsonSchemaValidatorSettings.settings().with().checkedValidation(false);

        Response response = RestAssured
                .given()
                .header("content-type", "application/json; charset=utf-8")
                .body(usuario.getString())
                .when()
                .post(baseURI);

        response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema).using(settings))
                .statusCode(201);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void deveExcluirUmUsuario() {

        Response response = RestAssured
                .given()
                .header("content-type", "application/json; charset=utf-8")
                .when()
                .delete("/1");

        response.then()
                .statusCode(200);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }

    @Test
    public void deveAlterarUmNovoUsuario() {

        Response response = RestAssured
                .given()
                .header("content-type", "application/json; charset=utf-8")
                .body(usuario.putString())
                .when()
                .put("/5");

        response.then()
                .statusCode(200);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }
}
