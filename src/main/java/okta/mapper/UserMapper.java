package okta.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import okta.dto.UserDto;
import okta.models.UserModel;

@Mapper(componentModel = "spring",uses = {RoleMapper.class})
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	 @Mapping(target="id", source="user.id")
	 @Mapping(target="tel", source="user.tel")
	 UserDto toDto(UserModel user);
	

	 @Mapping(target="id", source="userDto.id")
	 @Mapping(target="tel", source="userDto.tel")
	 UserModel userDtotoUser(UserDto userDto);
	
	List<UserDto> listtoDto(List<UserModel> user);
	
	
	List<UserModel> listUserto(List<UserDto> user);
	

	

	
}
