package bank.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class SignUpRequest implements Serializable {

    private static final long serialVersionUID = 2499376845717117573L;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
}
