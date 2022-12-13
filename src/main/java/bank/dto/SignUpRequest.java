package bank.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public final class SignUpRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
}
