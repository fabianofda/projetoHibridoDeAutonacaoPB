package projetoHibridoDeAutonacaoPB.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import projetoHibridoDeAutonacaoPB.api.data.Usuario;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

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
                .statusCode(200)
                .body("size()", Matchers.equalTo(10));

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
                .statusCode(200)
                .body("id", Matchers.equalTo(10))
                .body("name", Matchers.equalTo("Clementina DuBuque"))
                .body("username", Matchers.equalTo("Moriah.Stanton"))
                .body("email", Matchers.equalTo("Rey.Padberg@karina.biz"))
                .body("address.street", Matchers.equalTo("Kattie Turnpike"))
                .body("address.suite", Matchers.equalTo("Suite 198"))
                .body("address.city", Matchers.equalTo("Lebsackbury"))
                .body("address.zipcode", Matchers.equalTo("31428-2261"))
                .body("address.geo.lat", Matchers.equalTo("-38.2386"))
                .body("address.geo.lng", Matchers.equalTo("57.2232"))
                .body("phone", Matchers.equalTo("024-648-3804"))
                .body("website", Matchers.equalTo("ambrose.net"))
                .body("company.name", Matchers.equalTo("Hoeger LLC"))
                .body("company.catchPhrase", Matchers.equalTo("Centralized empowering task-force"))
                .body("company.bs", Matchers.equalTo("target end-to-end models"));;

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
                .statusCode(201)
                .body("id", Matchers.equalTo(11))
                .body("name", Matchers.equalTo("Fabiano dias"))
                .body("username", Matchers.equalTo("Andrade"))
                .body("email", Matchers.equalTo("fda@gmail.com"))
                .body("address.street", Matchers.equalTo("barueri sp"))
                .body("address.suite", Matchers.equalTo("Apt. 123"))
                .body("address.city", Matchers.equalTo("barueri"))
                .body("address.zipcode", Matchers.equalTo("92998-3874"))
                .body("address.geo.lat", Matchers.equalTo("-37.3159"))
                .body("address.geo.lng", Matchers.equalTo("81.1496"))
                .body("phone", Matchers.equalTo("1-770-736-8031 x56442"))
                .body("website", Matchers.equalTo("hildegard.org"))
                .body("company.name", Matchers.equalTo("Romaguera-Crona"))
                .body("company.catchPhrase", Matchers.equalTo("Multi-layered client-server"))
                .body("company.bs", Matchers.equalTo("real-time e-markets"));

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
                .statusCode(200)
                .body(equalTo("{}"));

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
                .statusCode(200)
                .body("name", equalTo("teste de alteracao"))
                .body("email", equalTo("123mudar@gmail.com"))
                .body("username", equalTo("put test"))
                .body("id", equalTo(5));

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }
}
