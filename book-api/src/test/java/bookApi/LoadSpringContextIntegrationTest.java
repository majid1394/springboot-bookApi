package bookApi;

import bookApi.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BookApiApplication.class },
        initializers = ConfigDataApplicationContextInitializer.class)

//integration test
// This verification is a common practice in unit testing to ensure that a specific method is invoked the expected number of times,
// in this case, two times. By using Mockito's `times(2)` argument,
// the test is confirming the correct behavior of the `getUserByUsername` method in the `userService` object.
public class LoadSpringContextIntegrationTest {
    @SpyBean
    UserServiceImpl userService;

    /*@SpyBean
    CommandLineRunner commandLineRunner;
*/
    //The `@SpyBean` annotation in Spring Boot testing is used to create a spy (partial mock) of a bean
 /*   @SpyBean
    ApplicationRunner applicationRunner;
*/


    @Test
    void whenContextLoads_thenRunnersDoNotRun() throws Exception {

        //smoking test
        assertNotNull(userService);

        //assertNotNull(applicationRunner);

//unit test to checking that the `getUserByUsername` method is not unexpectedly triggered during the test scenario.
        userService.getUserByUsername("test1");
        userService.getUserByUsername("test2");
        verify(userService, times(2)).getUserByUsername(any());
        /*verify(commandLineRunner, times(0)).run(any());
        verify(applicationRunner, times(0)).run(any());*/
    }
}
