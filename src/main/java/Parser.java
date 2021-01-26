import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Parser {
    Parser() {}

    public static Command parseCommand(String input) throws DukeException {
        int endIndex = input.indexOf(" ");
        String potentialCommand = (endIndex == -1) ? input : input.substring(0, endIndex);
        Command command;

        if (potentialCommand.equalsIgnoreCase("TODO")) {
            command = new TodoCommand(input);
        } else if (potentialCommand.equalsIgnoreCase("DEADLINE")) {
            command = new DeadlineCommand(input);
        } else if (potentialCommand.equalsIgnoreCase("EVENT")) {
            command = new EventCommand(input);
        } else if (potentialCommand.equalsIgnoreCase("LIST")) {
            command = new ListCommand();
        } else if (potentialCommand.equalsIgnoreCase("DONE")) {
            command = new DoneCommand(input);
        } else if (potentialCommand.equalsIgnoreCase("BYE")) {
            command = new ExitCommand();
        } else if (potentialCommand.equalsIgnoreCase("DELETE")) {
            command = new DeleteCommand(input);
        } else {
            throw new CommandNotFoundException("What do you mean? I do not know this command.");
        }
        return command;
    }

    public static LocalDateTime parseDateTime(String dateTime) throws InvalidDateTimeException {
        String[] dateAndTime = dateTime.strip().split(" ");
        LocalDateTime parsedDateTime;

        if (dateAndTime.length != 2) {
            throw new InvalidDateTimeException("Input date and time is not complete.");
        }
        String date = dateAndTime[0].strip();
        String time = dateAndTime[1].strip();
        parsedDateTime = LocalDateTime.of(parseDate(date), parseTime(time));
        return parsedDateTime;

    }

    public static LocalDate parseDate(String date) throws InvalidDateTimeException {
        String[] yearMonthDay = date.strip().split("-");
        if (yearMonthDay.length != 3) {
            throw new InvalidDateTimeException("Input date is not valid.");
        }
        String year = yearMonthDay[0].strip();
        String month = yearMonthDay[1].strip();
        String day = yearMonthDay[2].strip();
        if (year.length() == 4 && month.length() == 2 && day.length() == 2) {
            try {
                return LocalDate.parse(date);
            } catch (DateTimeException e) {
                throw new InvalidDateTimeException("Input date is not valid.");
            }
        } else {
            throw new InvalidDateTimeException("Input date is not valid.");
        }
    }

    public static LocalTime parseTime(String time) throws InvalidDateTimeException {
        String hour = time.strip().substring(0, 2);
        String minute = time.strip().substring(2, 4);
        try {
            return LocalTime.parse(hour + ":" + minute);
        } catch (DateTimeParseException e) {
            throw new InvalidDateTimeException("Input time is not valid.");
        }
    }
}
