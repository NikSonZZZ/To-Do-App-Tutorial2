public class ToDoItem {
    private String description;
    private boolean isDone;

    /**
     * Creates the new to-do item.
     * @param description The task description.
     */
    public ToDoItem(String description) {
        this.description = description;
        isDone = false;
    }

    /**
     * Returns the status of the to-do item.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns the description of the to-do item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the to-do item as done.
     */
    public void setDone() {
        isDone = true;
    }

    /**
     * Sets the to-do item as undone.
     */
    public void setUndone() {
        isDone = false;
    }
}