package bookApi.mapper;

import bookApi.model.User;
import bookApi.rest.dto.UserDto;

public interface UserMapper {

    UserDto toUserDto(User user);
}