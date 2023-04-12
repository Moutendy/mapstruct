package okta.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import okta.models.RoleModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	   private Long id;
	    
	   private String tel;
	   
	   RoleDto role;


}
