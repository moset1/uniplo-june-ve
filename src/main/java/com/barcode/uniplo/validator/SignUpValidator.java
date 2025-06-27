package com.barcode.uniplo.validator;

import com.barcode.uniplo.domain.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignUpValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserDto dto = (UserDto) target;

        ValidationUtils.rejectIfEmpty(errors,"user_email", "required");
        ValidationUtils.rejectIfEmpty(errors, "user_password", "required");


        String pwd = dto.getUser_password();

        if(pwd.length() <8 || pwd.length() >20) {
            errors.rejectValue("user_password", "invalidLength.user_password", new String[] {"8", "20"}, "invalid length");
        }


    }
}
