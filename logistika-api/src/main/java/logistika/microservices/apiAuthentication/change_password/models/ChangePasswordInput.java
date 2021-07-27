package logistika.microservices.apiAuthentication.change_password.models;

public class ChangePasswordInput
{
    public ChangePasswordInput() {
    }

    public ChangePasswordInput(String username, String password, String newPassword, String comfirnPassword) {
        this.username = username;
        this.password = password;
        this.newPassword = newPassword;
        this.confirmPassword = comfirnPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirnPassword) {
        this.confirmPassword = confirmPassword;
    }

    private String username, password,  newPassword, confirmPassword;

}
