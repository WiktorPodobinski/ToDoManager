import java.util.ArrayList;
import java.util.InputMismatchException;
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

	public static void completeTask(String taskIdStr) {
		try {
			int taskId = Integer.parseInt(taskIdStr);

			boolean taskFound = false;
			for (Task task : tasks) {
				if (task.getId() == taskId) {
					task.setCompleted(true);
					System.out.println("Task completed successfully!");
					taskFound = true;
					break;
				}
			}

			if (!taskFound) {
				System.out.println("Task not found");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid task ID provided. Please enter a valid integer.");
		}
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
		try {
			// Parse the input string to an integer
			if (taskId <= 0) {
				System.out.println("Invalid task ID provided. Please enter a valid integer.");
				return;
			}

			boolean taskFound = false;
			for (Task task : tasks) {
				if (task.getId() == taskId) {
					tasks.remove(task);
					System.out.println("Task removed successfully!");
					taskFound = true;
					break;
				}
			}

			if (!taskFound) {
				System.out.println("Task not found");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid task ID provided. Please try again.");
		}
	}






	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			displayMenu();
			try {
				if (scanner.hasNextInt()) {
					choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
						case 1 -> {
							System.out.print("Enter task name: ");
							String taskName = scanner.nextLine();
							addTask(taskName);
						}
						case 2 -> {
							System.out.print("Enter task ID to mark as complete: ");
							String taskIdStr = scanner.nextLine();
							try {
								int taskIdToComplete = Integer.parseInt(taskIdStr);
								completeTask(String.valueOf(taskIdToComplete));
							} catch (NumberFormatException e) {
								System.out.println("Invalid task ID provided. Please enter a valid integer.");
							}
						}
						case 3 -> listTasks();
						case 4 -> {
							System.out.print("Enter task ID to remove: ");
							String taskIdToRemoveStr = scanner.nextLine();
							try {
								int taskIdToRemove = Integer.parseInt(taskIdToRemoveStr);
								removeTask(taskIdToRemove);
							} catch (NumberFormatException e) {
								System.out.println("Invalid task ID provided. Please enter a valid integer.");
							}
						}
						case 0 -> System.out.println("Exiting the app. See you next time!");
						default -> System.out.println("Invalid choice. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a valid integer choice.");
					scanner.nextLine(); // Clear the input buffer
					choice = -1; // Set an invalid choice to continue the loop
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer choice.");
				scanner.nextLine(); // Clear the input buffer
				choice = -1; // Set an invalid choice to continue the loop
			}

			System.out.println(); // Add a line break
		} while (choice != 0);

		scanner.close();
	}


}