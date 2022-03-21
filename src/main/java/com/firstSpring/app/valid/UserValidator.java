package com.firstSpring.app.valid;

import com.firstSpring.app.domain.UserDto;
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
        UserDto userDto = (UserDto)o;
        String email = userDto.getEmail();
        String name = userDto.getName();
        String pwd = userDto.getPwd();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");

        if(email.length() < 3) {
            errors.rejectValue("email", "TooShorts");
        }
    }
}
