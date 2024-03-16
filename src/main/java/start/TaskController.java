package start;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>("Created task with id: " + createdTask.getId() + ". Response status: " + status, status);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") int id) {
        return taskService.getTask(id);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable("id") int id, @RequestBody Task updatedTask) {
        taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
    }
}