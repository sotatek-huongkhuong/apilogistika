package logistika.microservices.apiAuthentication.change_email.models;

public class ChangeEmailInput {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public ChangeEmailInput() {
    }

    public ChangeEmailInput(String username, String newEmail) {
        this.username = username;
        this.newEmail = newEmail;
    }

    private String username, newEmail;
}
