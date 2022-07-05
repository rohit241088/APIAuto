package main.responsePOJO;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Login {
    @JsonProperty("token")
    private String token;

    @JsonGetter("token")
    public String getToken() {
        return token;
    }
@JsonSetter("token")
    public void setToken(String token) {
        this.token = token;
    }
}
