package api.inova.digital.resource;

import api.inova.digital.dto.UsuarioDTO;
import api.inova.digital.model.Usuario;
import api.inova.digital.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public  ResponseEntity<Object> login(@Valid @RequestBody Usuario usuario){
        Usuario login = usuarioRepository.findByEmailAndSenha(usuario.getEmail().trim(), usuario.getSenha().trim());

        if (login == null){
            return ResponseEntity.status(401).body( "Email ou Senha inválido!");
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId_usuario(login.getId_usuario());
        usuarioDTO.setNome(login.getNome());
        usuarioDTO.setEmail(login.getEmail());

        return ResponseEntity.status(200).body(usuarioDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody Usuario usuario){
        try {
            usuarioRepository.save(usuario);

            return ResponseEntity.status(201).body( "Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
