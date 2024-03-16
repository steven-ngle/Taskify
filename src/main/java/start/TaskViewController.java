package start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class TaskViewController {

    private final TaskService taskService;

    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getAllTasks(Model model) {
        List<Task> allTasks = taskService.getAllTasks();
        System.out.println("Getting all tasks: " + allTasks);
        model.addAttribute("tasks", allTasks);
        return "index";
    }
}