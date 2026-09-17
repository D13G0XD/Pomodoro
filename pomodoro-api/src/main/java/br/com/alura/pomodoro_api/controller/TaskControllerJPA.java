package br.com.alura.pomodoro_api.controller;

import br.com.alura.pomodoro_api.model.Task;
import br.com.alura.pomodoro_api.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks") // Define que qualquer endpoint criado começará com o path informado
public class TaskControllerJPA {

    private final TaskRepository taskRepository;


    public TaskControllerJPA(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }


    @GetMapping // Irá mapear os endpoints conforme a condição passada
    public ResponseEntity<List<Task>> getTasks(@RequestParam(required = false) Boolean completed){
        // RequestParam aceita valores booleanos

        if (completed != null) {

            return ResponseEntity.ok(taskRepository.findAll());

        }
        return ResponseEntity.ok(taskRepository.findByCompleted(completed));

    }

    @PostMapping // Indica a criação de um endpoint post
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task saved = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }

    @PutMapping("/{id}") // Indica a criação de um enpoint put
    public ResponseEntity<Task> updateTask (@PathVariable Long id, @RequestBody Task task) {
        return taskRepository.findById(id).map(existing ->{
            existing.setTitle(task.getTitle());
            existing.setCompleted(task.getCompleted());
            return ResponseEntity.ok(taskRepository.save(existing));
        }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id)  { // @PathVariable lê o valor que passa no placeholder como parâmetro
        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
