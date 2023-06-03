import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {

	public static void displayMenu() {
		System.out.println("===== To-Do List Manager =====");
		System.out.println("1. Add a task");
		System.out.println("2. Complete a task");
		System.out.println("3. List tasks");
		System.out.println("4. Remove a task");
		System.out.println("0. Exit");
		System.out.println("==============================");
		System.out.print("Enter your choice: ");
	}

	public static ArrayList<Task> tasks = new ArrayList<>();
	private static int taskId = 1; // assign ID to task



	public static void addTask(String taskName) {
		Task task = new Task(taskId++, taskName);
		tasks.add(task);
		System.out.println("Task added successfully!");
	}

	public static void completeTask(int taskId) {
		// to find the task by ID + mark as completed
		for (Task task : tasks) {
			if (task.getId() == taskId) {
				task.setCompleted(true);
				System.out.println("Task completed successfully!");
				return;
			}
		}
		System.out.println("Task not found");
	}

	public static void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks found");
		} else {
			for (Task task : tasks) {
				System.out.println(task);
			}
		}
	}

	public static void removeTask(int taskId) {
		for (Task task : tasks) {
			if (task.getId() == taskId){
				tasks.remove(task);
				System.out.println("Task removed successfully!");
				return;
			}
		}
		System.out.println("Task not found");
	}
	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		int choice;
// used enhanced switch option automatically
		do {
			displayMenu();
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> {
					System.out.println("Enter task name: ");
					String taskName = scanner.nextLine();
					addTask(taskName);
				}
				case 2 -> {
					System.out.println("Enter task ID to mark as complete: ");
					int taskId = scanner.nextInt();
					scanner.nextLine();
					completeTask(taskId);
				}
				case 3 -> listTasks();
				case 4 -> {
					System.out.println("Enter task ID to remove: ");
					int taskIdToRemove = scanner.nextInt();
					scanner.nextLine();
					removeTask(taskIdToRemove);
				}
				case 0 -> System.out.println("Exiting the app. See you next time!");
				default -> System.out.println("Invalid choice. Please try again.");
			}

			System.out.println(); // just a line of break
		} while (choice != 0);
		scanner.close();
	}

}