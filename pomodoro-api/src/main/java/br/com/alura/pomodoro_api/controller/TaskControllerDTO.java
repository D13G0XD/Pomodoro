package br.com.alura.pomodoro_api.controller;

import br.com.alura.pomodoro_api.dto.TaskRequestDTO;
import br.com.alura.pomodoro_api.dto.TaskResponseDTO;
import br.com.alura.pomodoro_api.model.Task;
import br.com.alura.pomodoro_api.repository.TaskRepository;
import jakarta.validation.Valid;
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
public class TaskControllerDTO {

    private final TaskRepository taskRepository;


    public TaskControllerDTO(TaskRepository taskRepository) {

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

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id)  { // @PathVariable lê o valor que passa no placeholder como parâmetro
        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // Indica a criação de um endpoint post
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO dto) {
        Task saved = taskRepository.save(toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(saved));

    }

    @PutMapping("/{id}") // Indica a criação de um enpoint put
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id, @Valid @ RequestBody TaskRequestDTO dto) {
        return taskRepository.findById(id)
                .map(existing -> {
                    Task updated = toEntity(dto);
                    existing.setTitle(updated.getTitle());
                    existing.setCompleted(updated.getCompleted());
                    return ResponseEntity.ok(toDTO(taskRepository.save(existing)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }


    private TaskResponseDTO toDTO(Task task) {

        return new TaskResponseDTO(task.getId(), task.getTitle(), task.getCompleted());

    }

    public void Task() {

    }

    private Task toEntity(TaskRequestDTO dto) {

        Task task = new Task();
        task.setTitle(dto.title());
        task.setCompleted(dto.completed() != null ? dto.completed() : false);
        return task;

    }


}
