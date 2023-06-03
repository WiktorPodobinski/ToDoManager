public class Task {
private int id;
private String name;
private boolean completed;

public Task (int id, String name) {
	this.id = id;
	this.name = name;
	this.completed = false;
}

public int getId() {
	return id;
}
// add getters and setters later on
public void setCompleted(boolean completed) {
	this.completed = completed;
}

@Override
	public String toString() {
	return "[" + (completed ? "X" : " ") + "]" + name;
}
}
