import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }
    public void addTask(Task task){
        tasks.add(task);
    }
    public List<Task> getTasks(){
        return tasks;
    }
    public Task getTaskByTitle(String title){
        Task task=tasks.stream().filter(task1 -> task1.getTitle().equals(title)).findFirst().orElse(null);
        return task;
    }
    public void updateTask(int index, String title, String description, String dueDate) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setTitle(title);
            task.setDescription(description);
            task.setDueDate(dueDate);
        } else {
            System.out.println("Invalid task index. Task not updated.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task deletedTask = tasks.remove(index);
            System.out.println("Task deleted: " + deletedTask.getTitle());
        } else {
            System.out.println("Invalid task index. Task not deleted.");
        }
    }

}
