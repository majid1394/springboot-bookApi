package bookApi;

import bookApi.rest.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


//the SmokeTest class is used for testing the application context loading process and ensuring that
// the BookController bean is successfully created and injected into the test class.

@SpringBootTest
class SmokeTest {

    @Autowired
    private BookController bookController;

    @Test
    void contextLoads() throws Exception {
        assertThat(bookController).isNotNull();
    }



}