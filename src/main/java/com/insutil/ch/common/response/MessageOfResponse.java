package com.insutil.ch.common.response;

public enum MessageOfResponse {
    GET_SUCCESS("Your order has been processed."),
    PUT_SUCCESS("You have successfully updated the info."),
    POST_SUCCESS("Your form has been succesfully submitted."),
    DELETE_SUCCESS("You have successfully deleted the info."),

    FAIL_DATA_NOT_FOUND("Data not found."),
    SYSTEM_ERROR("Unspecificnesss problem unexpected occured. contact system administrator for solving problem"),

    PARAMETER_FAILURE("Enter a valid parameters.");

    private String msg;

    MessageOfResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}