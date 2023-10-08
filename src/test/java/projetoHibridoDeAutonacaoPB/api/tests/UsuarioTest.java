package projetoHibridoDeAutonacaoPB.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import projetoHibridoDeAutonacaoPB.api.data.Usuario;

import org.junit.Test;

import static io.restassured.RestAssured.*;


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
    public void deveCadastrarUmNovoUsuario() {

        Response response = RestAssured
                .given()
                .header("content-type", "application/json; charset=utf-8")
                .body(usuario.getString())
                .when()
                .post(baseURI);


        response.then()
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
