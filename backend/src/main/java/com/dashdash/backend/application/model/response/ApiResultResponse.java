package com.dashdash.backend.application.model.response;

import lombok.Getter;

@Getter
public class ApiResultResponse {
    
    private BackendResult backendResult;

    public ApiResultResponse() {
        this.backendResult = new BackendResult();
    }

    public ApiResultResponse(String message) {
        this.backendResult = new BackendResult(message);
    }
}
