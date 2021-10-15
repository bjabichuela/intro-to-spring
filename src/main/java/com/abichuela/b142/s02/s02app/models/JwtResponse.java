package com.abichuela.b142.s02.s02app.models;

public class JwtResponse {
    //JwtResponse create model for token response
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}