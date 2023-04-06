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
	

	
	List<UserDto> listtoDto(List<UserModel> user);
	
	
	List<UserModel> listUserto(List<UserDto> user);
	

	

	
}
