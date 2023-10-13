package com.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionsError implements Serializable {
       
    private static final long serialVersionUID = 1L;
    private String msg;

    public ExceptionsError(final ExceptionsError exceptionsError) {
        this.msg = exceptionsError.getMsg();
    }
}
