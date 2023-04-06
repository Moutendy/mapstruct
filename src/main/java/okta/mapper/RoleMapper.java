package okta.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import okta.dto.RoleDto;
import okta.models.RoleModel;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	 @Mapping(target="id", source="role.id")
	 @Mapping(target="name", source="role.name")
	 RoleDto toDto(RoleModel role);
	

	
	List<RoleDto> listtoRole(List<RoleModel> user);
	
	
	List<RoleModel> listRoleto(List<RoleDto> user);
}
