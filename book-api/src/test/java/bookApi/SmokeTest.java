package bookApi;

import bookApi.rest.BookController;
import bookApi.rest.PublicController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


//the SmokeTest class is used for testing the application context loading process and ensuring that
// the BookController bean is successfully created and injected into the test class.


//smokeTest is like confidence test or verification tests and shows instantiate of our class is works properly
//build test and this test  for ready application to another tests like functional /regression/sanity tests

//unit test: focus on testing individual units of code in isolation
@SpringBootTest
class SmokeTest {

    @Autowired
    private BookController bookController;
    @Autowired
    private PublicController publicController;


    @Test
    void contextLoads() throws Exception {
        assertThat(bookController).isNotNull();
        assertThat(publicController).isNotNull();
    }










}