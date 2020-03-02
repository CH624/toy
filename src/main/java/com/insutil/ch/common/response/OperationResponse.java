package com.insutil.ch.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperationResponse {
    public enum ResponseStatusEnum {SUCCESS, NO_DATA, INSPECTION_ERROR, ERROR, WARNING, NO_ACCESS};
    private ResponseStatusEnum  operationStatus;
    private String  operationMessage;
}
