package main.requestPOJO;

import main.baseRequestPackage.APIRequest;

public class Login extends APIRequest {
    private String email;
    private String password;

    public Login(boolean readConfiguration) {
        super(readConfiguration);

    }
        public void setEmail(String email){
        this.email=email;
           }
    public void setPassword(String password){
        this.password=password;
           }


}
