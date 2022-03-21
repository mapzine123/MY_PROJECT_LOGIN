package com.firstSpring.app.valid;

import com.firstSpring.app.dao.UserDao;
import com.firstSpring.app.dao.UserDaoImpl;
import com.firstSpring.app.domain.UserDto;
import com.firstSpring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
    }
}
