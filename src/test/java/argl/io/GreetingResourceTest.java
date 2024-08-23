package argl.io;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.flywaydb.core.Flyway;

@QuarkusTest
class GreetingResourceTest {

 @Inject
    Flyway flyway;

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/db_demo")
          .then()
             .statusCode(200)
             .body(is("Hello " + flyway.info().current().getVersion().toString()+ " " + flyway.info().current().getDescription()));
    }

}