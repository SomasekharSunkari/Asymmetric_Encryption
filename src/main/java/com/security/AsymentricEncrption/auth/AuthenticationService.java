package com.security.AsymentricEncrption.auth;

import com.security.AsymentricEncrption.auth.request.AuthenticationRequest;
import com.security.AsymentricEncrption.auth.request.RefershRequest;
import com.security.AsymentricEncrption.auth.request.RegistrationRequest;
import com.security.AsymentricEncrption.auth.response.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);

    void register(RegistrationRequest request);

    AuthenticationResponse refreshToken(RefershRequest request);
}
