package com.security.AsymentricEncrption.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND("USER_NOT_FOUND","User not found",HttpStatus.NOT_FOUND),
    CHANGE_PASSWORD_MISMATCH("New password and confirm Password Mismatch","New password and confirm Password Mismatch" , HttpStatus.BAD_REQUEST),
    INVALID_CURRENT_PASSWORD("INVALID PASSOWORD","INVALID PASSWORD" ,HttpStatus.BAD_REQUEST ),
    ACCOUNT_ALREADY_DISABLED("Account already disabled","Account Already Disabled" ,HttpStatus.BAD_REQUEST ),
    EMAIL_ALREADY_EXISTS("Email Aleady Exists","Email Already Exisits",HttpStatus.BAD_REQUEST),
    PHONE_ALREADY_EXISTS("PHONE_NUMBER_EXISTS","Phone Number Already Exists",HttpStatus.BAD_REQUEST),
    ERR_USER_DISABLED("ACCOUNT DISABLED","Account disabled",HttpStatus.BAD_REQUEST),
    BAD_CREDENTIALS("BAD CREDENTIALS","Bad Credentials",HttpStatus.BAD_REQUEST),
    INTERNAL_EXCEPTION("INTERNAL_EXCEPTION","Internal Excception",HttpStatus.INTERNAL_SERVER_ERROR);
    private final  String code;
    private  final  String defaultMessage;
    private final HttpStatus status;
    ErrorCode(final String code,final  String defaultMessage,final  HttpStatus status){
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.status =status;
    }
}
