package com.exceptions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NotFoundExceptions extends RuntimeException {
       
    private static final long serialVersionUID = 955519838855671577L;
    private final String id;
    private final String types;

    public NotFoundExceptions(String types, String id, String msg) {
        super(msg);
        this.types = types;
        this.id = id;
    }

    public NotFoundExceptions(String types, String id) {
        this(types, id, null);
    }
}
