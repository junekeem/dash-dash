package com.dashdash.backend.application.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class BackendResult {

    private Boolean isError;
    private Optional<String> message;

    public BackendResult() {
        this(false, Optional.empty());
    }

    public BackendResult(final String message) {
        this(true, Optional.ofNullable(message));
    }
}
