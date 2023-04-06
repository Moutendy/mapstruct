package okta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import okta.dto.UserDto;
import okta.mapper.UserMapper;
import okta.models.UserModel;
import okta.repositories.UserRepository;

@RestController
@RequestMapping("apis/user/")
public class UserControllers {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapper userMapper;

    @GetMapping(value = "/alluser",produces = "application/json")
    public List<UserDto> getNatureByCommunity(){
    	
        return userMapper.listtoDto(userRepository.findAll());
    }
    
    @GetMapping(value = "/findalluser/{tel}")
    public UserModel getUserBatel(@PathVariable("tel") String tel){
    
    
        return userRepository.findByTel(tel);
    }
}
