package logistika.microservices.apiAuthentication.refesh_token.models;

public class RefreshTokenInput {
    public RefreshTokenInput(String refreshToken ) {
        this.refreshToken = refreshToken;

    }

    public RefreshTokenInput() {
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    private String refreshToken;

}
