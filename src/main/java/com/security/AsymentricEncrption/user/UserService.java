package com.security.AsymentricEncrption.user;

import com.security.AsymentricEncrption.requests.ChangePasswordRequest;
import com.security.AsymentricEncrption.requests.ProfileupdateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    void updateProfileInfo(ProfileupdateRequest profileupdateRequest,String userId);

    void changePassword(ChangePasswordRequest changePasswordRequest,String userId);

    void deactivateAccount(String userId);

    void reactivateAccount(String userId);

    void deleteAccount(String userId);
}
