package bookApi.mapper;

import bookApi.model.Book;
import bookApi.rest.dto.BookDto;
import bookApi.rest.dto.CreateBookRequest;

public interface BookMapper {

    Book toBook(CreateBookRequest createBookRequest);

    BookDto toBookDto(Book book);
}