import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("To-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Get Task By Title");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. View Tasks");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Due Date: ");
                    String dueDate = scanner.nextLine();

                    Task task = new Task(title, description, dueDate);
                    taskManager.addTask(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.print("Title: ");
                    String titleToView = scanner.nextLine();
                    System.out.println(taskManager.getTaskByTitle(titleToView));
                    break;
                case 3:
                    System.out.print("Enter the index of the task you want to update: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (updateIndex >= 0 && updateIndex < taskManager.getTasks().size()) {
                        System.out.print("New title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("New description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("New due date: ");
                        String newDueDate = scanner.nextLine();
                        taskManager.updateTask(updateIndex, newTitle, newDescription, newDueDate);
                        System.out.println("Task updated successfully.");
                    } else {
                        System.out.println("Invalid task index. Task not updated.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the index of the task you want to delete: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();
                    taskManager.deleteTask(deleteIndex);
                    break;
                case 5:
                    List<Task> tasks = taskManager.getTasks();
                    for (Task t : tasks) {
                        System.out.println("Title: " + t.getTitle());
                        System.out.println("Description: " + t.getDescription());
                        System.out.println("Due Date: " + t.getDueDate());
                        System.out.println("Status: " + t.getStatus());
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}