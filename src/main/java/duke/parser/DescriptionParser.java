package duke.parser;

import duke.exception.DukeException;
import duke.task.EnumTask;
import duke.task.TaskDescription;

/**
 * A class that represents DescriptionParser.
 */
public class DescriptionParser implements Parser {
    /**
     * Returns a TaskDescription from a string with given index and task type.
     * @param taskType The type of the task.
     * @param input The input string.
     * @param index The index of the end of the command.
     * @return A TaskDescription containing the detail in the input.
     * @throws DukeException If error occurs during the process.
     */
    public static TaskDescription parseDescription(EnumTask taskType, String input, int index) throws DukeException {
        if (index == -1) {
            return new TaskDescription();
        }
        switch (taskType) {
        case TODO:
            return new TaskDescription(input.substring(index).trim());
        case DEADLINE:
            return new TaskDescription(input.substring(index).trim().split("/by"));
        case EVENT:
            return new TaskDescription(input.substring(index).trim().split("/at"));
        default:
            throw new DukeException("I do not know this task");
        }
    }
}