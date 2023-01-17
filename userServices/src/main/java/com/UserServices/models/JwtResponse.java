package com.UserServices.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private UserInfo user;
    private boolean authorUser;
    

    public boolean isAuthorUser() {
		return authorUser;
	}

	public void setAuthorUser(boolean authorUser) {
		this.authorUser = authorUser;
	}

	public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
    
}
