package com.insutil.ch.common.handler;

import com.insutil.ch.common.response.OperationResponse;
import com.insutil.ch.common.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandling.class);

    @ExceptionHandler(value = IllegalArgumentException.class)
    protected ResponseEntity<OperationResponse> failToWorkException(IllegalArgumentException e) {
        logger.error(LogUtil.getThrowableMessage(e));
        OperationResponse response = new OperationResponse(OperationResponse.ResponseStatusEnum.ERROR, e.getMessage());
        response.setOperationMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
