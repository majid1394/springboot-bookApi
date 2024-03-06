package bookApi;

import bookApi.service.BookService;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Enabled;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
@SpringBootTest  //@SpringBootTest` annotation is used to load the Spring application context for testing
/*
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")*/

//configration test that shows every config in our app works properly
class BookApiApplicationTests {

    @Test
    void contextLoads() {


    }
}
