package com.security.AsymentricEncrption.impl;


import com.security.AsymentricEncrption.enums.ErrorCode;
import com.security.AsymentricEncrption.exceptions.BussinessException;
import com.security.AsymentricEncrption.requests.ChangePasswordRequest;
import com.security.AsymentricEncrption.requests.ProfileupdateRequest;
import com.security.AsymentricEncrption.user.User;
import com.security.AsymentricEncrption.user.UserMapper;
import com.security.AsymentricEncrption.user.UserRepository;
import com.security.AsymentricEncrption.user.UserService;
import io.jsonwebtoken.security.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public void updateProfileInfo(ProfileupdateRequest profileupdateRequest, String userId) {
        User savedUser = userRepository.findById(userId).orElseThrow(
                ()-> new BussinessException(ErrorCode.USER_NOT_FOUND,userId)
        );

        this.userMapper.mergeUserInfo(savedUser,profileupdateRequest);
        this.userRepository.save(savedUser);
    }

    @Override
    public void changePassword(ChangePasswordRequest request, String userId) {
    if(!request.getNewPassword().equals(request.getConfirmPassword())){
        throw  new BussinessException(ErrorCode.CHANGE_PASSWORD_MISMATCH);
    }
    final User savedUser = this.userRepository.findById(userId).orElseThrow(
            () -> new BussinessException(ErrorCode.USER_NOT_FOUND)
    );
    if(!this.passwordEncoder.matches(request.getCurrentPassword(),savedUser.getPassword()))
        throw  new BussinessException(ErrorCode.INVALID_CURRENT_PASSWORD);

    final String encoded =this
            .passwordEncoder.encode(request.getNewPassword());
    savedUser.setPassword(encoded);
    this
            .userRepository.save(savedUser);
    }

    @Override
    public void deactivateAccount(String userId) {

        final User user = this.userRepository.findById(userId).orElseThrow(()->
                new BussinessException(ErrorCode.USER_NOT_FOUND));
 if(!user.isEnabled()){
     throw  new BussinessException(ErrorCode.ACCOUNT_ALREADY_DISABLED);
 }
        user.setEnabled(false);
 this.userRepository.save(user);

    }

    @Override
    public void reactivateAccount(String userId) {
        final User user = this.userRepository.findById(userId).orElseThrow(()->
                new BussinessException(ErrorCode.USER_NOT_FOUND));
        if(user.isEnabled()){
            throw  new BussinessException(ErrorCode.ACCOUNT_ALREADY_DISABLED);
        }
        user.setEnabled(false);
        this.userRepository.save(user);


    }

    @Override
    public void deleteAccount(final String userId) {

    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return this.userRepository.findByEmailIgnoreCase(userEmail).orElseThrow(
                ()->new UsernameNotFoundException("User not found with userEmail : " + userEmail)
        );
    }
}
