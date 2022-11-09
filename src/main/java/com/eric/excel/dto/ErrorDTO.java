package com.eric.excel.dto;

import lombok.Data;

@Data
public class ErrorDTO {

    private String errorCode;

    private String errorMessage;

    public ErrorDTO() {
    }

    public ErrorDTO(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorDTO(Builder builder) {
        this.errorCode = builder.errorCode;
        this.errorMessage = builder.errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static class Builder {
        private String errorCode;

        private String errorMessage;

        public Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder errorMessage(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorDTO build() {
            ErrorDTO errorDTO = new ErrorDTO(this);
            return errorDTO;
        }
    }
}
