package com.example.blogapigateway;

import lombok.Data;

import java.util.Date;
@Data
public class ExceptionResponseModel {
    private String errCode;
    private String err;
    private String errDetails;
    private Object o;

    public ExceptionResponseModel(String errCode, String err, String errDetails, Object o, Date date) {
        this.errCode = errCode;
        this.err = err;
        this.errDetails = errDetails;
        this.o = o;
        this.date = date;
    }

    private Date date;

}
