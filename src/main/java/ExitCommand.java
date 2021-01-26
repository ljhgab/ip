public class ExitCommand extends Command {
    ExitCommand() {}

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.sayGoodBye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
