package Monitor.RunnableEvent;

import Monitor.Event;
import Monitor.FileOperationCommand.FileOperationCommand;

import java.nio.file.Path;
import java.util.Objects;

public class DirectoryTargetEvent extends Event implements RunnableEvent {
    private FileOperationCommand command;

    public DirectoryTargetEvent(Path source, String extension, FileOperationCommand command) {
        super(source, extension);
        this.command = command;
        command.setMonitoredDirectory(source);
    }


    public DirectoryTargetEvent() {
    }

    @Override
    public boolean match(Event event) {

        return source.equals(event.getDirectory().getParent()) && extension.equals(event.getExtension());

    }
    @Override
    public void runCommand(Path fullSourcePath) {

        command.execute(fullSourcePath);
    }

    @Override
    public String toString() {
        return "DirectoryTargetEvent{" +
                "source=" + source +
                ", extension=" + extension +
                ", command=" + command + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectoryTargetEvent that = (DirectoryTargetEvent) o;
        return Objects.equals(command, that.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }
}
