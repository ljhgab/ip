package duke.ui;

import duke.task.TaskList;
import duke.task.Task;

import java.util.Scanner;

/**
 * A class represents a UI.
 */
public class Ui {
    private static final String PARTING_LINE = "____________________________________________________________";

    /**
     * Returns an input from user.
     * @return A string of input from user.
     */
    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Prints the greeting message.
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(PARTING_LINE);
        System.out.println("Sup. I am Duke.");
        System.out.println("How can I help you?");
        System.out.println(PARTING_LINE);
    }

    /**
     * Prints a separating line.
     */
    public void printLine() {
        System.out.println(PARTING_LINE);
    }

    /**
     * Prints "See you" to the user.
     */
    public void sayGoodBye() {
        System.out.println(" See you.");
    }

    /**
     * Prints all the tasks in the TaskList.
     * @param tasks The TaskList to be printed.
     */
    public void listTasks(TaskList tasks) {
        System.out.println(" Here are the tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            Task tempTask = tasks.get(i);
            System.out.println(" " + (i + 1) + "." + tempTask);
        }
    }
}