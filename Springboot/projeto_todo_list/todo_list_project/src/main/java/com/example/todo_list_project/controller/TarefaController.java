package main.java.com.example.todo_list_project.controller;

import main.java.com.example.todo_list_project.model.Tarefa;
import main.java.com.example.todo_list_project.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tr;

    @PostMapping("/cadastrar-tarefa")
    public Tarefa cadastrarTarefa(@RequestBody Tarefa tarefa) {
        return tr.save(tarefa);
    }

    @GetMapping("/listar")
    public List<Tarefa> listarTarefas() {
        return tr.findAll();
    }
}
