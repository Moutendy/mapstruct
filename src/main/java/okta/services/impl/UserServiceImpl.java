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
import okta.utils.Constante;

@Service
public class UserServiceImpl implements UserServices{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMapper userMapper;

	
	@Override
	public UserDto getUser(String  tel) {
		// TODO Auto-generated method stub
		UserDto userDto = userMapper.toDto(userRepository.findByTel(tel));
		   if (userDto != null) {
		          return userDto;
		  } else {
			   throw new CustomerAlreadyExistsException(
					   Constante.SEARCH_ERROR);
		  }
	}

	@Override
	public String addUser(UserDto user) {
		// TODO Auto-generated method stub	
		UserModel existingCustomer
        = userRepository.findById(user.getId())
              .orElse(null);
		 if (existingCustomer == null) {
			 userRepository.save(userMapper.userDtotoUser(user));
	            return Constante.SAVE_MESSAGE;
	        }
	        else
	            throw new CustomerAlreadyExistsException(
	                Constante.ERROR_SAVE_MESSAGE);
	}

	@Override
	public String updateUser(UserDto user) {
		// TODO Auto-generated method stub
		UserModel existingCustomer = userRepository
				.findById(user.getId())
                .orElse(null);
    if (existingCustomer == null)
        throw new NoSuchCustomerExistsException(
        		Constante.ERROR_UPDATE_MESSAGE);
    else {
        existingCustomer.setTel(user.getTel());        
        userRepository.save(existingCustomer);
        return Constante.UPDATE_MESSAGE;
    }
	}

}
