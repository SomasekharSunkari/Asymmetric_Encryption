package com.security.AsymentricEncrption.exceptions;


import com.security.AsymentricEncrption.enums.ErrorCode;
import lombok.Getter;

@Getter
public class BussinessException extends RuntimeException {
    private  final ErrorCode errorCode;
    private final Object[] args;
    public BussinessException(final  ErrorCode errorCode,final Object... args) {
        super(getFomatterMessage(errorCode,args));
        this.errorCode = errorCode;
        this.args = args;
    }

    private static String getFomatterMessage(final  ErrorCode errorCode,final Object[] args){
        if(args !=null && args.length >0){
            return  String.format(errorCode.getDefaultMessage(),args);
        }

        return  null;
    }
}
