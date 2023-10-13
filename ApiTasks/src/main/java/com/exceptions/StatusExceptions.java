package com.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusExceptions<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String status;
	private Set<ExceptionsError> error;

	public StatusExceptions(final String status, final Set<ExceptionsError> error) {
	    this.status = status;
	    this.error = error;
	}

	public StatusExceptions(final String status, final String msg) {
	    this.status = status;
	    this.error = Collections.singleton(new ExceptionsError(msg));
	}
}
