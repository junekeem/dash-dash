package com.dashdash.backend.application.model.response;

import lombok.Getter;

@Getter
public class SingleApiResultResponse<T> extends ApiResultResponse {

    private T data;

    public SingleApiResultResponse(T data) {
        super();
        this.data = data;
    }

    public SingleApiResultResponse(String message) {
        super(message);
        this.data = null;
    }
}
