package com.security.AsymentricEncrption.requests;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileupdateRequest {
    private String firstName;
    private String lastName;
    private LocalDate dateOdBirth;



}
