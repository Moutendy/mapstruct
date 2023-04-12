package okta.services;

import okta.dto.UserDto;

public interface UserServices {

	UserDto getUser(String tel);
	 
    // Method to add a new User
    // into the database
    String addUser(UserDto user);
 
    // Method to update details of a User
    String updateUser(UserDto user);
}
