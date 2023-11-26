package com.dashdash.backend.application.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ListApiResultResponse<T> extends ApiResultResponse {

    private List<T> list;

}
