package okta.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okta.dto.UserDto;
import okta.exception.CustomerAlreadyExistsException;
import okta.exception.NoSuchCustomerExistsException;
import okta.mapper.UserMapper;
import okta.models.UserModel;
import okta.repositories.UserRepository;
import okta.services.UserServices;

@Service
public class UserServiceImpl implements UserServices{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDto getUser(String  tel) {
		// TODO Auto-generated method stub
	return userMapper.toDto(userRepository.findByTel(tel));
		
	}

	@Override
	public String addUser(UserDto user) {
		// TODO Auto-generated method stub
		
		UserModel existingCustomer
        = userRepository.findById(user.getId())
              .orElse(null);
		
		 if (existingCustomer == null) {
			 userRepository.save(userMapper.userDtotoUser(user));
	            return "Customer added successfully";
	        }
	        else
	            throw new CustomerAlreadyExistsException(
	                "Customer already exists!!");
	}

	@Override
	public String updateUser(UserDto user) {
		// TODO Auto-generated method stub
		UserModel existingCustomer = userRepository
				.findById(user.getId())
                .orElse(null);
    if (existingCustomer == null)
        throw new NoSuchCustomerExistsException(
            "No Such Customer exists!!");
    else {
        existingCustomer.setTel(user.getTel());        
        userRepository.save(existingCustomer);
        return "Record updated Successfully";
    }
	}

}
