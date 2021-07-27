package logistika.microservices.apiAuthentication.reset_password.models;

public class ResetPasswordInput {
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public ResetPasswordInput( ) { }

    public ResetPasswordInput(String newPassword, String confirmPassword) {
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    private  String newPassword ;
    private  String confirmPassword;
}
