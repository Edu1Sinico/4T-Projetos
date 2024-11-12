package main.java.com.example.todo_list_project.model;

import java.time.LocalDateTime;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarefa;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, length = 50)
    private String status = "Aberto"; // Valor padrão

    @Column(nullable = false, length = 20)
    private String prioridade;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

}
