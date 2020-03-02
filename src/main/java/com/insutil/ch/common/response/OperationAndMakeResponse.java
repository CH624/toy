package com.insutil.ch.common.response;

public interface OperationAndMakeResponse {
    static String defaultSuccessMsg() {
        return "Success to work your job";
    }

    static String defaultFailMsg() {
        return "Fail to work your job";
    }

    default public OperationResponse operationAndMakeResponse(boolean result) {
        OperationResponse response = new OperationResponse();
        if(result) {
            response.setOperationStatus(OperationResponse.ResponseStatusEnum.SUCCESS);
            response.setOperationMessage(defaultSuccessMsg());
        } else {
            response.setOperationStatus(OperationResponse.ResponseStatusEnum.ERROR);
            response.setOperationMessage(defaultFailMsg());
        }
        return response;
    }

    default public OperationResponse operationAndMakeResponse(boolean result, final String resultMsg) {
        OperationResponse response = this.operationAndMakeResponse(result);
        response.setOperationMessage(resultMsg);
        return response;
    }

    default public OperationResponse operationAndMakeResponse(OperationResponse.ResponseStatusEnum statusEnum, final String resultMsg) {
        OperationResponse response = new OperationResponse();
        response.setOperationStatus(statusEnum);
        response.setOperationMessage(resultMsg);
        return response;
    }
}
