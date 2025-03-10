import java.util.Scanner;

public class ToDoList {
    private User user;
    private boolean isRunning;

    /**
     * Initializes the to-do list for the user.
     * @param user The user of the to-do list.
     */
    public ToDoList(User user) {
        this.user = user;
        this.isRunning = true;
    }

    /**
     * Displays the main menu to the user.
     */
    private void showMenu() {
        System.out.println("1. Show all items");
        System.out.println("2. Add an item");
        System.out.println("3. Mark an item as done");
        System.out.println("4. Mark an item as undone");
        System.out.println("5. Delete an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    /**
     * Loops the showMenu method based on the `isRunning` flag.
     */
    public void run() {
        while (isRunning) {
            showMenu();
        }
    }

    /**
     * Handles the user's choice, mapping the menu options to the corresponding methods.
     * @param choice The user's choice.
     */
    public void handleMenu(int choice) {
        switch (choice) {
            case 1:
                if (user.getToDoItems().isEmpty()) {
                    System.out.println("No items to show.");
                } else {
                    onShowAllItems();
                }
                break;
            case 2:
                onAddItem();
                break;
            case 3:
                if (user.getToDoItems().isEmpty()) {
                    System.out.println("No items to mark as done.");
                } else {
                    onMarkAsDone();
                }
                break;
            case 4:
                if (user.getToDoItems().isEmpty()) {
                    System.out.println("No items to mark as undone.");
                } else {
                    onMarkAsUndone();
                }
                break;
            case 5:
                if (user.getToDoItems().isEmpty()) {
                    System.out.println("No items to delete.");
                } else {
                    onDeleteItem();
                }
                break;
            case 6:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    /**
     * Displays all the items in the list.
     */
    public void onShowAllItems() {
        for (int i = 0; i < user.getToDoItems().size(); i++) {
            ToDoItem item = user.getToDoItems().get(i);
            if (item.isDone()) {
                System.out.println((i + 1) + ". [X] " + item.getDescription());
            } else {
                System.out.println((i + 1) + ". [ ] " + item.getDescription());
            }
        }
    }

    /**
     * Requests the user for a new item description and adds it to the list.
     */
    public void onAddItem() {
        System.out.print("Enter the description of the item: ");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        user.addItem(description);
    }

    /**
     * Requests the user for an item number and marks it as done.
     */
    public void onMarkAsDone() {
        onShowAllItems();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of the item to mark as done: ");
            if (scanner.hasNextInt()) {
                int itemNumber = scanner.nextInt() - 1;
                if (itemNumber >= 0 && itemNumber < user.getToDoItems().size()) {
                    user.setDone(itemNumber);
                    break;
                } else {
                    System.out.println("Item does not exist. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number");
                scanner.next();
            }
        }
    }

    /**
     * Requests the user for an item number and marks it as undone.
     */
    public void onMarkAsUndone() {
        onShowAllItems();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of the item to mark as undone: ");
            if (scanner.hasNextInt()) {
                int itemNumber = scanner.nextInt() - 1;
                if (itemNumber >= 0 && itemNumber < user.getToDoItems().size()) {
                    user.setUndone(itemNumber);
                    break;
                } else {
                    System.out.println("Item does not exist. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number");
                scanner.next();
            }
        }
    }

    /**
     * Requests the user for an item number and deletes it from the list.
     */
    public void onDeleteItem() {
        onShowAllItems();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of the item to delete: ");
            if (scanner.hasNextInt()) {
                int itemNumber = scanner.nextInt() - 1;
                if (itemNumber >= 0 && itemNumber < user.getToDoItems().size()) {
                    user.removeItem(itemNumber);
                    break;
                } else {
                    System.out.println("Item does not exist. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number");
                scanner.next();
            }
        }
    }

    /**
     * Exits the application, which sets the `isRunning` flag to false.
     */
    public void onExit() {
        isRunning = false;
    }
}
