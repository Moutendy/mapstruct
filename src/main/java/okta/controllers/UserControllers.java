package okta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okta.dto.UserDto;
import okta.services.UserServices;

@RestController
@RequestMapping("apis/user/")
public class UserControllers {

	@Autowired
	UserServices userService;
	
	

    @PostMapping(value = "/adduser",produces = "application/json")
    public String getNatureByCommunity(@RequestBody UserDto user){
        return userService.addUser(user);
    }
    
    @GetMapping(value = "/findalluser/{tel}")
    public UserDto getUserBatel(@PathVariable("tel") String tel){
        return userService.getUser(tel);
    }
    
    @PutMapping(value = "/updateuser")
    public String updateUserBatel(@RequestBody UserDto user){
        return userService.updateUser(user);
    }
}
