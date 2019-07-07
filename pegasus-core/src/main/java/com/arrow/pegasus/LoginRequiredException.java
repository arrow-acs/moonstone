package com.arrow.pegasus;

import com.arrow.acs.AcsLogicalException;

public class LoginRequiredException extends AcsLogicalException {
    private static final long serialVersionUID = 8444679053010167231L;

    public LoginRequiredException() {
        super("Login required!");
    }
}
