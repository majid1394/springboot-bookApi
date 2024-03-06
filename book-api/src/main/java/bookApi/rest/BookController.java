package bookApi.rest;

import bookApi.mapper.BookMapper;
import bookApi.model.Book;
import bookApi.rest.dto.BookDto;
import bookApi.service.BookService;
import bookApi.rest.dto.CreateBookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static bookApi.Configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

/*import static com.ivanfranchin.bookapi.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;*/

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {


    //logger using  slf4j framework ,
    //if you using logback-spring.xml configuration file, slf4j undrestand automatically you want to use logback framework
    // if you want to use log4j or log4j2 you must change logback=-spring.xml to log4j or log4j2 file
    Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<BookDto> getBooks(@RequestParam(value = "text", required = false) String text) {
        //log4j older log4j2 newer and new version of log4j with async capability and yaml/json config too
        //slf4j is fecade and it is not depend of logging framework , it just using facade and api to connect any loggin framework
        //logback : logback and log4j has a same developer, logback its easier to config and its successor of log4j

        /*logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        */

        /*for logger we can also use in in maven:
        mvn spring-boot:run
                -Dspring-boot.run.arguments=--logging.level.org.springframework=TRACE,--logging.level.com.baeldung=TRACE*/




        List<Book> books = (text == null) ? bookService.getBooks() : bookService.getBooksContainingText(text);
        if (books!=null && books.size()!=0) {
            logger.info("books fetched successfully");
            return books.stream()
                    .map(bookMapper::toBookDto)
                    .collect(Collectors.toList());
        }
        else {
            logger.error("we are not books in our database or we got some errors ");
          return null;
        }
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BookDto createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        Book book = bookMapper.toBook(createBookRequest);
        return bookMapper.toBookDto(bookService.saveBook(book));
    }


    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{isbn}")
    public BookDto deleteBook(@PathVariable String isbn) {
        Book book = bookService.validateAndGetBook(isbn);
        bookService.deleteBook(book);
        return bookMapper.toBookDto(book);
    }
}
