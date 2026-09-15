package br.com.alura.pomodoro_api.controller;

import br.com.alura.pomodoro_api.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks") // Define que qualquer endpoint criado começará com o path informado
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong(1); // permite realizar operações thread-safe


    public TaskController() {

        tasks.add(new Task(nextId.getAndIncrement(), "Estudar Spring Boot", false));
        tasks.add(new Task(nextId.getAndIncrement(), "Fazer exercícios de revisão", false));
        tasks.add(new Task(nextId.getAndIncrement(), "Assistir aula de testes", true));
        // funciona como uma forma dinâmica para criar valores para um id, por exemplo
    }


    @GetMapping // Irá mapear os endpoints conforme a condição passada
    public ResponseEntity<List<Task>> findAll(@RequestParam(required = false) Boolean completed){
        // RequestParam aceita valores booleanos

        if (completed != null) {

            return ResponseEntity.ok(tasks);

        }
        return ResponseEntity.ok(tasks.stream()
                .filter(task -> task.getCompleted().equals(completed))
                .collect(Collectors.toList())

        );
    }

    @PostMapping // Indica a criação de um endpoint post
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setId(nextId.getAndIncrement()); // cria uma task com id dinâmico
        tasks.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task); // Retorna um 201 (criação de um objeto)

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id)  { // @PathVariable lê o valor que passa no placeholder como parâmetro
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)// percorre pela classe procurando um status ok caso contrário
                .orElse(ResponseEntity.notFound().build()); // Os métodos passados com a classe retornam o 404
    }


}
