package main.java.com.example.todo_list_project.controller;

import main.java.com.example.todo_list_project.model.Usuario;
import main.java.com.example.todo_list_project.repository.UsuarioRepository;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository ur;

    @PostMapping("/cadastrar-usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return ur.save(usuario);
    }


}
