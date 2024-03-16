package start;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task createTask(Task task) {
        tasks.add(task);
        System.out.println("Created task: " + task.getName());
        return task;
    }

    public Task getTask(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateTask(int id, Task updatedTask) {
        tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .ifPresent(task -> {
                    task.setName(updatedTask.getName());
                    task.setCompleted(updatedTask.isCompleted());
                });
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
