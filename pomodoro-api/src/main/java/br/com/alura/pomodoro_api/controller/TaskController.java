package br.com.alura.pomodoro_api.controller;

import br.com.alura.pomodoro_api.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks") // Define que qualquer endpoint criado começará com o path informado
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    public TaskController() {

        tasks.add(new Task(1L, "Estudar Spring Boot", false));
        tasks.add(new Task(2L, "Fazer exercícios de revisão", false));
        tasks.add(new Task(3L, "Assistir aula de testes", true));

    }


    @GetMapping // Irá mapear os endpoints conforme a condição passada
    public List<Task> findAll(@RequestParam(required = false) Boolean completed){
        // RequestParam aceita valores booleanos

        if (completed != null) {

            return tasks.stream()
                    .filter(t -> t.getCompleted().equals(completed))
                    .toList();

        }
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id)  { // @PathVariable lê o valor que passa no placeholder como parâmetro
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
