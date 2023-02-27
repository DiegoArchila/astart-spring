package com.app.astart.domain.dto;

public class AutenticationResponse {

    private String jwt;

    public AutenticationResponse(String jwt){
        this.jwt=jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
