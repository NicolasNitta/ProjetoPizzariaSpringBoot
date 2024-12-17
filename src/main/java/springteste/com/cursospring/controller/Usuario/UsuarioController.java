package springteste.com.cursospring.controller.Usuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import springteste.com.cursospring.model.Usuario.UsuarioDTO;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService userService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastroUsuario(@RequestBody @Valid UsuarioDTO dto,
            UriComponentsBuilder builder) {
        UsuarioDTO userDTO = userService.criarUsuario(dto);
        URI endereco = builder.path("/usuario/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(endereco).body(userDTO);
    }

}
