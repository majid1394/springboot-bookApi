package bookApi;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.http.HttpResponse;

import static org.junit.Assert.assertEquals;

/*@RunWith(SpringRunner.class)*/
@SpringBootTest(classes = BookApiApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
public class ExcludeAutoConfig3IntegrationTest {

    /**
     * Encapsulates the random port the test server is listening on.
     */
    @LocalServerPort
    private int port;

//you need to up your app before to run this test
    @Test
    //status code==200 is  network test
    public void givenSecurityConfigExcluded_whenAccessHome_thenNoAuthenticationRequired() {

      //  RestAssured.basic("admin","admin");
        /*int statusCode = RestAssured.get("http://localhost:" + port+"/api/books").statusCode();*/
        //int statusCode = RestAssured.given().auth().basic("admin","admin").get("http://localhost:" + port+"/api/books").statusCode();
        port=8080;
        int statusCode = RestAssured.given().auth().basic("admin","admin").get("http://localhost:" + port+"/api/books").statusCode();
        assertEquals(HttpStatus.OK.value(), statusCode);

    }
}
