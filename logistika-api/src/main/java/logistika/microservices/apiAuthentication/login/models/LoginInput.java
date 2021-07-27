package logistika.microservices.apiAuthentication.login.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginInput {
    private String username;
    private String password;

}
