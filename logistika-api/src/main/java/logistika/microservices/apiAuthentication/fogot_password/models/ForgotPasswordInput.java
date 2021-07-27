package logistika.microservices.apiAuthentication.fogot_password.models;

public class ForgotPasswordInput {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ForgotPasswordInput() {
    }

    private String   username;
}
