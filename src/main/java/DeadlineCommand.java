import java.time.LocalDateTime;

public class DeadlineCommand extends AddCommand {
    String fullCommand;

    DeadlineCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Deadline deadline = getTask();
        super.addThisTask(tasks, deadline, storage);
    }

    @Override
    public Deadline getTask()
            throws DescriptionMissingException, InvalidDateTimeException {
        String nameDeadline = fullCommand.substring(8).strip();
        if (nameDeadline.equals("")) {
            throw new DescriptionMissingException("Argument missing!");
        }

        String[] nameAndDeadline = nameDeadline.split("/by");
        if (nameAndDeadline.length < 2) {
            throw new DescriptionMissingException("Argument missing!");
        }
        String name = nameAndDeadline[0].strip();
        String deadline = nameAndDeadline[1].strip();

        LocalDateTime cutOffTime = Parser.parseDateTime(deadline);
        return new Deadline(name, cutOffTime);
    }
}
