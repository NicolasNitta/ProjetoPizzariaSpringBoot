package springteste.com.cursospring.model.Usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CredenciaisDTO {
    
    @NotBlank
    private String login;

    @NotBlank
    private String password;

}
