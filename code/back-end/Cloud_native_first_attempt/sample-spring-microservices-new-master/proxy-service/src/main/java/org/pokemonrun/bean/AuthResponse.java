package org.pokemonrun.bean;

public class AuthResponse {//give accesstoken
    private String accessToken ;

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
