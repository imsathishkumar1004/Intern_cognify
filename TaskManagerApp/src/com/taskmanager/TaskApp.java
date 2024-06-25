package com.taskmanager;
import java.util.Scanner;
public class TaskApp {
	private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Is the task completed? (true/false): ");
        boolean completed = scanner.nextBoolean();
        scanner.nextLine(); 
        int id = taskManager.getTasks().size() + 1;
        Task task = new Task(id, name, description, completed);
        taskManager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        System.out.println("\nTasks:");
        for (Task task : taskManager.getTasks()) {
            System.out.println(task);
        }
    }

    private static void updateTask() {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        Task task = taskManager.getTaskById(id);
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        System.out.print("Enter new task name (current: " + task.getName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter new task description (current: " + task.getDescription() + "): ");
        String description = scanner.nextLine();
        System.out.print("Is the task completed? (current: " + task.isCompleted() + ") (true/false): ");
        boolean completed = scanner.nextBoolean();
        scanner.nextLine();  

        task.setName(name);
        task.setDescription(description);
        task.setCompleted(completed);

        taskManager.updateTask(task);
        System.out.println("Task updated successfully.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  

        taskManager.deleteTask(id);
        System.out.println("Task deleted successfully.");
 }

}
