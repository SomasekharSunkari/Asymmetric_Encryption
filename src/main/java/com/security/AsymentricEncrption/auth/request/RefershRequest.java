package com.security.AsymentricEncrption.auth.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefershRequest {
    private String refreshToken;


}
