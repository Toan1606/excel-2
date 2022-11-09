package com.eric.excel.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError implements Serializable {

    private List<ErrorDTO> errorDTOList;

    private Timestamp createdOnTimestamp = Timestamp.valueOf(LocalDateTime.now());;

    public ApiError(Builder builder) {
        this.errorDTOList = builder.errorDTOList;
    }

    public static class Builder {

        private List<ErrorDTO> errorDTOList;

        public Builder errorDTOList(List<ErrorDTO> errorDTOList) {
            this.errorDTOList = errorDTOList;
            return this;
        }

        public ApiError build() {
            ApiError apiError = new ApiError(this);
            return apiError;
        }
    }
}
