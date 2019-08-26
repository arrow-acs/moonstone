package com.arrow.apollo;

import moonstone.acs.AcsLogicalException;

public class LastSystemDefaultBoardException extends AcsLogicalException {
	private static final long serialVersionUID = 9007660188887473495L;

	public LastSystemDefaultBoardException() {
		super("Last system default board!");
	}
}
