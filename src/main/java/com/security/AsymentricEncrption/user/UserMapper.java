package com.security.AsymentricEncrption.user;

import com.security.AsymentricEncrption.auth.request.RegistrationRequest;
import com.security.AsymentricEncrption.requests.ProfileupdateRequest;
import org.apache.commons.lang3.StringUtils;

public class UserMapper {
    public void mergeUserInfo(User user
            , ProfileupdateRequest request) {
        if(StringUtils.isNotBlank(request.getFirstName()) &&
        !user.getFirstName().equals(request.getFirstName())){
            user.setFirstName(request.getFirstName());
        }
        if(StringUtils.isNotBlank(request.getLastName()) &&
                !user.getLastName().equals(request.getLastName())){
            user.setLastName(request.getLastName());
        }
        if(request.getDateOdBirth() != null && !request.getDateOdBirth().equals(
                user.getDateOfBirth())){
            user.setDateOfBirth(request.getDateOdBirth());
        }
    }

    public User toUser(RegistrationRequest request) {

        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .enabled(true)
                .locked(false)
                .credentialsExpired(false)
                .emailVerified(false)
                .phoneVerified(false)
                .build();

    }
}
