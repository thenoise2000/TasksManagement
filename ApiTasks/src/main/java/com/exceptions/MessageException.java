package com.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageException extends CustomException {

	private static final long serialVersionUID = -4614302419130048495L;

	public MessageException() {
	    this("");
	}

	public MessageException(final String msg) {
	    this(msg, null);
	}

	public MessageException(final String msg, final Throwable throwable) {
	    super(msg, throwable);
	}
}
